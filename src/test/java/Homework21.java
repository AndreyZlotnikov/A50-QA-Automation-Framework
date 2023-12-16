import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistsPage;

public class Homework21 extends BasePage {

    public Homework21(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistsPage playlistsPage = new PlaylistsPage(driver);


        loginPage.logIn("demo@class.com", "te$t$tudent");
        playlistsPage.createPlaylist("Playlist7");
        playlistsPage.renameSelectedPlaylist("Playlist7", "Playlist511");
    }
}
