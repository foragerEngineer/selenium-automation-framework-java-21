# Allure Report Setup For Automation Framework

##### Resources
- [Allure Report - Install for macOS](https://allurereport.org/docs/install-for-macos/)

# Install Allure Report for macOS
Allure Report can be installed on Linux from the Homebrew package repository or manually from an archive.

### Install from Homebrew
1. Make sure Homebrew is installed.
2. In a terminal, run this command:
```
brew install allure
```
3. Run this command to see if it reports the latest version:
```
allure --version
```
# Getting started with Allure

## Add Allure dependencies
```
<!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-testng -->
 <dependency>
   <groupId>io.qameta.allure</groupId>
   <artifactId>allure-testng</artifactId>
   <version>2.29.0</version>
 </dependency>
```

### Add an allure.properties file
1. Create a new file named `allure.properties` in inside of test/resources.
2. Add the following content to the file:
```
allure.results.directory=target/allure-results
```

# Starting the Allure server
1. Run the following command to start the Allure server:
```
allure serve target/allure-results
```
2. Open the following URL in a browser to view the Allure report:
```
http://localhost:4040
```
3. To stop the server, press `Ctrl+C` in the terminal.