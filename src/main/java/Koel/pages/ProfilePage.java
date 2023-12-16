package Koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProfilePage extends BasePage {

    public ProfilePage (WebDriver givenDriver) {

        super(givenDriver);
}
    public void goToProfilePage () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewEditUserProfileBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='avatar']")));
        viewEditUserProfileBtn.click();
        WebElement pageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Profile & Preferences')]")));
        //Assert.assertTrue(pageTitle.isDisplayed());
    }

    public void fillInCurrentPasswordField (String currentPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement currentPasswordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='inputProfileCurrentPassword']")));
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }

    public void fillInNameField (String newUserName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='inputProfileName']")));
        nameField.click();
        nameField.clear();
        nameField.sendKeys(newUserName);
    }

    public void fillInEmailAddress (String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailAddressField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='inputProfileEmail']")));
        emailAddressField.click();
        emailAddressField.clear();
        emailAddressField.sendKeys(email);
    }

    public void fillInNewPasswordField   (String newPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newPasswordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='inputProfileNewPassword']")));
        newPasswordField.click();
        newPasswordField.clear();
        newPasswordField.sendKeys(newPassword);
    }

    public void clickSaveBtn () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn-submit']")));
        saveBtn.click();
    }

    public void assertUserNameRenamed () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successBunner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Profile updated')]")));
        Assert.assertTrue(successBunner.isDisplayed());

    }
}
