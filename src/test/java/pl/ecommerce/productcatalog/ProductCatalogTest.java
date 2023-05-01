package pl.ecommerce.productcatalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {

    @Test
    void ItAllowsToListMyProducts() {
        // Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        // Act
        List<Product> products = catalog.allProducts();
        // Assert
        assertListIsEmpty(products);
    }

    @Test
    void itAllowsToAddProduct() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct(
                "M-DISC",
                "Optical disc used for archival storage.");
        //Assert
        List<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToLoadProductDetails() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.addProduct(
                "M-DISC",
                "Optical disc used for archival storage.");

        Product loaddedProduct = catalog.loadById(productId);
        assert loaddedProduct.getId().equals(productId);
        assert loaddedProduct.getName().equals("M-DISC");
    }

    @Test
    void itAllowsToChangePrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct(
                "M-DISC",
                "Optical disc used for archival storage.");

        catalog.changePrice(productId, BigDecimal.valueOf(39.99));

        Product loadedProduct = catalog.loadById(productId);
        assertEquals(BigDecimal.valueOf(39.99), loadedProduct.getPrice());
    }

    @Test
    void itAllowsToAssignImage() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct(
                "M-DISC",
                "Optical disc used for archival storage.");

        catalog.assignImage(productId, "images/mdisk.jpg");

        Product loadedProduct = catalog.loadById(productId);
        assertEquals("images/product1.jpg", loadedProduct.getImage());
    }

    @Test
    void itAllowsToPublishProduct() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct(
                "M-DISC",
                "Optical disc used for archival storage.");
        catalog.changePrice(productId, BigDecimal.valueOf(20));
        catalog.assignImage(productId, "images/mdisk.jpg");

        catalog.publishProduct(productId);

        List<Product> publishedProducts = catalog.allPublishedProducts();
        assertDoesNotThrow(() -> catalog.publishProduct(productId));
        assertEquals(1, publishedProducts.size());

    }

    @Test
    void draftProductsAreNotListedForBeingSold() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct(
                "M-DISC",
                "Optical disc used for archival storage.");

        List<Product> publishedProducts = catalog.allPublishedProducts();
        assertEquals(0, publishedProducts.size());
    }

    @Test
    void publicationIsPossibleWhenPriceAndImageAreDefined() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct(
                "M-DISC",
                "Optical disc used for archival storage.");

        assertThrows(
                ProductCantBePublishedException.class,
                () -> catalog.publishProduct(productId));
    }

    private void assertListIsEmpty(List<Product> products) {
        assert 0 == products.size();
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(new HashMapProductStorage());
    }
}
