package Koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {



    @Test
    public void registrationNavigation() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*"); // resolve issue with web socket error
        //WebDriver driver = new ChromeDriver(options);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        getDriver().get(url); //open page

        WebElement registrationBtn = getDriver().findElement(By.cssSelector("[href='registration']"));
        registrationBtn.click();


        WebElement submitBtn = getDriver().findElement(By.cssSelector("[id='button']"));

        Assert.assertTrue(submitBtn.isDisplayed());
        getDriver().quit();
    }
}