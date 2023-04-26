# Automated tests for MOVEit

Based on Java and built on top of:
- Selenium WebDriver
- WebDriverManager 
- JUnit
- Logback
- Surefire
- Maven
- Page Object Model

The project can be initialized and fully usable once Maven imports all dependencies. If any issues occur please use manually the "Load Maven Changes" button.
In order to run all tests, use the following command: mvn clean test
If you would like to generate a test report please use: mvn clean test site

The test report with all the test data is generated to the path: move-automation-framework\target\site
The generated test report could be accessed from "index.html" file in the folder.

MOVEit is a automated and secure managed file transfers software owned by Progress Software [website](https://www.ipswitch.com/moveit)
