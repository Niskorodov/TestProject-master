package org.autotests.api.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.autotests.api.models.UserRequest;
import org.autotests.api.models.UserUpdateRequest;

public class UserClient {
    public static Response createUser(UserRequest user) {
        return given()
                .log().all()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .header("x-api-key", "reqres-free-v1") // если используешь API key
                .contentType("application/json")
                .body(user)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .response();
    }

    public Response updateUser(int userId, UserUpdateRequest userData) {
        return given()
                .log().all()
                .baseUri("https://reqres.in")
                .basePath("/api/users/" + userId)
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(userData)
                .when()
                .put()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
    }
    public static Response deleteUser(int userId) {
        return given()
                .log().all()
                .baseUri("https://reqres.in")
                .basePath("/api/users/" + userId)
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(204)
                .extract()
                .response();
    }
}
