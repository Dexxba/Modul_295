package ch.csbe.modul_295.category;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {
    private boolean active;
    @NotBlank
    private String name;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "active=" + active +
                ", name='" + name + '\'' +
                '}';
    }
}

