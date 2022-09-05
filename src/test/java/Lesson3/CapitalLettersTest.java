package Lesson3;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CapitalLettersTest {
    private static CapitalLetters capitalLetters;

    @BeforeAll
    static void beforeAll() {
        capitalLetters = new CapitalLetters();
    }


    @Test
    @DisplayName("Base scenario")
    void baseTest() {
        String str = capitalLetters.turnIntoCapitalLetters("ab");
        assertThat(str).isEqualTo("AB");
    }

    @Test
    @DisplayName("Some capital letters")
    void testWithCapitalLetters() {
        String str = capitalLetters.turnIntoCapitalLetters("ab CC Dd");
        assertThat(str).isEqualTo("AB CC DD");
    }

    @Test
    @DisplayName("Some numbers")
    void testWithNumbers() {
        String str = capitalLetters.turnIntoCapitalLetters("ab2 CC3 Dd4");
        assertThat(str).isEqualTo("AB2 CC3 DD4");
    }

    @Test
    @DisplayName("Exception 'Massage cant be empty'")
    void exceptionCelsius() {
        assertThatThrownBy(() -> capitalLetters.turnIntoCapitalLetters(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Massage cant be empty");

    }
}