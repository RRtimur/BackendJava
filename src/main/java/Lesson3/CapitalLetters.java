package Lesson3;

import java.util.Locale;

public class CapitalLetters {
    public String turnIntoCapitalLetters(String massage){
        if (massage == "") {
            throw new IllegalArgumentException("Massage cant be empty");
        }
        String upperMassage = massage.toUpperCase();
        return upperMassage;
    }


}
