# Adaptavist project


### Test Automation with Selenium and TestNG for UI, and Automation Testing with RestAssured and TestNG for API part of the project

This project utilizes Selenium WebDriver and TestNG for automated testing of an e-commerce platform. The tests are written in Java and cover functionalities such as user account creation, login with valid credentials, and product search.

This project also demonstrates RESTful API testing using RestAssured in conjunction with TestNG. The tests cover various CRUD operations on the ReqRes API.

The `baseURI` is `https://reqres.in` and `basePath` is `"/api/users"` for API part of this project


Here is the [link](https://magento.softwaretestingboard.com/) to home page of UI part of this project

### Steps to Create Project
1.Create a maven project called `KAdaptavistProject`

2.Under `pom.xml`
   1.add below property section
```xml
<properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
```
2.Add dependencies
```xml
 <dependencies>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.16.1</version>
        </dependency>


        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.3.2</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.12.4</version>
        </dependency>

        <dependency>
            <groupId>com.github.javafaker</groupId>
            <artifactId>javafaker</artifactId>
            <version>1.0.2</version>
        </dependency>


        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.9.0</version>
            <scope>test</scope>
        </dependency>


    </dependencies>
```
3.Add build plugins
```xml
 <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>8</source>
                    <target>8</target>
                </configuration>
            </plugin>

            
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
4.Create a package called `Adaptavist` under `src/test/java`
1. Under Adaptavist create `Test` package
2. Create a class called `Adaptavist_UI`
* use annotations  `@BeforeMethod`, `@AfterMethod` and `@Test` coming from `import org.testng.annotations.*;`
3. Create a class called `Adaptavist_API`
* use annotations  `@BeforeMethod`, `@AfterMethod` and `@Test` coming from `import org.testng.annotations.*;`
* use `Rest Assured` coming from `import static io.restassured.RestAssured.*;` to run requests