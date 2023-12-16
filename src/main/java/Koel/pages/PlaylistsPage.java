package Koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class PlaylistsPage extends BasePage {

    public PlaylistsPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public void createPlaylist (String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createNewPlaylistDtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        //driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        createNewPlaylistDtn.click();
        WebElement newPlaylistContextMenuBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        //driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistContextMenuBtn.click();
        WebElement newPlaylistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        //driver.findElement(By.cssSelector("input[name='name']"));
        newPlaylistNameField.clear();
        newPlaylistNameField.sendKeys(name);
        newPlaylistNameField.sendKeys(Keys.ENTER);
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[ class='success show']")));
        //driver.findElement(By.cssSelector("div[ class='success show']"));
        //Assert.assertTrue(successBanner.isDisplayed());
    }

    public void addSongToSelectedPlaylist  (String playlistName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn-add-to']")));
        //driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), '" + playlistName + "')]")));
        //driver.findElement(By.xpath("//li[contains(text(), '" + playlistName + "')]"));
        playlist.click();
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        //driver.findElement(By.cssSelector("div[class='success show']"));
        //Assert.assertTrue(successBanner.isDisplayed());

    }

    public void deleteSelectedPlaylist (String playlistName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + playlistName + "')]")));
        playlist.click();
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='del btn-delete-playlist']")));
        deletePlaylistBtn.click();
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Deleted playlist')]")));
        //Assert.assertTrue(successBanner.isDisplayed());
    }

    public void renameSelectedPlaylist(String editablePlaylistName, String newPlaylistName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + editablePlaylistName + "')]")));
        actions.contextClick(playlist).perform();
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class='menu playlist-item-menu']//li[contains(text(), 'Edit')]")));
        editBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        WebElement enterPlaylistNameField = driver.findElement(By.xpath("//input[@data-testid='inline-playlist-name-input']"));
        actions.moveToElement(enterPlaylistNameField)
                .doubleClick()
                .sendKeys(Keys.DELETE)
                .sendKeys(newPlaylistName)
                .sendKeys(Keys.ENTER)
                .build().perform();
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Updated playlist')]")));
        //Assert.assertTrue(successBanner.isDisplayed());
    }
}
