# Test Automation Framework (Java + Selenium + TestNG)

A minimal Java-based automation framework that demonstrates Selenium web tests and REST API tests with TestNG.

## Structure
- `src/main/java/com/example/framework` - core framework utilities
- `src/test/java/com/example/tests` - sample web and API tests
- `src/test/resources` - TestNG suite and config

## Configuration
Edit `src/test/resources/config.properties`:
- `browser`: chrome | firefox | edge
- `headless`: true | false
- `web.baseUrl`: base URL for web tests
- `api.baseUrl`: base URL for API tests

## Run tests
Use the Maven Wrapper (recommended):
```bash
./mvnw test
```

Or use your system Maven:
```bash
mvn test
```

## Notes
- WebDriver binaries are managed by WebDriverManager.
- The TestNG suite is defined in `src/test/resources/testng.xml`.
