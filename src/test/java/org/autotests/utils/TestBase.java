package org.autotests.utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    // Файл: src/test/java/org/autotests/utils/TestBase.java
    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://www.demoblaze.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        // ДОБАВЬТЕ ЭТУ СТРОКУ:
        Configuration.headless = true;
    }
}