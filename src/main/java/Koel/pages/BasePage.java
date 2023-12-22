package Koel.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import java.time.Duration;

import static java.lang.Thread.sleep;

public class BasePage {

    public WebDriver driver = null;


    public BasePage(WebDriver givenDriver) {

        this.driver = givenDriver;
        PageFactory.initElements(driver, this);
    }

}


