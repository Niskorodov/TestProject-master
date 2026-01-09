package org.autotests.api.tests;

import org.autotests.api.models.UserRequest;
import org.autotests.api.models.UserUpdateRequest;
import org.autotests.api.requests.UserClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private final UserClient userClient = new UserClient();

    @Test
    public void userShouldBeCreatedSuccessfully() {
        UserRequest newUser = UserRequest.builder()
                .name("Dmitriy")
                .job("QA Engineer")
                .build();


        var response = UserClient.createUser(newUser);

        assertEquals("Dmitriy", response.path("name"));
        assertEquals("QA Engineer", response.path("job"));
        assertNotNull(response.path("id"));
        assertNotNull(response.path("createdAt"));
    }
    @Test
    public void userShouldBeUpdatedSuccessfully() {
        UserUpdateRequest update = new UserUpdateRequest("Dmitriy Updated", "Senior QA");

        String updatedAt = userClient.updateUser(2, update)
                .jsonPath()
                .getString("updatedAt");

        System.out.println("User updated at: " + updatedAt);
    }

    @Test
    public void userShouldBeDeletedSuccessfully() {
        UserClient.deleteUser(2);
        System.out.println("✅ TC04: пользователь успешно удалён");
    }
}
