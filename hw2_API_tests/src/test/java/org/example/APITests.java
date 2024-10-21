package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APITests {

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/dc3c8317e38d49c49405c1e8f5b1a037";
    }

    @Test
    public void unicornCreation() {
        //BODY REQUEST CREATION
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "Plotva");
        requestBody.put("tailColor", "pink");

        UnicornRequests.unicornCreation(requestBody);
    }

    @Test
    public void unicornRemoving() {
        //BODY REQUEST CREATION
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "Arabskaya");
        requestBody.put("tailColor", "white");

        //STEP 1: UNICORN CREATION
        String unicornId = UnicornRequests.unicornCreation(requestBody);

        //STEP 2: UNICORN DELETION
        given()
        .when()
                .delete("/unicorn/" + unicornId)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

        //STEP 3: CHECK SUCCESSFUL DELETION
        given()
        .when()
                .get("/unicorn/" + unicornId)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void unicornTailColorUpdate() {
        //BODY REQUEST CREATION
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "Arabskaya");
        requestBody.put("tailColor", "white");

        //STEP 1: UNICORN CREATION
        String unicornId = UnicornRequests.unicornCreation(requestBody);

        //STEP 2: UPDATE UNICORN TAIL
        requestBody.put("tailColor", "black");

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
        .when()
                .put("/unicorn/" + unicornId)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }


}
