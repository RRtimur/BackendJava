package Lesson5.ApiGetShoppingList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiGetShoppingListResultMetric {
    private double amount;
    private String unit;
}
