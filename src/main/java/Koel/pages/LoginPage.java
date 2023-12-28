package Koel.pages;

import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {

    //WebElements
    @FindBy (css = "input[type='email']")
    WebElement emailField;
    //By emailFieldLocator = By.cssSelector("input[type='email']");

    @FindBy (css = "input[type='password']")
    WebElement passwordField;
    //By passwordFieldLocator = By.cssSelector("input[type='password']");

    @FindBy (css = "button[type='submit']")
    WebElement logInBtn;
    //By loginBtnLocator = By.cssSelector("button[type='submit']");

    @FindBy (css = "[class='logout control']")
    WebElement logOutBtn;

    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }


    public void logIn (String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        //driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);

        //WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        //driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

        //WebElement logInBtn = wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocator));
        //driver.findElement(By.cssSelector("button[type='submit']"));
        logInBtn.click();

    }

    public void isLogOutBtnDisplayed (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logOutBtn));
        Assert.assertTrue(logOutBtn.isDisplayed());
    }
}
