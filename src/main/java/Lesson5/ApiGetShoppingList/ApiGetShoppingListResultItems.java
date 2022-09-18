package Lesson5.ApiGetShoppingList;

import lombok.Data;

import java.util.List;

@Data
public class ApiGetShoppingListResultItems {
    private Long id;
    private String name;
    private ApiGetShoppingListResultMeasures measures;
    private List<ApiGetShoppingListResultUsages> usages;
    private List<ApiGetShoppingListUsageRecipeIds> usageRecipeIds;
    private boolean pantryItem;
    private String aisle;
    private double cost;
    private Long ingredientId;

}
