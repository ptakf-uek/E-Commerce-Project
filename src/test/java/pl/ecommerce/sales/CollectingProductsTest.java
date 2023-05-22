package pl.ecommerce.sales;

import org.junit.jupiter.api.Test;
import pl.ecommerce.productcatalog.Product;
import pl.ecommerce.productcatalog.ProductCatalog;

import java.util.List;
import java.util.UUID;

public class CollectingProductsTest {

    @Test
    void itAllowsToAddProduct() {
        Sales sales = thereIsSalesModule();
        String product = thereIsProduct();
        String customerId = thereIsCustomer();

        sales.addToCart(customerId, product);

        assertThereIsXProductsInCustomerCart(1, customerId);
    }

    private void assertThereIsXProductsInCustomerCart(int totalProductsQuantity, String customerId) {
        /*Cart customerCart = CartStorage.load(customerId).orElse(Cart.empty());
        List<Product> products = customerCart.allProducts();

        assert totalProductsQuantity == products.size();*/
    }

    private String thereIsCustomer() {
    }

    private String thereIsProduct() {
        return UUID.randomUUID().toString();
    }

    private Sales thereIsSalesModule() {
        return new Sales();
    }
}
