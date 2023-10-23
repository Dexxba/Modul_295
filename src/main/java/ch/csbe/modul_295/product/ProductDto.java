package ch.csbe.modul_295.product;

import ch.csbe.modul_295.category.Category;
import jakarta.validation.constraints.NotBlank;

/**
 * This class represents a Data Transfer Object (DTO) for a product.
 * It is used to transfer product information between different parts of an application.
 */
public class ProductDto {
    private String sku;

    // Indicates that 'active' should not be blank
    @NotBlank
    private boolean active;

    private String name;
    private String image;
    private String description;
    private Float price;
    private Integer stock;
    private Category category;

    /**
     * Get the SKU (Stock Keeping Unit) of the product.
     *
     * @return The product's SKU.
     */
    public String getSku() {
        return sku;
    }

    /**
     * Set the SKU (Stock Keeping Unit) of the product.
     *
     * @param sku The product's SKU.
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Check if the product is active.
     *
     * @return True if the product is active, false otherwise.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Set the product's active status.
     *
     * @param active True if the product is active, false otherwise.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Get the name of the product.
     *
     * @return The product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     *
     * @param name The product's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the image URL of the product.
     *
     * @return The product's image URL.
     */
    public String getImage() {
        return image;
    }

    /**
     * Set the image URL of the product.
     *
     * @param image The product's image URL.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get the description of the product.
     *
     * @return The product's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the product.
     *
     * @param description The product's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the price of the product.
     *
     * @return The product's price.
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Set the price of the product.
     *
     * @param price The product's price.
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Get the stock quantity of the product.
     *
     * @return The product's stock quantity.
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Set the stock quantity of the product.
     *
     * @param stock The product's stock quantity.
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Get the category of the product.
     *
     * @return The product's category.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set the category of the product.
     *
     * @param category The product's category.
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * Get a string representation of the ProductDto object.
     * This method provides a formatted string containing key properties of the product.
     *
     * @return A string representation of the ProductDto object.
     */
    @Override
    public String toString() {
        return "ProductDto{" +
                "sku='" + sku + '\'' +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category=" + category +
                '}';
    }
}
