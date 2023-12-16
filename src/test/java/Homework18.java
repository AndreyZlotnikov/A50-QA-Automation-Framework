import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.LoginPage;

public class Homework18 extends BasePage {

    public Homework18(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public void playSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);



        loginPage.logIn("demo@class.com", "te$t$tudent");
        allSongsPage.goToAllSongs();
        allSongsPage.playSelectedSong("BossStatus");

    }

}
