package Lesson3;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CelsiusToFahrenheitTest {
    private static CelsiusToFahrenheit celsiusToFahrenheit;

    @BeforeAll
    static void beforeAll() {
        celsiusToFahrenheit = new CelsiusToFahrenheit();
    }


    @Test
    @DisplayName("Base scenario")
    void baseTest() {
        double fahrenheit = celsiusToFahrenheit.convertCelsiusToFahrenheit(20);
        assertThat(fahrenheit).isEqualTo(68);

    }

    @Test
    @DisplayName("Minimal celsius -273.15")
    void minCelsius() {
        double fahrenheit = celsiusToFahrenheit.convertCelsiusToFahrenheit(-273.15);
        assertThat(fahrenheit).isEqualTo(-459.669);
    }


    @Test
    @DisplayName("celsius is 0")
    void zeroCelsius() {
        double fahrenheit = celsiusToFahrenheit.convertCelsiusToFahrenheit(0);
        assertThat(fahrenheit).isEqualTo(32);
    }

    @Test
    @DisplayName("celsius is lower then -273.15")
    void exceptionCelsius() {
        assertThatThrownBy(() -> celsiusToFahrenheit.convertCelsiusToFahrenheit(-273.16))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Celsius cannot be lower than -273.15");

    }

}
