package Lesson5.ApiGetShoppingList;

import lombok.Data;

import java.util.List;

@Data
public class ApiGetShoppingListResultAisles {

    private String aisle;
    private List<ApiGetShoppingListResultItems> items;
}
