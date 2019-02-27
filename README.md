# JUnit 5 Examples

Learning JUnit5 annotations methods etc.


## Required packages
- Java11
- Maven 3.5
- Apache Ant 1.10.x


## How to
run as follows:

```bash
$ mvn clean test
```

The 'antrun' plug-in will be invoked during the 'test' phase, 
which kicks the build.xml that has the Ant's 'junitreport'.


Or, to invoke reporting explicitly, do the following:

```bash
$ mvn clean test antrun:run@html
```



## NOTE: how to generate JUnit HTML Reports

It is much simpler to use Apache Ant Junit report task (junitreport)
than to use Maven surefire-report, so I used Ant task inside of it.

@see pom.xml plug-in part and build.xml file. 


