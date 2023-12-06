import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver = null;
    protected String url = "https://qa.koel.app/";
    @BeforeMethod
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url); //open page
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void closerDriver() {
        getDriver().quit();
    }

    public void logIn (String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement logInBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        logInBtn.click();

    }

    public void goToAllSongs () {
        WebElement allSongsBtn = driver.findElement(By.cssSelector("a[class='songs']"));
        allSongsBtn.click();
    }

}