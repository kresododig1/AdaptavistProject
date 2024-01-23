package Adaptavist.Test;

import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

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

    @Test (priority = 1)
    public void Create(){

        Map<String, String> bodyRequest = new HashMap<>();
        bodyRequest.put("name", "morpheus");
        bodyRequest.put("job", "leader");

        Response response = given().accept(ContentType.JSON)
                .contentType("application/json")
                .body(bodyRequest)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract().response();

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        int id = jsonPath.getInt("id");
        System.out.println("New user id = " + id);


    }

    @Test (priority = 2)
    public void Update_with_Put(){

        String bodyRequest = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        JsonPath jsonPath = given().accept(ContentType.JSON)
                .contentType("application/json")
                .body(bodyRequest)
                .when()
                .put("/2")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        System.out.println("name = " + jsonPath.getString("name"));
        System.out.println("job = " + jsonPath.getString("job"));
        System.out.println("updatedAt = " + jsonPath.getString("updatedAt"));

    }

    @Test (priority = 3)
    public void Update_with_Patch(){

        String bodyRequest = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        Response response = given().accept(ContentType.JSON)
                .contentType("application/json")
                .body(bodyRequest)
                .when()
                .patch("/2")
                .then()
                .statusCode(200)
                .extract().response();

        response.prettyPrint();


    }









}
