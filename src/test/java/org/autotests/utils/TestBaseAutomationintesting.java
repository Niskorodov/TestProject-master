package org.autotests.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBaseAutomationintesting {

    // Файл: класс TestBaseAutomationintesting
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 4000; // Рекомендую поднять до 10000 для CI
        Configuration.reopenBrowserOnFail = true;

        // ДОБАВЬТЕ ЭТУ СТРОКУ:
        Configuration.headless = true;

        open("https://automationintesting.online/");
        // УДАЛИТЕ ИЛИ ЗАКОММЕНТИРУЙТЕ ЭТУ СТРОКУ (она не нужна в headless):
        // WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}