package Lesson4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class SpoonacularPostGetDeleteTest {


    private String userId = "timur0";
    private String requestBody = "{\n" +
            "  \"item\": \"1 package baking powder\" \n}";

    private static int itemId;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", "665a4c226f5b46c6b3dd4a22c022ce46")
                .addQueryParam("hash", "2c579e6eb97f7d0693d190d37f8cc9ad1882ba6a")
                .build();
    }




    @Order(1)
    @Test
    void addItemToShoppingList() {
        RestAssured.given()
                .body(requestBody)
                .log()
                .uri()
                .expect()
                .statusCode(200)
                .time(lessThanOrEqualTo(1500l))
                .body("name",is("baking powder"))
                .log()
                .body()
                .when()
                .post("/mealplanner/"+userId+"/shopping-list/items")
                .body()
                .asPrettyString();
    }

    @Order(2)
    @Test
    void getTheCurrentShoppingList(){
        String response = RestAssured.given()
                .log()
                .uri()
                .expect()
                .statusCode(200)
                .time(lessThanOrEqualTo(1500L))
                .body("aisles[0].items[0].name",is("baking powder"))

                .log()
                .body()
                .when()
                .get("/mealplanner/"+userId+"/shopping-list")
                .body()
                .asPrettyString();

        JsonPath jsonPath = new JsonPath(response);
        itemId = jsonPath.getInt("aisles[0].items[0].id");
        System.out.println(itemId);
    }
    @Order(3)
    @Test
    void deleteItemFromShoppingList(){

        RestAssured.given()
                .log()
                .uri()
                .expect()
                .statusCode(200)
                .time(lessThanOrEqualTo(1500L))
                .body("status",is("success"))
                .log()
                .body()
                .when()
                .delete("/mealplanner/"+userId+"/shopping-list/items/"+itemId)
                .body()
                .asPrettyString();
    }
}
