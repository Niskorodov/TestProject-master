package org.autotests.ui.tests.demoblaze;

import org.autotests.ui.pages.demoblaze.SignUpPage;
import org.autotests.utils.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class NegativeSignUpTest extends TestBase {

    @Test
    public void cannotSignUpWithEmptyFields() {
        open("/");
        new SignUpPage()
                .openSignUpModal()
                .enterUsername("")
                .enterPassword("")
                .submit()
                .confirmAlert("Please fill out Username and Password.");
    }

    @Test
    public void cannotSignUpWithDuplicateUsername() {
        String duplicateUsername = "demo_user_" + System.currentTimeMillis();
        String password = "pass123";

        // Первая регистрация — успешная
        open("/");
        new SignUpPage()
                .openSignUpModal()
                .enterUsername(duplicateUsername)
                .enterPassword(password)
                .submit()
                .confirmAlert("Sign up successful.");

        // Повторная регистрация — должна вызвать ошибку
        open("/");
        new SignUpPage()
                .openSignUpModal()
                .enterUsername(duplicateUsername)
                .enterPassword(password)
                .submit()
                .confirmAlert("This user already exist.");
    }
}
