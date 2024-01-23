package Adaptavist.Test;

import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class Adaptavist_API {

    @BeforeMethod
    public void setUp(){
        baseURI="https://reqres.in";
        basePath="/api/users";

    }


    @Test (priority = 0)
    public void List_Users(){



        Response response = given().accept(ContentType.JSON)
                .queryParam("page", 2)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("page", is(2))
                .body("per_page", equalTo(6))
                .body("total", is(equalTo(12)))
                .body("total_pages", is(2))
                .extract().response();

        System.out.println("Status code = " + response.statusCode());

        response.prettyPrint();
    }


}
