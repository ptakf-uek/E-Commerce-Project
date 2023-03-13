package pl.ecommerce;

import org.junit.jupiter.api.Test;

public class FirstClass {

    @Test
    void testIt() {
        assert true == true;
    }

    @Test
    void testIt2() {
        String myName = "Johnny";
        String output = String.format("Hello %s", myName);

        assert output.equals("Hello Johnny");
    }

    void baseSchema() {
        //Arrange   // Given    // Input
        //Act       // When     // Interaction
        //Assert    // Then     // Output
    }
}
