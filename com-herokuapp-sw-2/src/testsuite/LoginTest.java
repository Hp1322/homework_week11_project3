package testsuite;

import broserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
      //Find username field element
        WebElement userName = driver.findElement(By.id("username"));
        //Sending username to username field
        userName.sendKeys("tomsmith");

        //Find password field element
        WebElement password = driver.findElement(By.name("password"));
        //Sending password to password field
        password.sendKeys("SuperSecretPassword!");

        //Find log in button and click on it
        WebElement logButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        logButton.click();

        //Verify the text "Secure Area"
        //This is from requirement
        String expectedMessage = "Secure Area";

        //Actual result
        WebElement actualResult = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/h2[1]"));
        String actualMessage = actualResult.getText();

        //Validate expected message and actual message
        Assert.assertEquals("unable to navigate on log in page", expectedMessage, actualMessage);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Find username field
        WebElement userName1 = driver.findElement(By.name("username"));
        //Sending username to username field element
        userName1.sendKeys("tomsmith1");

        //Find password field
        WebElement password1 = driver.findElement(By.id("password"));
        //Sending password to password field element
        password1.sendKeys("SuperSecretPassword!");

        //Find login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();

        //Verify the error message “Your username is invalid!”
        //This is from requirement
        String expectedMessage1 = "Your username is invalid!\n" +
                "×";

        //Actual result
        WebElement actual = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage1 = actual.getText();

        //Validate expected message and actual message
       Assert.assertEquals("not navigate to invalid page", expectedMessage1, actualMessage1);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Find username field
        WebElement userName2 = driver.findElement(By.name("username"));
        //Sending username to username field element
        userName2.sendKeys("tomsmith");

        //Find password field
        WebElement password2 = driver.findElement(By.id("password"));
        //Sending password to password field element
        password2.sendKeys("SuperSecretPassword");

        //Find login button and click on it
        WebElement loginButton3 = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton3.click();

        //Verify the error message “ Your password is invalid!”
        //This is from requirement
        String expectedMessage2 = "Your password is invalid!\n" +
                "×";

        //Actual result
        WebElement actual = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage2 = actual.getText();

        //Validate expected message and actual message
        Assert.assertEquals("not navigate to invalid password page", expectedMessage2, actualMessage2);
    }
    //Closing browser
    @After
    public void tearDown(){
        closeBrowser();
    }

}
