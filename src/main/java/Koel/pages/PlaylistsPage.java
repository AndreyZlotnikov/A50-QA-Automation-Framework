package Koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class PlaylistsPage extends BasePage {
    //locators
    By createNewPlaylistBtnLocator = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    By newPlaylistContextMenuBtnLocator = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By newPlaylistNameFieldLocator = By.cssSelector("input[name='name']");
    By successBannerLocator = By.cssSelector("div[ class='success show']");
    By addToBtnLocator = By.cssSelector("button[class='btn-add-to']");
    By deletePlaylistBtnLocator = By.cssSelector("[class='del btn-delete-playlist']");
    By editBtnLocator = By.xpath("//nav[@class='menu playlist-item-menu']//li[contains(text(), 'Edit')]");
    By enterPlaylistNameFieldLocator = By.xpath("//input[@data-testid='inline-playlist-name-input']");

    public PlaylistsPage (WebDriver givenDriver) {
        super(givenDriver);
    }



    public void createPlaylist (String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(createNewPlaylistBtnLocator));
        //driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        createNewPlaylistBtn.click();
        WebElement newPlaylistContextMenuBtn = wait.until(ExpectedConditions.elementToBeClickable(newPlaylistContextMenuBtnLocator));
        //driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistContextMenuBtn.click();
        WebElement newPlaylistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(newPlaylistNameFieldLocator));
        //driver.findElement(By.cssSelector("input[name='name']"));
        newPlaylistNameField.clear();
        newPlaylistNameField.sendKeys(name);
        newPlaylistNameField.sendKeys(Keys.ENTER);
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(successBannerLocator));
        //driver.findElement(By.cssSelector("div[ class='success show']"));
        Assert.assertTrue(successBanner.isDisplayed());
    }

    public void addSongToSelectedPlaylist  (String playlistName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(addToBtnLocator));
        //driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), '" + playlistName + "')]")));
        //driver.findElement(By.xpath("//li[contains(text(), '" + playlistName + "')]"));
        playlist.click();
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(successBannerLocator));
        //driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(successBanner.isDisplayed());

    }

    public void deleteSelectedPlaylist (String playlistName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + playlistName + "')]")));
        playlist.click();
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(deletePlaylistBtnLocator));
        deletePlaylistBtn.click();
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Deleted playlist')]")));
        Assert.assertTrue(successBanner.isDisplayed());
    }

    public void renameSelectedPlaylist(String editablePlaylistName, String newPlaylistName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + editablePlaylistName + "')]")));
        actions.contextClick(playlist).perform();
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(editBtnLocator));
        editBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(enterPlaylistNameFieldLocator));
        WebElement enterPlaylistNameField = driver.findElement(enterPlaylistNameFieldLocator);
        actions.moveToElement(enterPlaylistNameField)
                .doubleClick()
                .sendKeys(Keys.DELETE)
                .sendKeys(newPlaylistName)
                .sendKeys(Keys.ENTER)
                .build().perform();
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Updated playlist')]")));
        Assert.assertTrue(successBanner.isDisplayed());
    }
}
