package pl.ecommerce.productcatalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {
    private ProductCatalog productCatalog;

    CatalogController(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }


    @GetMapping("api/products")
    public List<Product> allPublishedProducts() {
        return productCatalog.allPublishedProducts();
    }
}
