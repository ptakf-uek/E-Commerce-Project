package pl.ecommerce.sales;

import java.util.Optional;

public class Sales {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;

    public void addToCart(String customerId, String productId) {
        Cart customerCart = loadCartForCustomer(customerId).orElse(Cart.empty());
        ProductDetails product = loadProductDetails(productId).orElseThrow(() -> new ProductDoesNotExistException());

        customerCart.add(product);
    }

    private Optional<ProductDetails> loadProductDetails(String productId) {
        return productDetailsProvider.load(productId);
    }

    private Optional<Cart> loadCartForCustomer(String customerId) {
        return cartStorage.load(customerId);
    }
}
