package pl.ecommerce;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumericRepresentationTest {

    @Test
    void testDoubleRepresentation() {
        double a = 0.02;
        double b = 0.03;
        double c = b - a;

        System.out.println("double 0.03 - 0.02:");
        System.out.println(c);
    }

    @Test
    void testFloatsRepresentation() {
        float a = 0.002f;
        float b = 0.003f;
        float c = b - a;

        System.out.println("float 0.003 - 0.002");
        System.out.println(c);
        System.out.println(a - b);
    }

    @Test
    void testBigdecimalRepresentation() {
        BigDecimal a = new BigDecimal("0.002");
        BigDecimal b = new BigDecimal("0.003");
        BigDecimal c = b.subtract(a);

        System.out.println("Bigdecimal 0.003 - 0.002");
        System.out.println(c);
    }
}
