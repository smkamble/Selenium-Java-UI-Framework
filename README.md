### Selenium with Java Framework

<p align="center">
   <i><strong>This project demonstrates the selenium-java-ui framework.
</strong></i>
<p>
<p align="center">
  <a href="https://www.selenium.dev/documentation/">Selenium Documentation</a> |
</p>

### Introduction 
This is Test Automation framework designed using Selenium and Java for Web testing and to be used by QA Engineer.

### Framework Structure
```
├───src                                   # This folder test cases, pages and resources
│   └───main                              # This folder contains external pieces of static data that can be used by your tests
│   │    └───java/com/stackoverflow       # This folder contains page file and utilities
│   │    │   └───pages                    # This folder contains page file 
│   │    │   └───utilities                # This contains utilities file 
│   │    └───resources                    # This folder contains properties
│   └───test/java/com/stackoverflow       # This contains tests
├───test-output                           # This folder contains extend html report
├───pom.xml                               # This file contains information of project and configuration information for the maven to build the project
└───testng_runner.xml                     # This file contains configuration file that helps in organizing our tests.
```
### Tools and Technologies
Maven 
Java installed and setup
```
```
### Prerequisite:
* Download and install Chrome browser.
* Download and install Java:
  * [Install Node.JS](https://www.oracle.com/in/java/technologies/javase-downloads.html  "Install Java")
* Download and install any Text Editor like Intellij
  * [Install Intellij](https://www.jetbrains.com/idea/download/ "Install Intellij")
```
```
### Setup Scripts and How to Run Test
* Clone the repository into a folder 
* Go to Project root directory and and Run complete Test using command: `mvn clean test`
