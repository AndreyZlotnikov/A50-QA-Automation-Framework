package Koel;

import org.testng.annotations.Test;
import Koel.pages.AllSongsPage;
import Koel.pages.LoginPage;

public class Homework18 extends BaseTest {



    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());



        loginPage.logIn("demo@class.com", "te$t$tudent");
        allSongsPage.goToAllSongs();
        allSongsPage.playSelectedSong("BossStatus");

    }

}
