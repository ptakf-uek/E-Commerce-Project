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
        assertEquals(BigDecimal.valueOf(1000), card.getCreditLimit());

        assert card.getCreditLimit().equals(BigDecimal.valueOf(1000));
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
        assertEquals(BigDecimal.valueOf(1000), card1.getCreditLimit());
        assert card1.getCreditLimit().equals(BigDecimal.valueOf(1000));

        assertEquals(BigDecimal.valueOf(1100), card2.getCreditLimit());
        assert card2.getCreditLimit().equals(BigDecimal.valueOf(1100));
    }

    @Test
    void itCantAssignCreditLimitBelow100() {
        CreditCard card1 = new CreditCard("1234-0001");
        CreditCard card2 = new CreditCard("1234-0002");
        CreditCard card3 = new CreditCard("1234-0003");

        assertThrows(CreditLimitBelowTresholdException.class,
                () -> card1.assignLimit(BigDecimal.valueOf(10)));

        assertThrows(CreditLimitBelowTresholdException.class,
                () -> card2.assignLimit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(() -> card3.assignLimit(BigDecimal.valueOf(100)));

        try {
            card1.assignLimit(BigDecimal.valueOf(10));
            fail("Should throw exception");
        } catch (CreditLimitBelowTresholdException e) {
            assertTrue(true);
        }
    }

    @Test
    void itCantAssignLimitTwice() {
        CreditCard card1 = new CreditCard("1234-0001");
        card1.assignLimit(BigDecimal.valueOf(1000));

        assertThrows(
                CreditLimitAlreadyAssignedException.class,
                () -> card1.assignLimit(BigDecimal.valueOf(1500)));
    }

    @Test
    void itAllowsToWithdraw() {
        CreditCard card1 = new CreditCard("1234-0001");
        card1.assignLimit(BigDecimal.valueOf(100));
        card1.deposit(BigDecimal.valueOf(1000));
        card1.withdraw(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(900), card1.getBalance());
    }
}
