package org.autotests.ui.tests.demoblaze;

import org.autotests.ui.pages.demoblaze.HomePage;
import org.junit.jupiter.api.Test;

public class HomePageTest {

    private final HomePage homePage = new HomePage();

    @Test
    public void userCanOpenHomePageAndSeeTitle() {
        homePage
                .open()
                .checkTitleVisible();
    }
}
