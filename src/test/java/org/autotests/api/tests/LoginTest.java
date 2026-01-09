package org.autotests.api.tests;

import org.autotests.api.models.LoginResponse;
import org.autotests.api.requests.AuthClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void userCanLoginSuccessfully() {
        LoginResponse response = AuthClient.login("eve.holt@reqres.in", "cityslicka");

        assertNotNull(response.getToken());
        System.out.println("Token: " + response.getToken());
    }
}
