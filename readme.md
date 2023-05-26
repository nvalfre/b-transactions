### Project Name
Project Name is a Java-based application for managing prices.

### Features

    Retrieve price information based on date, product ID, and brand ID.
    Perform CRUD operations on prices.

### Prerequisites

    Java 17 or higher
    Gradle

### Getting Started

#### Clone the repository:

    git clone https://github.com/your-username/project-name.git

#### Build the project:

    cd project-name
    ./gradlew clean build 

#### Test application:

    ./gradlew test integrationTest

#### Run the application:

    mvn spring-boot:run

The application will be accessible at http://localhost:8080.

### API Documentation
For detailed API documentation, refer to the Swagger API Documentation.

#### cUrl example
    curl --location --request GET 'http://localhost:8080/prices?start_date=2020-06-14T00:00:00&product_id=35455&brand_id=1'

### Configuration
You can configure the application by modifying the application.properties file.

### Contributing
Contributions are welcome! Please follow the guidelines in CONTRIBUTING.md.

### License
This project is licensed under the MIT License.
