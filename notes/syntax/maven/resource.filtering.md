`<filtering>`标签就像它的名字一样，起到过滤的作用，过滤就是将分隔符、属性名组成段替换为此次构建过程中定义的属性值。

> 首先要了解maven默认的构建规则，super pom [:link:](pom-4.0)

比如application.yml中有个属性是

```yaml
who: #me#
```

若此文件参与了打包和过滤、构建使用到：mvn clean compile -D me=her

那么在类的输出文件夹outputDirectory中将存在application.yml，内容是

```yaml
who: her
```

讨论

1. 如何通过resource标签自定义<u>参加打包的资源文件</u><sup>[1](#footnote1)</sup>？

   一个resource tag声明的directory对应一组资源，这组资源经过选择（includes）和排除（excludes）过程被决定是否参与到package goal，选择和排除谁都可以在前，但过程不同。比如声明的directory下**只有** a, b ,c, d, e, f 6个文件，那么

   ```xml
   <excludes>
       <exclude>a.txt</exclude>
       <exclude>b.txt</exclude>
   </excludes>
   <includes>
       <include>a.txt</include>
       <include>c.txt</include>
       <include>d.txt</include>
   </includes>
   ```

   经过上面操作，最终被打包的只有c.txt，d.txt两个文件。注意把directory下**所有文件**看作一个集合 A = {a, b ,c, d, e, f}。经过excludes，就是求排除的文件 {a, b} 在A中的差集 B（记得没错的话，又叫相对补集），B = {c, d, e, f}; B再经过includes，求文件集合 {a, c,
   d} 与 B 的交集 C，C = {c, d} 两个文件。

   反过来，

   ```xml
   <includes>
       <include>a.txt</include>
       <include>c.txt</include>
       <include>d.txt</include>
   </includes>
   <excludes>
       <exclude>a.txt</exclude>
       <exclude>b.txt</exclude>
   </excludes>
   ```

   includes求交集得到 {a, c, d}，excludes再求差集得到 {c, d}. 举的例子简单，为说清问题，实际使用时要结合文件、路径的全、半匹配

2. includes和excludes的规则？

   二者只有一层子孙，分别是include, exclude，分别表示选择和排除一（个）类文件，取值可以使用通配符\*，两个\*\*表示递归子文件夹。

3. 参加打包的资源文件是否被过滤取决于什么？

   是否被过滤仅取决于filtering的布尔值，是否被过滤是对经过上述选择、选中的文件，它们才是过滤行为的candidate。如果一个文件根本不会参与package这个声明周期，考虑是否会被过滤是没有意义的。

Spring Boot规范

```xml
<resources>
    <resource>
        <filtering>true</filtering>
        <directory>${basedir}/src/main/resources</directory>
        <includes>
            <include>**/application*.yml</include>
            <include>**/application*.yaml</include>
            <include>**/application*.properties</include>
        </includes>
    </resource>
    <resource>
        <directory>${basedir}/src/main/resources</directory>
        <excludes>
            <exclude>**/application*.yml</exclude>
            <exclude>**/application*.yaml</exclude>
            <exclude>**/application*.properties</exclude>
        </excludes>
    </resource>
</resources>
```

举例，对于复杂例子

```xml
<resource>
    <filtering>true</filtering>
    <directory>${pom.basedir}/a</directory>
    <includes>
        <include>**/b/c**/d.txt</include>
        <include>b/**/c.txt</include>
    </includes>
</resource>
<resource>
    <directory>${pom.basedir}/a</directory>
    <excludes>
        <exclude>**/b/cc*/*</exclude>
        <exclude>**/b/**/*c.txt</exclude>
    </excludes>
</resource>
<plugins>
    <plugin>
        <groupId>...</groupId>
        <artifactId>maven-resources-plugin</artifactId>
        <version>...</version>
        <configuration>
            <delimiters>
                <delimiter>love</delimiter>
            </delimiters>
            <useDefaultDelimiters>false</useDefaultDelimiters>
        </configuration>
    </plugin>
</plugins>
```

例子（maven Java 项目）：pom.xml

```xml
...
<build>
    <resources>
        <resource>
            <filtering>true</filtering>
            <directory>${pom.basedir}/a</directory>
            <includes>
                <include>**/b/a.txt</include>
                <include>**/c/*.txt</include>
                <include>**/*.yml</include>
            </includes>
        </resource>
        <resource>
            <filtering>false</filtering> <!-- false is default value -->
            <directory>${pom.basedir}/a</directory>
            <excludes>
                <exclude>**/d/file.txt</exclude>
            </excludes>
        </resource>
    </resources>
    <plugins>
        <plugin>
            <groupId>...</groupId>
            <artifactId>maven-resources-plugin</artifactId>
            <version>...</version>
            <configuration>
                <delimiters>
                    <delimiter>love</delimiter>
                </delimiters>
                <useDefaultDelimiters>false</useDefaultDelimiters>
            </configuration>
        </plugin>
    </plugins>
</build>
...
```

文件 ${pom.basedir}/a/config.yml 内容为：

```yaml
password: lovewholove
```

文件 ${pom.basedir}/a/b/c/config.yml 内容为：

```yaml
password: lovewholove
```

文件 ${pom.basedir}/a/b/a.txt 内容为：

```
lovearelove
```

文件 ${pom.basedir}/a/b/file.txt 内容为：

```
lovearelove
```

文件 ${pom.basedir}/a/c/d/file.txt 内容为：

```
loveyoulove
```

文件 ${pom.basedir}/a/c/file.txt 内容为：

```
loveyoulove
```

执行mvn clean compile -D who=myself -D are=youself -D you=herself

结果：

上面这组标签经常出现在自定义构建，当然也可以使用maven-assembly...这个plugin更自由地pack，但通常这样就够了。它声明了一组resource，这组资源位于directory下，具体又include、exclude目录下的那些文件，支持通配符（一个\*不会递归，两个\*递归）。filtering是讨论的重点，它表示是否从启动命令的Properties中选取同名的properties值来替换掉软编码的值。

当资源文件中有些属性经常变化，或者是隐私、秘密性的，比如私钥。这些不能在开源库中托管，或其它原因不能硬编码。可以利用maven-resources-plugin过滤来给这样的属性赋值，前提是编写了分隔符包裹的属性变量。

```xml
<plugin>
    <groupId>..</groupId>
    <artifactId>maven-resources-plugin</artifactId>
    <version>..</version>
    <configuration>
        <delimiters>
            <delimiter>PATTERN</delimiter>
        </delimiters>
        <useDefaultDelimiters>false</useDefaultDelimiters>
    </configuration>
</plugin>
```

在maven-resources-plugin的插件描述文件plugin.xml中，对PATTERN的描述是：

分隔符具体是 beginToken*endToken 的形式，如果没有 \* 出现在PATTERN中，那么就假设分隔符的开始、结束token相等（\* 的位置为属性名占位）。原话：

> These delimiters are specified in the form beginToken*endToken. If no * is given, the delimiter is assumed to be the same for start and end.

也就是如果 \<delimiter\> 给了 aa\*bb 那么用法是 **aa**PROPERTY_NAME**bb**，如果给的 love，用法就是 **love**PROPERTY_NAME**love**。对，分隔符可以取字母，当token特征性很低时，需要严格规定build.resources.resource.includes和
build.resources.resource.excludes，防止污染resources目录中其他的文件。

<a name="myfootnote1">1</a>: 这些文件通常是运行时需要的，或者想通过war、jar转移这些文件。比如属性文件（运行时需要），mapper文件（运行时需要），启动、关停、部署的脚本（方便和源文件一同转移到其他设备）。