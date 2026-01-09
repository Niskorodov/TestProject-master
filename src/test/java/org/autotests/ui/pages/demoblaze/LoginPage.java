package org.autotests.ui.pages.demoblaze;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    public LoginPage open() {
        Selenide.open("https://www.demoblaze.com/");
        return this;
    }

    public LoginPage openLoginModal() {
        $("#login2").click(); // кнопка "Log in" в хедере
        $("#logInModal").shouldBe(visible); // ждем модальное окно
        return this;
    }

    public LoginPage enterUsername(String username) {
        $("#loginusername").setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $("#loginpassword").setValue(password);
        return this;
    }

    public LoginPage submitLogin() {
        $("button[onclick='logIn()']").click();
        return this;
    }

    public LoginPage checkAlertWithText(String expectedText) {
        Alert alert = switchTo().alert();
        String actualText = alert.getText();
        assertEquals(expectedText, actualText, "Неверный текст alert");
        alert.accept(); // закрыть alert
        return this;
    }

    public LoginPage logout() {
        $("#logout2").click(); // кнопка Log out
        return this;
    }

}
