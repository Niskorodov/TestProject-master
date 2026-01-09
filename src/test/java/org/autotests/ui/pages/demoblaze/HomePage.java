package org.autotests.ui.pages.demoblaze;


import com.codeborne.selenide.Selenide;
import org.autotests.utils.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class HomePage extends TestBase {

    // локатор заголовка "PRODUCT STORE"
    private final String pageTitleSelector = "#nava";

    public HomePage open() {
        Selenide.open("https://www.demoblaze.com/");
        return this;
    }

    public HomePage checkTitleVisible() {
        $(pageTitleSelector).shouldBe(visible).shouldHave(text("PRODUCT STORE"));
        return this;
    }
}
