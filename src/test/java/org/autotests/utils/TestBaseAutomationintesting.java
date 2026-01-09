package org.autotests.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBaseAutomationintesting {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 4000;
        Configuration.reopenBrowserOnFail = true;

        open("https://automationintesting.online/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
