package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    // 5.1 - blackbox
    // 5.2 - 4 ścieżki
    @Test
    public void testcalculate1() {
        Customer customer = new Customer("Kla", Customer.LoyaltyLevel.SILVER, true);
        assertTrue(customer.isSubscriber());
    }

    @Test
    public void testcalculate2() {
        Customer customer = new Customer("Kla", Customer.LoyaltyLevel.SILVER, false);
        assertFalse(customer.isSubscriber());
        assertSame(customer.getLoyaltyLevel(), Customer.LoyaltyLevel.SILVER);
    }

    @Test
    public void testcalculate3() {
        Customer customer = new Customer("Kla", Customer.LoyaltyLevel.GOLD, false);
        assertFalse(customer.isSubscriber());
        assertSame(customer.getLoyaltyLevel(), Customer.LoyaltyLevel.GOLD);
    }

    @Test
    public void testcalculate4() {
        Customer customer = new Customer("Kla", Customer.LoyaltyLevel.STANDARD, false);
        assertFalse(customer.isSubscriber());
        assertSame(customer.getLoyaltyLevel(), Customer.LoyaltyLevel.STANDARD);
    }

}