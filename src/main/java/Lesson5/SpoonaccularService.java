package Lesson5;

import Lesson5.ApiDeleteItem.ApiDeleteItemResult;
import Lesson5.ApiGetShoppingList.ApiGetShoppingListResult;
import Lesson5.ApiToShoppingList.ApiAddToShoppingListRequest;
import Lesson5.ApiToShoppingList.ApiAddToShoppingListResult;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class SpoonaccularService {

    private SpoonaccularApi api;
    private static final String api_Key = "665a4c226f5b46c6b3dd4a22c022ce46";
    private static String userHash = "2c579e6eb97f7d0693d190d37f8cc9ad1882ba6a";


    public SpoonaccularService(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spoonacular.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SpoonaccularApi.class);
    }


    public ApiAddToShoppingListResult addToCart(@Body ApiAddToShoppingListRequest request){
        Call<ApiAddToShoppingListResult> call = api.addToShoppingList(request,api_Key,userHash);
        return RetrofitUtils.execute(call);
    }

    public ApiGetShoppingListResult getShoppingList(){
        Call<ApiGetShoppingListResult> call = api.getShoppingList(api_Key,userHash);
        return RetrofitUtils.execute(call);
    }

    public ApiDeleteItemResult deleteItemFromCart(Long itemId){
        Call<ApiDeleteItemResult> call = api.deleteItemFromCart(itemId, api_Key,userHash);
        return RetrofitUtils.execute(call);
    }


}
