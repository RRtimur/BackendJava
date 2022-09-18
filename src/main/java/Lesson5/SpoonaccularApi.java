package Lesson5;

import Lesson5.ApiDeleteItem.ApiDeleteItemResult;
import Lesson5.ApiGetShoppingList.ApiGetShoppingListResult;
import Lesson5.ApiToShoppingList.ApiAddToShoppingListRequest;
import Lesson5.ApiToShoppingList.ApiAddToShoppingListResult;
import retrofit2.Call;
import retrofit2.http.*;

public interface SpoonaccularApi {

    @POST("/mealplanner/timur0/shopping-list/items")
    Call<ApiAddToShoppingListResult> addToShoppingList (@Body ApiAddToShoppingListRequest request, @Query("apiKey") String apiKey,
                                          @Query("hash") String hash);

    @GET("/mealplanner/timur0/shopping-list")
    Call<ApiGetShoppingListResult> getShoppingList (@Query("apiKey") String apiKey, @Query("hash") String hash);


   @DELETE("mealplanner/timur0/shopping-list/items/{id}")
    Call<ApiDeleteItemResult> deleteItemFromCart (@Path("id") Long idItem, @Query("apiKey") String apiKey, @Query("hash") String hash );
}
