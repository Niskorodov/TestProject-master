package org.autotests.ui.tests.demoblaze;

import org.autotests.ui.pages.demoblaze.LoginPage;
import org.autotests.utils.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class NegativeLoginTest extends TestBase {

    @Test
    public void cannotLoginWithEmptyUsername() {
        open("/");
        new LoginPage()
                .openLoginModal()
                .enterUsername("")
                .enterPassword("password")
                .submitLogin()
                .checkAlertWithText("Please fill out Username and Password.");
    }

    @Test
    public void cannotLoginWithEmptyPassword() {
        open("/");
        new LoginPage()
                .openLoginModal()
                .enterUsername("user")
                .enterPassword("")
                .submitLogin()
                .checkAlertWithText("Please fill out Username and Password.");
    }
}
