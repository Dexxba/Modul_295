package ch.csbe.modul_295.category;

import jakarta.validation.constraints.NotBlank;

/**
 * The CategoryDto class represents a data transfer object for product categories.
 */
public class CategoryDto {
    private boolean active;

    @NotBlank
    private String name;

    /**
     * Get the status of the category (active or not).
     *
     * @return A boolean value indicating the category's status.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Set the status of the category (active or not).
     *
     * @param active A boolean value to set the category's status.
     */
    public void setActive(boolean active) {
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
     * Generates a String representation of the CategoryDto object.
     *
     * @return A String containing the values of active and name.
     */
    @Override
    public String toString() {
        return "CategoryDto{" +
                "active=" + active +
                ", name='" + name + '\'' +
                '}';
    }
}
