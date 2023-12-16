package Koel;

import org.testng.annotations.Test;
import Koel.pages.LoginPage;
import Koel.pages.PlaylistsPage;

public class Homework21 extends BaseTest {



    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistsPage playlistsPage = new PlaylistsPage(driver);


        loginPage.logIn("demo@class.com", "te$t$tudent");
        playlistsPage.createPlaylist("Playlist7");
        playlistsPage.renameSelectedPlaylist("Playlist7", "Playlist511");
    }
}
