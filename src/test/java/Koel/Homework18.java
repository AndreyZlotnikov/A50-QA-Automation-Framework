package Koel;

import org.testng.annotations.Test;
import Koel.pages.AllSongsPage;
import Koel.pages.LoginPage;

public class Homework18 extends BaseTest {



    @Test
    public void playSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);



        loginPage.logIn("demo@class.com", "te$t$tudent");
        allSongsPage.goToAllSongs();
        allSongsPage.playSelectedSong("BossStatus");

    }

}
