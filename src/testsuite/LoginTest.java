package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
       @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        String expectedMessage = "Welcome Back!";

        //click on the ‘Sign In’ link
        WebElement signInField = driver.findElement(By.linkText("Sign In"));
        signInField.click();
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Welcome back message not displayed",expectedMessage,actualMessage);


    }
    @Test
    public void verifyTheErrorMessage(){


        //click on the ‘Sign In’ link
        WebElement signInField = driver.findElement(By.linkText("Sign In"));
        signInField.click();

        //Enter invalid username
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("xyz321@gmail.com");

        //Enter invalid password
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("xyz123");

        //Click on signIn button
        WebElement signInButton = driver.findElement(By.xpath("//div/input[@value='Sign in']"));
        signInButton.click();


        WebElement actualMessageElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageElement.getText();

        String expectedMessage = "Invalid email or password.";

        Assert.assertEquals("message not displayed",expectedMessage,actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
