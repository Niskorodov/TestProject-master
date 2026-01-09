package org.autotests.ui.pages.demoblaze;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SignUpPage {

    public SignUpPage openSignUpModal() {
        $("#signin2").click(); // кнопка Sign up
        $("#signInModal").shouldBe(visible); // ждем модалку
        return this;
    }

    public SignUpPage enterUsername(String username) {
        $("#sign-username").setValue(username);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        $("#sign-password").setValue(password);
        return this;
    }

    public SignUpPage submit() {
        $("button[onclick='register()']").click();
        return this;
    }

    public SignUpPage confirmAlert(String expectedText) {
        String actual = switchTo().alert().getText();
        System.out.println("SignUp alert: " + actual);
        switchTo().alert().accept();
        return this;
    }
}
