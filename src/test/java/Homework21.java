import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() {
        logIn("andrey.zlotnikov@testpro.io", "Man07hat01tan26!");
        createPlaylist("Playlist25");
        renameSelectedPlaylist("Playlist25", "Playlist106");
    }
}
