package ch.csbe.modul_295.category;

import ch.csbe.modul_295.product.Product;

import jakarta.persistence.*;

import java.util.List;

/**
 * The Category class represents a product category in the application.
 */
@Entity
public class Category {

    @Column(columnDefinition = "tinyint", nullable = false)
    private Boolean active = false;

    @Column(columnDefinition = "Varchar(255)", nullable = false)
    private String name;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    /**
     * Get the status of the category (active or not).
     *
     * @return A Boolean value indicating the category's status.
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Set the status of the category (active or not).
     *
     * @param active A Boolean value to set the category's status.
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Get the name of the category.
     *
     * @return A String representing the category's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the category.
     *
     * @param name A String to set the category's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the unique identifier for the category.
     *
     * @return An Integer representing the category's unique identifier.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the unique identifier for the category.
     *
     * @param id An Integer to set the category's unique identifier.
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
