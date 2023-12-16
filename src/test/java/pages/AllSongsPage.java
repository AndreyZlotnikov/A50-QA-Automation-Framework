package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AllSongsPage extends BasePage {

    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public void goToAllSongs () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allSongsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='songs']")));
        //driver.findElement(By.cssSelector("a[class='songs']"));
        allSongsBtn.click();
        WebElement allSongsHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'All Songs')]")));
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
        WebElement pauseBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[data-testid='pause-btn']")));
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
