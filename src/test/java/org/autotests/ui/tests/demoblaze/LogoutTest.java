package org.autotests.ui.tests.demoblaze;

import com.codeborne.selenide.Selenide;
import org.autotests.ui.pages.demoblaze.LoginPage;
import org.autotests.ui.pages.demoblaze.SignUpPage;
import org.autotests.utils.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import java.time.Duration;

public class LogoutTest extends TestBase {

    @Test
    public void userCanLogoutSuccessfully() {
        // Подготовка: регистрация и вход
        String username = "test_" + System.currentTimeMillis();
        String password = "qwerty";

        Selenide.open("/");
        new SignUpPage()
                .openSignUpModal()
                .enterUsername(username)
                .enterPassword(password)
                .submit()
                .confirmAlert("Sign up successful.");

        new LoginPage()
                .openLoginModal()
                .enterUsername(username)
                .enterPassword(password)
                .submitLogin();

        $("#login2").should(disappear);
        $("#nameofuser").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text(username));

        // Действие: выход
        new LoginPage()
                .logout();

        // Проверка: "Log in" снова появилась
        $("#login2").shouldBe(visible, Duration.ofSeconds(10));
        $("#logout2").should(disappear);
        $("#nameofuser").should(disappear);
    }
}
