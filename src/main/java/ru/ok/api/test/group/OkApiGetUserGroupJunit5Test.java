package ru.ok.api.test.group;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Ok API GET user group Junit 5 Assertion Test Class")
public class OkApiGetUserGroupJunit5Test {
    private final int expectedStatusCode = 200;

    @Test
    @DisplayName("test get user Junit 5 Assertion Test")
    @Tag("getAnotherUser")
    public void testGetUserGroupAnother() {
        String errorMessage;
        Response response = given()
                .contentType(ContentType.JSON)

                .when()
                .get("https://api.ok.ru/fb.do?application_key=1&format=json&method=group.getUserGroupsV2");

        errorMessage = response.jsonPath().get("error_msg").toString();

        Assertions.assertAll("Get User Assertion",
                () -> Assertions.assertEquals(response.getStatusCode(), expectedStatusCode,
                        "Status code should be " + expectedStatusCode),
                () -> Assertions.assertEquals(response.getHeader("Content-Type"),
                        "application/json;charset=utf-8",
                        "Content Type Header should be application/json;charset=utf-8"),
                () -> Assertions.assertEquals(errorMessage, "PARAM_API_KEY : Application not exist",
                        "Incorrect Error Message"));
    }
}
