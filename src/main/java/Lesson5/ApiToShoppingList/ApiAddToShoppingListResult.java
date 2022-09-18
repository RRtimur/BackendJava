package Lesson5.ApiToShoppingList;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiAddToShoppingListResult {
    private Long id;
    private String name;
    private ApiAddToShoppingListResultMeasures measures;
    private List<ApiAddToShoppingListResultUsages> usages;
    private List<ApiAddToShoppingListResultUsageRecipeIds> usageRecipeIds;
    private boolean pantryItem;
    private String aisle;
    private double cost;
    private Long ingredientId;



}
