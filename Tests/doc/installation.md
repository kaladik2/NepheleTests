# Pre-requisites
- <a href="https://java.com/en/download/manual.jsp" target="_blank">Java</a>
- <a href="https://maven.apache.org/download.cgi" target="_blank">Maven</a>
- <a href="https:https://eclipse.org/downloads/" target="_blank">Eclipse</a>
- Eclipse Plugins
  - <a href="https://www.eclipse.org/m2e/" target="_blank">Maven</a> 
  - <a href="https://marketplace.eclipse.org/content/cucumber-eclipse-plugin" target="_blank">Cucumber</a>
  
# Setting up selenium-cucumber-java
- Install Java and set path.
- Install Maven and set path.
- Clone respective repository or download zip.
	
  
# Running features
- Goto project directory.
- Use "mvn test" command to run features.
- Use "mvn test -Dbrowser=browser_name" to run features on specific browser.
- browser_name can be one of following but make sure that browser’s driver file are present and specified in system variable.
-- ff
-- chrome
-- ie
-- safari
- Use mvn test -Dcucumber.options="classpath:features/my_first.feature" to run specific feature if you have multiple feature files.
- Use mvn test -Dcucumber.options="–-plugin html:target/result-html" to generate a HTML report.
- Use mvn test -Dcucumber.options="–-plugin json:target/result-json" to generate a JSON report.