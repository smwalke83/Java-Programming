import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    // calculator object for testing
    Calculator calculator;
    // setup run before testing
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    // simple test with a display name, disabled
    @Test
    @DisplayName("Simple multiplication should work")
    @Disabled
    void testMultiply() {
        assertEquals(20, calculator.multiply(4,5), "Regular multiplication should work");
    }
    // testing multiply by zero, runs five times
    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        assertEquals(0, calculator.multiply(0,5), "Multiply with zero should be zero");
        assertEquals(0, calculator.multiply(5,0), "Multiply with zero should be zero");
    }
}