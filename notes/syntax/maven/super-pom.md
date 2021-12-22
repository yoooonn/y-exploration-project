super pom是文件pom-4.0.0.xml

位置

当前v，3.6.3

解压MAVEN_HOME/lib/maven-model-builder-3.6.3.jar到一个位置，cd到上面文件夹，然后

```
> unzip maven-model-builder-3.6.3.jar -d ~/Documents/temp/maven-model-builder-3.6.3
...
> cd ~/Documents/temp/maven-model-builder-3.6.3/org/apache/maven/model
> ls
...
pom-4.0.0.xml
> cat pom-4.0.0.xml
```

一些它的说明super pom.xml [:link:](super-pom.xml)

层层依赖之后，一个module的最终pom.xml文件的组成，可以使用命令 [:link:](used.md/#mvn-helpeffective-pom)

对于Java，maven默认module的结构

<img src="../../../assets/default-maven-java-struc.png" alt="default-maven-java-struc"/>

src/main/java:           源文件

src/main/resources: 源文件需要的资源

src/test/java:              测试文件

src/test/resources:    测试文件需要的资源

target/classes:            源文件编译后的位置

target/test-classes:    测试文件编译后的位置

另外两个gen...包是IDEA的产物，是.idea/compiler.xml节点project.component.annotationProcessing声明的

这就是super pom主要的工作，要注意的是当自定义build.resources时，原来的build.resources定义的两个resource tag都将被覆盖。build.testResources同理。

此project的modules、leet-code文件夹都包含了module，有继承关系，构建规则的用法。
