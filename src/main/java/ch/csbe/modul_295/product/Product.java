package ch.csbe.modul_295.product;

import ch.csbe.modul_295.category.Category;
import jakarta.persistence.*;

/**
 * This class represents a product entity in the database.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne()
    @JoinColumn(name = "categoryid", nullable = false)
    private Category category;


    @Column(columnDefinition = "Varchar(100)", nullable = false)
    private String sku;

    @Column(columnDefinition = "tinyint", nullable = false)
    private Boolean active = false;

    @Column(columnDefinition = "Varchar(500)", nullable = false)
    private String name;
    @Column(columnDefinition = "Varchar(1000)", nullable = false)
    private String image;

    @Column(columnDefinition = "mediumtext", nullable = false)
    private String description;

    @Column(columnDefinition = "float", nullable = false)
    private Float price;


    @Column(columnDefinition = "int", nullable = false)
    private Integer stock;

    /**
     * Get the ID of the product.
     *
     * @return The product ID.
     */
    public long getId() {
        return id;
    }

    /**
     * Set the ID of the product.
     *
     * @param id The product ID to set.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the category of the product.
     *
     * @return The product category.
     */
    public Category getCategoryRepository() {
        return category;
    }

    /**
     * Set the category of the product.
     *
     * @param categoryRepository The product category to set.
     */
    public void setCategoryRepository(Category categoryRepository) {
        this.category = categoryRepository;
    }

    /**
     * Get the SKU (Stock Keeping Unit) of the product.
     *
     * @return The product SKU.
     */
    public String getSku() {
        return sku;
    }

    /**
     * Set the SKU (Stock Keeping Unit) of the product.
     *
     * @param sku The product SKU to set.
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Check if the product is active.
     *
     * @return True if the product is active, false otherwise.
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Set whether the product is active or not.
     *
     * @param active True to mark the product as active, false to mark it as inactive.
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Get the name of the product.
     *
     * @return The product name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     *
     * @param name The product name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the image URL of the product.
     *
     * @return The product image URL.
     */
    public String getImage() {
        return image;
    }

    /**
     * Set the image URL of the product.
     *
     * @param image The product image URL to set.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get the description of the product.
     *
     * @return The product description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the product.
     *
     * @param description The product description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the price of the product.
     *
     * @return The product price.
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Set the price of the product.
     *
     * @param price The product price to set.
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Get the stock quantity of the product.
     *
     * @return The product stock quantity.
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Set the stock quantity of the product.
     *
     * @param stock The product stock quantity to set.
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
