package org.autotests.ui.pages.automationintesting;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.autotests.utils.TestBaseAutomationintesting;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminPage extends TestBaseAutomationintesting {

    private String lastRoomName;
    private String lastRoomType;
    private boolean lastAccessible;
    private int lastPrice;
    private String[] lastFeatures;

    // Авторизация
    public AdminPage openMainPage() {
        Selenide.open("https://automationintesting.online/");
        return this;
    }

    public AdminPage openAdminPage() {
        $("a[href='/admin']").click();
        $("h2").shouldHave(text("Login"));
        return this;
    }

    public AdminPage enterUsername(String username) {
        $("#username").setValue(username);
        return this;
    }

    public AdminPage enterPassword(String password) {
        $("#password").setValue(password);
        return this;
    }

    public AdminPage clickLoginButton() {
        $("#doLogin").click();
        return this;
    }

    public AdminPage checkRoomsHeaderIsVisible() {
        $("p").shouldHave(text("Room #")).shouldBe(visible);
        return this;
    }

    public AdminPage checkInvalidCredentialsAlert() {
        $(".alert-danger").shouldHave(text("Invalid credentials")).shouldBe(visible);
        return this;
    }

    public AdminPage logout() {
        $("button.btn-outline-danger").shouldHave(text("Logout")).click();
        return this;
    }

    public AdminPage verifyLoggedOut() {
        $("span").shouldHave(text("Shady Meadows B&B")).shouldBe(visible);
        return this;
    }

    // rooms
    public AdminPage fillRoomForm(String name, String type, boolean accessible, int price, String[] features) {
        this.lastRoomName = name;
        this.lastRoomType = type;
        this.lastAccessible = accessible;
        this.lastPrice = price;
        this.lastFeatures = features;

        $("#roomName").setValue(name);
        $("#type").selectOption(type);
        $("#accessible").selectOption(String.valueOf(accessible));
        $("#roomPrice").setValue(String.valueOf(price));

        for (String feature : features) {
            $x("//input[@name='featureCheck' and @value='" + feature + "']").parent().click();
        }
        return this;
    }

    public AdminPage submitRoomForm() {
        $("#createRoom").click();
        return this;
    }

    public AdminPage verifyRoomCreated() {
        SelenideElement container = $(".container");

        // Проверка имени, типа и цены
        container.shouldHave(
                text(lastRoomName),
                text(lastRoomType),
                text(String.valueOf(lastPrice))
        );

        // Проверка фичей (WiFi, TV и т.д.)
        for (String feature : lastFeatures) {
            container.shouldHave(text(feature));
        }

        // Проверка доступности
        if (lastAccessible) {
            container.shouldHave(text("Accessible"));
        }
        return this;
    }

    public AdminPage deleteRoomByNumber(String roomNumber) {
        $x("//p[@id='roomName" + roomNumber + "']/ancestor::div[contains(@class,'row')]//span[contains(@class, 'roomDelete')]")
                .click();

        System.out.println("✅ Удалена комната с номером: " + roomNumber);
        return this;
    }
    public AdminPage verifyRoomNotExists(String roomNumber) {
        $x("//p[@id='roomName" + roomNumber + "']").shouldNotBe(visible);
        System.out.println("🧹 Комната с номером " + roomNumber + " успешно удалена и не отображается на странице.");
        return this;
    }


}
