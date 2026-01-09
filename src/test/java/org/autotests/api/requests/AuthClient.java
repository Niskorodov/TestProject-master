package org.autotests.api.requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.autotests.api.models.LoginRequest;
import org.autotests.api.models.LoginResponse;

public class AuthClient {

    public static LoginResponse login(String email, String password) {
        LoginRequest body = new LoginRequest(email, password);

        return RestAssured
                .given()
                .log().all()
                .baseUri("https://reqres.in")
                .basePath("/api/login")
                .header("x-api-key", "reqres-free-v1")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(LoginResponse.class);

    }
}
