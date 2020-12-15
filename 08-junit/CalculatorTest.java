package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    // 3.1 - BeforeEach umożliwia każdej z metod wprowadzanie zmian na swoim wlasnym obiekcie - BeforeAll by w tym przypadku się nie sprawdziło, bo powstałby jeden obiekt dla wszystkich metod i zmiany na nim wykonywane przez każdą metodę mogłyby kolidować ze sobą
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testadd() {
        assertEquals(calculator.add(5, 8), 13);
        assertEquals(calculator.add(256, 64), 320);
    }

    @Test
    public void testmultiply() {
        assertEquals(calculator.multiply(5, 8), 40);
        assertEquals(calculator.multiply(2, 64), 128);
    }

    @Test
    public void testaddPositiveNumbers() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-5, 8);
        });
    }

}