##### mvn help:effective-settings

- 查看当前项目生效的`settings.xml`文件

##### mvn help:active-profiles

- 如果当前项目设置了`profiles`节点，则显示生效的`profile`；没有设置显示的列表是空的

##### mvn help:effective-pom

- 比较重要。查看当前生效的`pom`配置，当设置了构建规则却未生效，可查看此命令的结果是不是自己预期的。可结合`>`输出重定向到文件。文件比较大，因为继承了super pom或者自己项目定义的继承、传递规则。

##### mvn help:active-profiles

- 当前生效的profiles

##### Mvn help:all-profiles

- 所有profiles