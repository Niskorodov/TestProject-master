package org.autotests.ui.tests.automationintesting;

import org.autotests.ui.pages.automationintesting.AdminPage;
import org.autotests.utils.TestBaseAutomationintesting;
import org.junit.jupiter.api.Test;

public class AdminCanDeleteRoomTest extends TestBaseAutomationintesting {
    AdminPage adminPage = new AdminPage();

    @Test
    public void deleteRoomInAdminPanel() {
        adminPage.openMainPage()
                .openAdminPage()
                .enterUsername("admin")
                .enterPassword("password")
                .clickLoginButton()
                .checkRoomsHeaderIsVisible()
                .fillRoomForm("444", "Suite", true, 300, new String[]{"WiFi", "Refreshments", "Safe"})
                .submitRoomForm()
                .verifyRoomCreated()
                .deleteRoomByNumber("444")
                .verifyRoomNotExists("444");
    }
}