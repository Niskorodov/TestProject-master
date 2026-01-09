package org.autotests.ui.tests.automationintesting;

import org.autotests.ui.pages.automationintesting.AdminPage;
import org.autotests.utils.TestBaseAutomationintesting;
import org.junit.jupiter.api.Test;

public class AdminCanAddNewRoomTest extends TestBaseAutomationintesting {
    private final AdminPage adminPage = new AdminPage();

    @Test
    public void createRoomInAdminPanel() {
        adminPage.openMainPage()
                .openAdminPage()
                .enterUsername("admin")
                .enterPassword("password")
                .clickLoginButton()
                .checkRoomsHeaderIsVisible()
                .fillRoomForm("333", "Suite",true,300, new String[]{"WiFi", "Refreshments", "Safe"})
                .submitRoomForm()
                .verifyRoomCreated();

    }
}
