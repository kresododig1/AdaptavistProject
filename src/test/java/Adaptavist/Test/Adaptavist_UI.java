package Adaptavist.Test;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Adaptavist_UI {

    WebDriver driver;

    // I assigned these instances for reason if you want to run 2nd Test separately, but if you run it from
    // class level it will use javafaker library from 1st Test and re-assigned all the instances every time you run it!
    String firstName = "Mirko";
    String lastName = "Krolo";
    String email = "mirko.krolo@gmail.com";
    String password = "KroloMirko123";


    @BeforeMethod
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }


    @Test ( testName = "As a user, I should be able to create an account.", priority = 1)
    public void Create_Account(){

        //UserStory01

        // 1st step from TC01 - Go to the home page
        // - we handle this step in @BeforeMethod

        // 2nd step from TC01 - Click "Create an Account" link
        WebElement createAnAccountLink = driver.findElement(By.linkText("Create an Account"));
        createAnAccountLink.click();

        // 3rd step from TC01 - Enter valid "Personal Information" and valid "Sign-in information"
        WebElement firstNameInputBox = driver.findElement(By.cssSelector("input#firstname"));
        WebElement lastNameInputBox = driver.findElement(By.cssSelector("input#lastname"));
        WebElement emailInputBox = driver.findElement(By.cssSelector("input#email_address"));
        WebElement passwordInputBox = driver.findElement(By.cssSelector("input#password"));
        WebElement confirmPasswordInputBox = driver.findElement(By.cssSelector("input#password-confirmation"));


        Faker faker = new Faker();

        firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
        System.out.println("email = " + email);

        password = lastName + firstName + "123";
        System.out.println("password = " + password);

        firstNameInputBox.sendKeys(firstName, Keys.ENTER);
        lastNameInputBox.sendKeys(lastName, Keys.ENTER);
        emailInputBox.sendKeys(email, Keys.ENTER);
        passwordInputBox.sendKeys(password, Keys.ENTER);
        confirmPasswordInputBox.sendKeys(password);

        // 4th step from TC01 - Click on the "Create an Account" button
        WebElement createAccountButton = driver.findElement(By.xpath("//button[.='Create an Account']"));
        createAccountButton.click();

        // 5th step from TCO1 - New account is created
        WebElement message = driver.findElement(By.xpath("//div[.='Thank you for registering with Main Website Store.']"));

        String actualMessage = message.getText();
        String expectedMessage = "Thank you for registering with Main Website Store.";

        Assert.assertEquals(actualMessage, expectedMessage, "Message is NOT correct!!!");

        System.out.println("actualMessage = " + actualMessage);

    }



}
