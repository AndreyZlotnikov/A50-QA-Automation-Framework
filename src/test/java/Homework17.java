import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistsPage;

public class Homework17 extends BasePage {
    public Homework17(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistsPage playlistsPage = new PlaylistsPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.logIn("demo@class.com", "te$t$tudent");
        playlistsPage.createPlaylist("Playlist25");
        allSongsPage.goToAllSongs();
        allSongsPage.selectSong("BornKing");
        playlistsPage.addSongToSelectedPlaylist("Playlist25");

    }

}
