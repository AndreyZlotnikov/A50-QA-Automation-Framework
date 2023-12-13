import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import java.time.Duration;

import static java.lang.Thread.sleep;

public class BaseTest {

    protected WebDriver driver = null;
    protected String url = "https://qa.koel.app/";
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupDriver(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
                //driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
                //driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement logInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
                //driver.findElement(By.cssSelector("button[type='submit']"));
        logInBtn.click();

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
        Assert.assertTrue(successBanner.isDisplayed());
    }

    public void selectSong (String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), '" + title + "')]")));
                //driver.findElement(By.xpath("//td[contains(text(), '" + title + "')]"));
        song.click();
    }


    public void playSelectedSong (String title) throws InterruptedException {
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

    public void addSongToSelectedPlaylist  (String playlistName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn-add-to']")));
                //driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), '" + playlistName + "')]")));
                //driver.findElement(By.xpath("//li[contains(text(), '" + playlistName + "')]"));
        playlist.click();
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
                //driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(successBanner.isDisplayed());

    }

    public void deleteSelectedPlaylist (String playlistName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + playlistName + "')]")));
        playlist.click();
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='del btn-delete-playlist']")));
        deletePlaylistBtn.click();
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Deleted playlist')]")));
        Assert.assertTrue(successBanner.isDisplayed());
    }

    public void renameSelectedPlaylist(String editablePlaylistName, String newPlaylistName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + editablePlaylistName + "')]")));
        playlist.click();
        actions.contextClick(playlist).perform();
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class='menu playlist-item-menu']//li[contains(text(), 'Edit')]")));
        editBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        WebElement enterPlaylistNameField = driver.findElement(By.xpath("//input[@data-testid='inline-playlist-name-input']"));
        enterPlaylistNameField.sendKeys(Keys.BACK_SPACE);

        //enterPlaylistNameField.clear();
        enterPlaylistNameField.sendKeys(newPlaylistName);
        enterPlaylistNameField.sendKeys(Keys.ENTER);
        //WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Updated playlist')]")));
        //Assert.assertTrue(successBanner.isDisplayed());
    }


}