package Lesson5.ApiGetShoppingList;

import Lesson5.ApiToShoppingList.ApiAddToShoppingListResultMeasures;
import Lesson5.ApiToShoppingList.ApiAddToShoppingListResultUsageRecipeIds;
import Lesson5.ApiToShoppingList.ApiAddToShoppingListResultUsages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiGetShoppingListResult {
    private List<ApiGetShoppingListResultAisles> aisles;
    private double cost;
    private Long startDate;
    private Long endDate;


}
