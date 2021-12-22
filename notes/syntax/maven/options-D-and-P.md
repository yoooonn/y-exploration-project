`mvn -D` 和 `mvn -P`

- `-D`即`--define`，pom.xml中使用的属性是非设不可的，不然无法通过编译
- `-P`即`--active-profiles`

网站`mvnbook.com`中说到这个，其中-P的两个例子

- 第一个很好理解，`mvn <goal> -P <profileId>`即可用对应`profile`执行当前`goal`
- 第二个是说也可以在activation标签被设置的的前提下，传递满足它的条件来使用它所在的`profile`，即`mvn <goal> -P <name=value>`

理解这些option，可以不依赖IDEA，仅一个黑框框terminal，能对项目进行构建、打包、测试、部署特别爽。另外，理解这些原理再去弄IDEA、解放双手，到时，click 还是 type，emmm:smile:

对于 --define，点击 setting--Build, Execution, Deployment--Build Toolds--Maven--Runner-->Properties，可以在这里设置全局的mvn的属性，for current project 还是 for new project 取决于自己。另外此project的normal-usage-explore-jdk-11在编译时就需要一个属性，详见pom.

对于 --active-profiles，在IDEA侧边maven工具窗口（或view--tool windows），只有设置了profiles才会出现。

