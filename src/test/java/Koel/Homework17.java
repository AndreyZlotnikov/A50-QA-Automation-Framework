package Koel;

import org.testng.annotations.Test;
import Koel.pages.AllSongsPage;
import Koel.pages.LoginPage;
import Koel.pages.PlaylistsPage;

public class Homework17 extends BaseTest {


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
