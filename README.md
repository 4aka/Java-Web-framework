**Before testing make sure that you have already set JAVA_HOME

## Web testing in Chrome browser 

To run test in terminal:
1. Download the project
2. Open terminal and go to the project root directory
3. Run command 

`mvn clean -Dsuite=functional.xml -Dwebdriver.platform=CHROME test`

## Reports
To generate Allure Reports run command:

`allure:serve` or `allure:report`

Make sure that all required packages are installed! 
