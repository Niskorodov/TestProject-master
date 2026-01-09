package org.autotests.ui.tests.demoblaze;

import org.autotests.ui.pages.demoblaze.LoginPage;
import org.autotests.utils.TestBase;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase {

    private final LoginPage loginPage = new LoginPage();

    @Test
    public void userCannotLoginWithInvalidCredentials() {
        loginPage.open()
                .openLoginModal()
                .enterUsername("wrongUser")
                .enterPassword("wrongPass")
                .submitLogin()
                .checkAlertWithText("User does not exist.");
    }
}
