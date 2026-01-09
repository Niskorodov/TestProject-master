package org.autotests.ui.tests.demoblaze;

import com.codeborne.selenide.Selenide;
import org.autotests.ui.pages.demoblaze.LoginPage;
import org.autotests.ui.pages.demoblaze.SignUpPage;
import org.autotests.utils.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PositiveLoginTest extends TestBase {

    @Test
    public void userCanSignUpAndLoginSuccessfully() {
        String username = "test_" + System.currentTimeMillis();
        String password = "123456";

        // Sign Up
        Selenide.open("/");
        new SignUpPage()
                .openSignUpModal()
                .enterUsername(username)
                .enterPassword(password)
                .submit()
                .confirmAlert("Sign up successful.");

        // Log In
        new LoginPage()
                .openLoginModal()
                .enterUsername(username)
                .enterPassword(password)
                .submitLogin();

        // Проверка: имя пользователя отображается в хедере
        $("#login2").should(disappear); // исчезновение кнопки "Log in"
        $("#nameofuser").shouldBe(visible).shouldHave(text(username));
    }
}
