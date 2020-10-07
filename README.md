# webuildsg
## This project carries out automation testing for webuildsg website for the main page and a few pages called from the main page
##Prerequisites
Install Eclipse, Maven,TestNG

##Technologies
Java-Selenium

###Class files
####Test Classes
* BaseTest.java:It has all the functions commonly used by all the pages. It includes functions to load the config file, Initializing webdriver, adding waits etc.
* MainPageTest.java: Test cases to test the main page functionalities
* ReposPerPLTest.java: Test cases to test the repositories per programming language page functionalities
* ActiveUserGrpTest.java: Test cases to test the Active user groups page functionalities

####Page Classes
* MainPage.java: Test cases to test the main page functionalities
* ReposPerPLPage.java: Test cases to test the repositories per programming language page functionalities
* ActiveUserGrpPage.java: Test cases to test the Active user groups page functionalities

####Framework: Page Object Model

##Author
Arthee Raghunathan--Initial work
