package ru.ok.api.test.group;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Ok API User Group Header Test Class")
public class OkApiUserGroupHeaderTest {

    @Test
    @DisplayName("test header")
    @Tag("headerTest")
    public void headerTest() {
        Response response = given()
                .when()
                .get("https://api.ok.ru/fb.do?application_key=1&format=json&method=group.getUserGroupsV2");

        String contentType = response.getHeader("Content-Type");
        String contentLanguage = response.getHeader("Content-Language");
        String server = response.getHeader("Server");

        Headers headersArray = response.getHeaders();

        for (Header header : headersArray) {
            System.out.println(header.getName() + " ===> " + header.getValue());
        }

        Assertions.assertAll("Header Test",
                () -> Assertions.assertEquals(contentType, "application/json;charset=utf-8",
                        "Content type should be application/json;charset=utf-8"),
                () -> Assertions.assertEquals(contentLanguage, "en-US",
                        "language is en-US"),
                () -> Assertions.assertEquals(server, "Apache",
                        "Server is Apache"));
    }
}
