import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        logIn("demo@class.com", "te$t$tudent");
        createPlaylist("Playlist25");
        goToAllSongs();
        selectSong("BornKing");
        addSongToSelectedPlaylist("Playlist25");

    }

    @Test
    public void playSong() throws InterruptedException {
        logIn("demo@class.com", "te$t$tudent");
        goToAllSongs();
        playSelectedSong("BossStatus");

    }

    @Test
    public void deletePlaylist () throws InterruptedException {
        logIn("demo@class.com", "te$t$tudent");
        //Thread.sleep(3000);
        createPlaylist("Experimental");
        //Thread.sleep(3000);
        deleteSelectedPlaylist("Experimental");

    }
}
