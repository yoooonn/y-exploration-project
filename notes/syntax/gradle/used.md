##### gradle :[taskName] -b [gradleFile]


##### gradlew tasks --all

列出所有任务

##### gradlew :buildSrc

在导入idea之后，自动执行的就是这个命令

##### gradlew clean

清理所有module的编译产物（build文件夹）



##### gradlew :[moduleName]:dependencies

列出moduleName所有依赖的树形图



##### graldew :[moduleName]:[taskName]

编译moduleName这个module中的taskName这个task。

在springframework源码5.2.x，import-into-idea.md文件中steps部分说Precompile `spring-oxm` with `./gradlew :spring-oxm:compileTestJava`，让我们先编译`spring-oxm`的test部分。这个命令就使用到了`graldew :[moduleName]:[taskName]`



