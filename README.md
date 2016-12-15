### Trust - Selenium Automation
---
#### System Requirement:

* JDK 1.6 or above
* Maven 3.1 or above
* Eclipse IDE or any other of choice in case there is need to update the script. (optional)
* For execution on Chrome you need to have executable files for both drivers respectively and paste them at location "\src\test\resources\drivers" in project folder.
* You can download these executable files from below links
  * Chrome: https://drive.google.com/file/d/0B4FqnK04LJRnNWZFOEE3Wjd4aFk/view

#### Execution Steps:
Please follow the instructions to execute the tests on your machine:

1. Checkout the code from SVN (BitBucket)
2. According to the Test Scope use following commands
  - To Execute the single test
	``` mvn clean integration-test -Dtest="Test name"```
    
#### Result Files:	
The Test Execution Results will be stored in the following directory once the test has completed

    ./target/test-output/emailable-report.html (for complete test suite)
    ./target/surefire-reports/emailable-report.html (for single test)
