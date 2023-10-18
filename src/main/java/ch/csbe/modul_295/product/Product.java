package ch.csbe.modul_295.product;

import ch.csbe.modul_295.category.Category;
import ch.csbe.modul_295.users.Users;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne()
    @JoinColumn(name = "categoryid", nullable = false)
    private Category category;


    @Column(columnDefinition = "Varchar(100)",nullable = false)
    private String sku;

    @Column(columnDefinition = "tinyint", nullable = false)
    private Boolean active = false;

    @Column(columnDefinition = "Varchar(500)",nullable = false)
    private String name;
    @Column(columnDefinition = "Varchar(1000)",nullable = false)
    private String image;

    @Column(columnDefinition = "mediumtext",nullable = false)
    private String description;

    @Column(columnDefinition = "float",nullable = false)
    private Float price;


    @Column(columnDefinition = "int",nullable = false)
    private Integer stock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategoryRepository() {
        return category;
    }

    public void setCategoryRepository(Category categoryRepository) {
        this.category = categoryRepository;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
