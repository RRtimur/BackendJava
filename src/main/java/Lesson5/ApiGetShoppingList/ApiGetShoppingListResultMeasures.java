package Lesson5.ApiGetShoppingList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiGetShoppingListResultMeasures {
    private ApiGetShoppingListResultOriginal original;
    private ApiGetShoppingListResultMetric metric;
    private ApiGetShoppingListResultUs us;
}
