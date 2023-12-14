import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void renameUserName() {
        logIn("andrey.zlotnikov@testpro.io", "Man07hat01tan26!");
        goToProfilePage();
        fillInCurrentPasswordField("Man07hat01tan26!");
        fillInNameField("AZlotnikov");
        fillInEmailAddress("andrey.zlotnikov@testpro.io");
        fillInNewPasswordField("Man07hat01tan26!");
        clickSaveBtn();
        assertUserNameRenamed();

    }
}
