package ch.csbe.modul_295.category;

import ch.csbe.modul_295.product.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Column(columnDefinition = "tinyint", nullable = false)
    private Boolean active = false;

    @Column(columnDefinition = "Varchar(255)", nullable = false)
    private String name;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
