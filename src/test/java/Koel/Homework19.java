package Koel;

import org.testng.annotations.Test;
import Koel.pages.LoginPage;
import Koel.pages.PlaylistsPage;

public class Homework19 extends BaseTest {



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
