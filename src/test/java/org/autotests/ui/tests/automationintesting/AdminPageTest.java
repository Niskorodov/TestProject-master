package org.autotests.ui.tests.automationintesting;

import org.autotests.ui.pages.automationintesting.AdminPage;
import org.autotests.utils.TestBaseAutomationintesting;
import org.junit.jupiter.api.Test;

public class AdminPageTest extends TestBaseAutomationintesting {

    private final AdminPage adminPage = new AdminPage();

    @Test
    public void userShouldBeAbleToLoginSuccessfully() {
        adminPage.openMainPage()
                .openAdminPage()
                .enterUsername("admin")
                .enterPassword("password")
                .clickLoginButton()
                .checkRoomsHeaderIsVisible()
                .logout()
                .verifyLoggedOut();
    }
}
