# Live Oak Bank Testing Framework

This is a Selenium-based testing framework for automating the web application at https://secure.liveoak.bank. The framework is built using Java, Cucumber, and JUnit, and it follows the Page Object Model design pattern.

## Getting Started

To get started with this project, you'll need to have the following prerequisites installed on your machine:

- Java Development Kit (JDK) 8 or higher
- Maven
- Git

### Installation

1. Clone the repository:

```
git clone https://github.com/valeriia-verb/live-oak-bank-framework.git
```

2. Navigate to the project directory:

```
cd live-oak-bank-framework
```

3. Build the project using Maven:

```
mvn clean install
```

### Running Tests

To run the tests, execute the following command:

```
mvn test
```

This will run all the tests in the project. You can also run specific tests by providing the appropriate tags or feature files.




- `src/main/java/com/live_oak/pages`: Contains the Page Object classes that represent the web pages of Live Oak Bank application.
- `src/main/java/com/live_oak/utilities`: Contains utility classes, such as the `Driver` class for managing the WebDriver instance and the `ConfigurationReader` class for reading configuration properties.
- `src/test/java/com/live_oak/runners`: Contains the `TestRunner` class, which is the test runner for Cucumber.
- `src/test/java/com/live_oak/step_definitions`: Contains the step definition classes that implement the Gherkin steps defined in the feature files.
- `src/test/resources/features`: Contains the feature files written in Gherkin syntax, which define the test scenarios.

### Technologies Used

- Java
- Selenium WebDriver
- Cucumber
- JUnit
- Maven
- Page Object Model (POM)

### Interviewers

This project is intended for the following interviewers:
Chris Scofield
