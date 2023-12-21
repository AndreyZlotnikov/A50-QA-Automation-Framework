package Koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class AllSongsPage extends BasePage {

    //WebElements

    @FindBy(css = "a[class='songs']")
    WebElement allSongsBtn;
    //By allSongsBtnLocator = By.cssSelector("a[class='songs']");

    @FindBy(xpath = "//h1[contains(text(), 'All Songs')]")
    WebElement allSongsHeading;
    //By allSongsHeadingLocator = By.xpath("//h1[contains(text(), 'All Songs')]");

    @FindBy(css = "span[data-testid='pause-btn']")
    WebElement pauseBtn;
    //By pauseBtnLocator = By.cssSelector("span[data-testid='pause-btn']");

    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }


    public void goToAllSongs () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement allSongsBtn = wait.until(ExpectedConditions.elementToBeClickable(allSongsBtnLocator));
        //driver.findElement(By.cssSelector("a[class='songs']"));
        allSongsBtn.click();
        //WebElement allSongsHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(allSongsHeadingLocator));
        //driver.findElement(By.xpath("//h1[contains(text(), 'All Songs')]"));
        Assert.assertTrue(allSongsHeading.isDisplayed());
    }

    public void selectSong (String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), '" + title + "')]")));
        //driver.findElement(By.xpath("//td[contains(text(), '" + title + "')]"));
        song.click();
    }

    public void playSelectedSong (String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), '" + title + "')]")));
        //driver.findElement(By.xpath("//td[contains(text(), '" + title + "')]"));
        actions.doubleClick(song).perform();
        //WebElement pauseBtn = wait.until(ExpectedConditions.presenceOfElementLocated(pauseBtnLocator));
        //driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));
        actions.moveToElement(pauseBtn).perform();
        //Thread.sleep(3000);
        Assert.assertTrue(pauseBtn.isDisplayed());
        WebElement bannerOfPlayingSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), '" + title + "')]")));
        //driver.findElement(By.xpath("//h3[contains(text(), '" + title + "')]"));
        String titleOfPlayingSong = bannerOfPlayingSong.getText();
        Assert.assertEquals(titleOfPlayingSong, title);
    }
}
