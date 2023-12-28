package stepDefinition;

import Koel.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefinition {
    protected String url = "https://qa.koel.app/";
    private WebDriver driver;

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }
    @Given("I open Login page")
    public void iOpenLoginPage() {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
    @After
    public void closerDriver() {
        getDriver().quit();
    }

    @When("I fill in email field {string} and password field {string} with valid credentials and click submit button")
    public void logIn(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(getDriver());
        //WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        //driver.findElement(By.cssSelector("input[type='email']"));
        loginPage.logIn(email, password);
        //loginPage.emailField.click();
        //emailField.clear();
       // emailField.sendKeys(email);

        //WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        //driver.findElement(By.cssSelector("input[type='password']"));
        //passwordField.click();
        //passwordField.clear();
        //passwordField.sendKeys(password);

        //WebElement logInBtn = wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocator));
        //driver.findElement(By.cssSelector("button[type='submit']"));
        //logInBtn.click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.isLogOutBtnDisplayed();
    }
}
