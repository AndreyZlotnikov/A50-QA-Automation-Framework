import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void renameUserName () {
    logIn("andrey.zlotnikov@testpro.io", "Man07hat01tan26!");
    goToProfilePage();
    
    }
}
