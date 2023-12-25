package Koel;

import org.testng.annotations.Test;
import Koel.pages.AllSongsPage;
import Koel.pages.LoginPage;
import Koel.pages.PlaylistsPage;

public class Homework20 extends BaseTest {



    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistsPage playlistsPage = new PlaylistsPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.logIn("demo@class.com", "te$t$tudent");
        playlistsPage.createPlaylist("Playlist25");
        allSongsPage.goToAllSongs();
        allSongsPage.selectSong("BornKing");
        playlistsPage.addSongToSelectedPlaylist("Playlist25");

    }

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.logIn("demo@class.com", "te$t$tudent");
        allSongsPage.goToAllSongs();
        allSongsPage.playSelectedSong("BossStatus");

    }

    @Test
    public void deletePlaylist () {
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistsPage playlistsPage = new PlaylistsPage(getDriver());


        loginPage.logIn("demo@class.com", "te$t$tudent");
        playlistsPage.createPlaylist("Experimental");
        playlistsPage.deleteSelectedPlaylist("Experimental");

    }
}
