import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistsPage;

public class Homework19 extends BasePage {

    public Homework19(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public void deletePlaylist () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistsPage playlistsPage = new PlaylistsPage(driver);

        loginPage.logIn("demo@class.com", "te$t$tudent");
        //Thread.sleep(3000);
        playlistsPage.createPlaylist("Experimental");
        //Thread.sleep(3000);
        playlistsPage.deleteSelectedPlaylist("Experimental");

    }

}
