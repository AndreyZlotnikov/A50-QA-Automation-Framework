import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BasePage {

    public ProfileTests(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public void renameUserName() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

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
