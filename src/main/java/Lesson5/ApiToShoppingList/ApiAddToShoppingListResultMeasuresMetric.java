package Lesson5.ApiToShoppingList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiAddToShoppingListResultMeasuresMetric {
    private double amount;
    private String unit;
}
