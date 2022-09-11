package Lesson5;

import Lesson5.ApiDeleteItem.ApiDeleteItemResult;
import Lesson5.ApiGetShoppingList.ApiGetShoppingListResult;
import Lesson5.ApiToShoppingList.ApiAddToShoppingListRequest;
import Lesson5.ApiToShoppingList.ApiAddToShoppingListResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SpoonacularAddGetDeleteTest {

    private static Long itemId;

    @Order(1)
    @Test
    void addItemToShoppingList() {
        ApiAddToShoppingListRequest request = new ApiAddToShoppingListRequest("milk",true);
        SpoonaccularService spoonaccularService = new SpoonaccularService();
        ApiAddToShoppingListResult result = spoonaccularService.addToCart(request);
        Assertions.assertEquals(result.getName(),"milk");
        Assertions.assertEquals(result.getCost(),33.08);
    }
    @Order(2)
    @Test
    void getShoppingList() {
        SpoonaccularService spoonaccularService = new SpoonaccularService();
        ApiGetShoppingListResult resultShoppingList = spoonaccularService.getShoppingList();
        itemId = resultShoppingList.getAisles().get(0).getItems().get(0).getId();
        Assertions.assertEquals(resultShoppingList.getAisles().get(0).getItems().get(0).getName(),"milk");
        Assertions.assertEquals(resultShoppingList.getAisles().get(0).getItems().get(0).getIngredientId(),1077);
        System.out.println("item Id is " + itemId);

    }
    @Order(3)
    @Test
    void deleteItemFromShoppingList() {
        SpoonaccularService spoonaccularService = new SpoonaccularService();
        ApiDeleteItemResult deleteItemResult = spoonaccularService.deleteItemFromCart(itemId);
        Assertions.assertEquals(deleteItemResult.getStatus(),"success");

    }
}
