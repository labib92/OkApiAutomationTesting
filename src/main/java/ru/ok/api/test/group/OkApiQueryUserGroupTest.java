package ru.ok.api.test.group;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Ok Api Query User Group Test Class")
public class OkApiQueryUserGroupTest {

    @Test
    @DisplayName("Ok Api Query Test")
    @Tag("queryTest")
    public void testOkApiQueryUserGroup() {
        Response response = given()
                .pathParam("labibpath", "fb.do")
                .queryParam("application_key", 1)
                .queryParam("format", "json")
                .queryParam("method", "group.getUserGroupsV2")

                .when()
                .get("https://api.ok.ru/{labibpath}");

        Assertions.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200");
    }
}
