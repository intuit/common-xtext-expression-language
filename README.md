# Common-Expression-Language
![common-xtext-expression-language logo](./common-xtext-expression-language-logo.png)
The project provides an expression language built using [Xtext](https://www.eclipse.org/Xtext/index.html) and a runtime engine to evaluate the expressions. 
The expression grammar can be imported in other Xtext DSLs to create composable and reusable languages using Xtext. 

# Usage

1. Add the maven dependency
```xml
  <groupId>com.intuit.dsl.expression</groupId>  
  <artifactId>com.intuit.dsl.expression.runtime</artifactId>
  <version>${latest}</version>
```
2. Code usage 

```java 
   DataValue value = ExpressionRuntime.newExpressionRuntime()
                           .withExpressionContent(expressionString)
                           .evaluate();
```

# Setting up the Project 

### Pre-requisites

1. Java 8
2. Maven 3

### Making changes to Runtime

* Clone [common-xtext-expression-language](https://github.com/intuit/common-xtext-expression-language)
* Run `maven clean install`
* Import the runtime module `com.intuit.dsl.expression.runtime`. This is standard java project which can be imported in your 
favorite editor. 

### Making changes to Expression Grammar

1. Download and install Eclipse [MAC](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-03/R/eclipse-inst-mac64.dmg) 
/ [Windows](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-03/R/eclipse-inst-win64.exe)
/ [Linux](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-03/R/eclipse-inst-linux64.tar.gz). 
2. Install Xtext SDK in Eclipse:  
   a. In Eclipse, click Help --> Install New Software  
   b. In Available Software, click Add to add a repository with location: http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/  
   c. Select the repository just added in 'Work with' dropdown
   e. Select and install Xtext Complete SDK 
3. Restart Eclipse.
4. Edit the [grammar](https://github.com/intuit/common-xtext-expression-language/blob/master/com.intuit.dsl.expression.parent/com.intuit.dsl.expression/src/com/intuit/dsl/Expression.xtext)
5. Right click on [GenerateExpression.mwe2](https://github.com/intuit/common-xtext-expression-language/blob/master/com.intuit.dsl.expression.parent/com.intuit.dsl.expression/src/com/intuit/dsl/GenerateExpression.mwe2). 
Run As --> 1 MWE2 Workflow. 

    OR 

    `mvn clean install` inside the project

You should be able to use the grammar changes in your runtime.

## Formatting
Read the [Contribution guide](./CONTRIBUTING.md)
