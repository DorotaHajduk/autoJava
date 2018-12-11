package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


    @DisplayName("Kocurek")
class CalculatorAppTest {

    @Test
    public void addTestInteger() {
        //arrange
        CalculatorApp kalkulatorek = new CalculatorApp();
        //act
        int suma = kalkulatorek.add(1, 2);
        //assert
        Assertions.assertEquals(3, suma, "Sprawdź, że dodawanie liczb całkowitych działa");

    }

    @Test
    public void addTestDouble() {
        //arrange
        CalculatorApp kalkulatorek = new CalculatorApp();
        //act
        double suma = kalkulatorek.add(1.3, 2.3);
        //assert
        Assertions.assertEquals(3.6, suma, 0.0000001, "Czy działa dodawanie liczb niecałkowitych");
    }

    @Test
        public void addTestDzielenie () {
        //arrange
        CalculatorApp kalkulatorek = new CalculatorApp();
        //act
        double divide = kalkulatorek.divide(8, 3);
        //assert
                Assertions.assertEquals(2.66, divide, 0.01, "Czy działa dzielenie liczb");
    }
}
