package pl.ecommerce.productcatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String productId;
    private final String name;
    private final String description;
    private BigDecimal price;
    private String image;
    private boolean isOnline;

    public Product(UUID uuid, String name, String description) {
        this.productId = uuid.toString();
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return productId;
    }

    public UUID getUuid() {
        return UUID.fromString(productId);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageKey) {
        this.image = imageKey;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
