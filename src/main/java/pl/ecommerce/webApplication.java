package pl.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.ecommerce.productcatalog.HashMapProductStorage;
import pl.ecommerce.productcatalog.ProductCatalog;

import java.math.BigDecimal;

@SpringBootApplication
public class webApplication {
    public static void main(String[] args) {
        SpringApplication.run(webApplication.class, args);
    }

    @Bean
    ProductCatalog createNewProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());

        String productId1 = productCatalog.addProduct(
                "Johnny Guitar",
                "Vinyl record containing the title track of the 1954 film, Johnny Guitar, written by Peggy Lee.");
        productCatalog.assignImage(productId1, "images/productId1.jpg");
        productCatalog.changePrice(productId1, BigDecimal.valueOf(9000));
        productCatalog.publishProduct(productId1);

        String productId2 = productCatalog.addProduct(
                "Why Don't You Do Right?",
                "Vinyl record containing the hit single from 1942 sang by Peggy Lee.");
        productCatalog.assignImage(productId2, "images/productId2.jpg");
        productCatalog.changePrice(productId2, BigDecimal.valueOf(1));
        productCatalog.publishProduct(productId2);

        return productCatalog;
    }
}
