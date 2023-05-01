package pl.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTestSchemaTest {

    @Test
    void firstTest() {
        boolean value = true;
        assertTrue(value);
    }

    @Test
    void secondTest() {
        String myName = "Johnny";
        String output = String.format("Hello %s", myName);

        assert output.equals("Hello Johnny");
    }

    @Test
    void thirdTest() {
        assert true == true;
    }

    void baseTestSchema() {
        //Arrange   // Given    // Input

        //Act       // When     // Interaction

        //Assert    // Then     // Output

    }
}
