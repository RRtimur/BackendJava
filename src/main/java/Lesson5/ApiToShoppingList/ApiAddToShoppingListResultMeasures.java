package Lesson5.ApiToShoppingList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiAddToShoppingListResultMeasures {

    private ApiAddToShoppingListResultMeasuresOriginal original;
    private ApiAddToShoppingListResultMeasuresMetric metric;
    private ApiAddToShoppingListResultMeasuresUs us;
}
