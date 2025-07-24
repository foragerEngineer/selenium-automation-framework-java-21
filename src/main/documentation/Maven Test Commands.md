# Maven Commands To Run Tests

To run tests in Maven, you can use the following commands via the terminal:

> Before running tests, ensure you run `mvn clean` to clean the project.
- `mvn clean test` - This will run all the tests in the project.
- `mvn clean test -Dsurefire=LetCodeWebTests` - This will run all the tests in the specified test class for LetCodeWebTests.
- `mvn clean test -Dsurefire=LetCodeWebTests#letCodeUiTest` - This will run the specified test method in the LetCodeWebTests class.
