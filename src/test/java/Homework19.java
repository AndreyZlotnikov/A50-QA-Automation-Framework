import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist () throws InterruptedException {
        logIn("demo@class.com", "te$t$tudent");
        Thread.sleep(3000);
        createPlaylist("Experimental");
        Thread.sleep(3000);
        deleteSelectedPlaylist("Experimental");

    }

}
