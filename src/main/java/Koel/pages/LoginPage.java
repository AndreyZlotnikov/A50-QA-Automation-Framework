package Koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    //locators
    By emailFieldLocator = By.cssSelector("input[type='email']");
    By passwordFieldLocator = By.cssSelector("input[type='password']");
    By loginBtnLocator = By.cssSelector("button[type='submit']");

    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }


    public void logIn (String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        //driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        //driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement logInBtn = wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocator));
        //driver.findElement(By.cssSelector("button[type='submit']"));
        logInBtn.click();

    }
}
