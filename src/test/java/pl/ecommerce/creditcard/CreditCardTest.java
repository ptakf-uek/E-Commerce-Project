package pl.ecommerce.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("1234-0000");
        //Act
        card.assignLimit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
        assert card.getBalance().equals(BigDecimal.valueOf(1000));
    }

    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("8765-4321");
        //Act
        card1.assignLimit(BigDecimal.valueOf(1000));
        card2.assignLimit(BigDecimal.valueOf(1100));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assert card1.getBalance().equals(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000), card2.getBalance());
        assert card2.getBalance().equals(BigDecimal.valueOf(1000));
    }

    @Test
    void itCantAssignLimitBelow100() {
        CreditCard card = new CreditCard("1234-0000");

        assertThrows(CreditCardBelowTresholdException.class,
                () -> card.assignLimit(BigDecimal.valueOf(10)));
        assertThrows(CreditCardBelowTresholdException.class,
                () -> card.assignLimit(BigDecimal.valueOf(99)));

        card.assignLimit(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
        assert card.getBalance().equals(BigDecimal.valueOf(1000));
    }

    @Test
    void testDoubleAndFloats() {
    }
}
