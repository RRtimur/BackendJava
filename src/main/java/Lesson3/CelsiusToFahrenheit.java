package Lesson3;

import java.text.DecimalFormat;

public class CelsiusToFahrenheit {

    public double convertCelsiusToFahrenheit(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Celsius cannot be lower than -273.15");
        }

        double fahrenheit = (celsius * 9 / 5) + 32;
        double scale = Math.pow(10, 3);
        double result = Math.ceil(fahrenheit * scale) / scale;
        return result;
    }

}