=========== HavenLife-Automation Test Project ===================================
In order to execute the project:

Open command prompt
Go to where POM.xml is located
Then type "mvn clean verify"
Note: For First time run, Maven will download all the dependencies, Go and Grab some coffee..
Now your execution will start.
Below are the test results
Detailed and fluid test results are found at: target/site/serenity/index.html
Excel format results: target/site/serenity/results.csv
XML format results for CI parsing: target/surefire/*.*xml


//For Better test management we can create profile for regression, smoke or release specific tests 
Eg:
REGRESSION SUITE: "mvn clean verify -P regression -Dwebdriver.diver=firefox"
SMOKE TEST SUITE: "mvn clean verify -P smoketests"
so on....

//** You can pass the URLs and WebDrivers from command prompt itself with -D prefix
//** Data driven is not implemented, so some part of methods are hard coded

