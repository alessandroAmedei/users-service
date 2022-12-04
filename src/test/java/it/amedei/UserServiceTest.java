package it.amedei;/*
@author Alessandro Amedei
2022    
*/

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class UserServiceTest {

    @Test
    void findByIdTest() {
        given().when().get("/users/1")
                .then()
                .body("name", is("alessandro"))
                .body("surname", is("amedei"))
                .statusCode(200);
    }

}
