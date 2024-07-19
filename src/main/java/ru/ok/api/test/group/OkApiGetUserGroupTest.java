package ru.ok.api.test.group;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Ok API Get Method User Group Test Class")
public class OkApiGetUserGroupTest {

    @Test
    @DisplayName("test get user group")
    @Tag("getUser")
    public void testGetUserGroup() {

        given()
                .contentType("application/json;charset=utf-8")

                .when()
                .get("https://api.ok.ru/fb.do?application_key=1&format=json&method=group.getUserGroupsV2")

                .then()
                .statusCode(200)
                .body("error_code", equalTo(101))
                .body("error_msg", equalTo("PARAM_API_KEY : Application not exist"))
                .body("error_data", equalTo(null))
                .log().all();
    }
}
