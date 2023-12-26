package Koel;

import org.testng.annotations.Test;
import Koel.pages.LoginPage;
import Koel.pages.ProfilePage;

public class ProfileTests extends BaseTest {



    @Test
    public void renameUserName() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.logIn("andrey.zlotnikov@testpro.io", "Man07hat01tan26!");
        profilePage.goToProfilePage();
        profilePage.fillInCurrentPasswordField("Man07hat01tan26!");
        profilePage.fillInNameField("AZlotnikov");
        profilePage.fillInEmailAddress("andrey.zlotnikov@testpro.io");
        profilePage.fillInNewPasswordField("Man07hat01tan26!");
        profilePage.clickSaveBtn();
        profilePage.assertUserNameRenamed();

    }
}
