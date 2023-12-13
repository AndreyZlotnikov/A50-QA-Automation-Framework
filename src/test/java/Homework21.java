import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() {
        logIn("demo@class.com", "te$t$tudent");
        createPlaylist("Playlist7");
        renameSelectedPlaylist("Playlist7", "Playlist511");
    }
}
