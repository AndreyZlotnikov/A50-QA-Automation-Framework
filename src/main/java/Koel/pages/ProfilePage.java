package Koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProfilePage extends BasePage {

    //WebElements

    @FindBy(css = "[class='avatar']")
    WebElement viewEditUserProfileBtn;
    //By viewEditUserProfileBtnLocator = By.cssSelector("[class='avatar']");

    @FindBy(xpath = "//h1[contains(text(), 'Profile & Preferences')]")
    WebElement pageTitle;
    //By pageTitleLocator = By.xpath("//h1[contains(text(), 'Profile & Preferences')]");

    @FindBy(css = "[id='inputProfileCurrentPassword']")
    WebElement currentPasswordField;
    //By currentPasswordFieldLocator = By.cssSelector("[id='inputProfileCurrentPassword']");

    @FindBy(css = "[id='inputProfileName']")
    WebElement nameField;
    //By nameFieldLocator = By.cssSelector("[id='inputProfileName']");

    @FindBy(css = "[id='inputProfileEmail']")
    WebElement emailAddressField;
    //By emailAddressFieldLocator = By.cssSelector("[id='inputProfileEmail']");

    @FindBy(css = "[id='inputProfileNewPassword']")
    WebElement newPasswordField;
    //By newPasswordFieldLocator = By.cssSelector("[id='inputProfileNewPassword']");

    @FindBy(css = "[class='btn-submit']")
    WebElement saveBtn;
    //By saveBtnLocator = By.cssSelector("[class='btn-submit']");

    @FindBy(xpath = "//div[contains(text(), 'Profile updated')]")
    WebElement successBanner;
    //By successBannerLocator = By.xpath("//div[contains(text(), 'Profile updated')]");

    public ProfilePage (WebDriver givenDriver) {

        super(givenDriver);
}


    public void goToProfilePage () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //ebElement viewEditUserProfileBtn = wait.until(ExpectedConditions.elementToBeClickable(viewEditUserProfileBtnLocator));
        wait.until(ExpectedConditions.elementToBeClickable(viewEditUserProfileBtn));
        viewEditUserProfileBtn.click();
        //WebElement pageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(pageTitleLocator));
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        Assert.assertTrue(pageTitle.isDisplayed());
    }

    public void fillInCurrentPasswordField (String currentPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement currentPasswordField = wait.until(ExpectedConditions.elementToBeClickable(currentPasswordFieldLocator));
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }

    public void fillInNameField (String newUserName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(nameFieldLocator));
        nameField.click();
        nameField.clear();
        nameField.sendKeys(newUserName);
    }

    public void fillInEmailAddress (String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement emailAddressField = wait.until(ExpectedConditions.elementToBeClickable(emailAddressFieldLocator));
        emailAddressField.click();
        emailAddressField.clear();
        emailAddressField.sendKeys(email);
    }

    public void fillInNewPasswordField   (String newPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement newPasswordField = wait.until(ExpectedConditions.elementToBeClickable(newPasswordFieldLocator));
        newPasswordField.click();
        newPasswordField.clear();
        newPasswordField.sendKeys(newPassword);
    }

    public void clickSaveBtn () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveBtnLocator));
        saveBtn.click();
    }

    public void assertUserNameRenamed () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(successBannerLocator));
        wait.until(ExpectedConditions.visibilityOf(successBanner));
        Assert.assertTrue(successBanner.isDisplayed());

    }
}
