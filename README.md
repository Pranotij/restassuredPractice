RestAssured Framework
Overview

This project is a REST API automation framework built using Java 21, TestNG, and RestAssured.
It is designed to test weather APIs and supports:

Single and multiple cities

Latitude/Longitude coordinates

Forecast data

Invalid scenarios (invalid city names, coordinates, API keys)

The framework uses:

Builder Pattern for request objects

DataProviders for parameterized tests

Validators for response verification

Utility classes for config, logging, and helper functions

Project Structure
restassured-framework/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/api/
│   │   │       ├── base/                    
│   │   │       │   └── BaseTest.java        # Base class for test initialization
│   │   │       ├── helper/                  
│   │   │       │   ├── CurrentLocationHelper.java
│   │   │       │   ├── ForecastLocationHelper.java
│   │   │       │   
│   │   │       ├── pojo/                    
│   │   │       │   ├── currentLocation/Valid/
│   │   │       │   ├── forecastData/
│   │   │       │   ├── latLongg/Valid/
│   │   │       │   ├── multipleCities/Valid/
│   │   │       │   └── Invalid/
│   │   │       ├── utils/                    
│   │   │       │   ├── ConfigReader.java    
│   │   │       │   ├── APILogger.java       
│   │   │       │   └── HelperUtil.java      
│   │   │       └── interfaces/              
│   │   │           └── Endpoints.java       # API endpoint interface
│   │   │
│   │   └── validators/                      
│   │       └── BasicValidator.java          # Base response validation logic
│   │
│   └── test/
│       ├── java/
│       │   ├── tests/                        # Test classes
│       │   │   └── WeatherByLocationTests.java
│       │   ├── dataproviders/                # TestNG DataProviders
│       │   │   ├── WeatherDataProvider.java
│       │   │   └── APIKeyDataProviders.java
│       │   └── validators/                   # Test validators
│       │       └── LocationValidator.java
│       └── resources/
│           └── testng.xml                    # TestNG suite configuration
│
├── build.gradle                              # Gradle build file
└── README.md

Key Features

Java 21 compatibility using Gradle toolchain

RestAssured 5.4.0 for API requests

TestNG 7.12.0 for test execution

Builder Pattern for clean request objects

Parameterized tests using DataProviders

Validators for structured response assertions

Utility classes:

ConfigReader → read configuration properties

APILogger → centralized API request/response logging

HelperUtil → common helper methods

Endpoints interface for managing API URLs in one place

Logging with SLF4J + Logback

Dependencies

Java 21

Gradle 8+

RestAssured 5.4.0

TestNG 7.12.0

Jackson Databind 2.17.0

SLF4J 2.0.13

Logback Classic 1.4.14

Running Tests

Import the project in IntelliJ IDEA or another IDE.

Ensure Java 21 JDK is installed.

Run all tests using Gradle:

./gradlew clean test


Or run a TestNG XML suite:

./gradlew test -DsuiteXmlFile=src/test/resources/testng.xml

Test Reports

After execution, reports are generated at:

HTML Report: build/reports/tests/test/index.html

JUnit XML Report: build/test-results/test/

Adding New Tests

Create POJOs for new requests/responses if required.

Add helper methods in the appropriate helper class.

Create DataProvider entries in the dataproviders package.

Add a TestNG test class using:

@Test(dataProvider = "name", dataProviderClass = DataProviderClass.class)

Notes

ignoreFailures = true ensures Gradle does not fail if no tests are discovered.

Use valid API keys when testing live endpoints.

Validators in validators and BasicValidator ensure consistent assertion logic.
