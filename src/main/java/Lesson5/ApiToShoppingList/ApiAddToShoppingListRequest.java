package Lesson5.ApiToShoppingList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor


    public class ApiAddToShoppingListRequest {
    private String item;
    private boolean parse;

}
