package Lesson6;

import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Products;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import java.io.IOException;



public class MinimarketPostGetDeleteTest {

    private static int productId;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://minimarket1.herokuapp.com";

    }


    @Order(1)
    @Test
    void checkCreateProduct() throws IOException {


        ProductInfo request = ProductInfo.builder()
                .title("Chocolate Milk")
                .price(200L)
                .categoryTitle("Food")
                .build();


        String newProduct = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(request)
                .log()
                .uri()
                .expect()
                .statusCode(201)
                .log()
                .body()
                .when()
                .post("/market/api/v1/products")
                .body()
                .asPrettyString();


        productId = JsonPath.given(newProduct).get("id");


        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("myBatisConfig.xml"));

        try (SqlSession session = sessionFactory.openSession()) {
            ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
            Products products = productsMapper.selectByPrimaryKey(Long.valueOf(productId));

            Assertions.assertEquals(products.getTitle(), "Chocolate Milk");



        }
    }


    @Order(2)
    @Test
    void deleteItemFromDB(){

        RestAssured.given()
                .log()
                .uri()
                .expect()
                .statusCode(200)
                .log()
                .body()
                .when()
                .delete("/market/api/v1/products/"+ productId)
                .body()
                .asPrettyString();



            RestAssured.given()
                    .log()
                    .uri()
                    .expect()
                    .statusCode(404)
                    .log()
                    .body()
                    .when()
                    .get("/market/api/v1/products/" + productId)
                    .body()
                    .asPrettyString();



        }

    }


