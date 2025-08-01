package org.lessons.java.crudrelazioni.spring_la_mia_pizzeria;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizzas")
public class Pizza {

    public Pizza(Integer id, String name, String description, String imageURL, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
    }

    public Pizza() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "pizza")
    private List<SpecialOffert> specialOfferts;

    @Column(nullable = false)
    @NotBlank(message = "Must insert a name")
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 characters long")
    private String name;

    @Lob
    @Size(min = 3, max = 500, message = "The description must be at most 500 characters long")
    private String description;

    @Column(name = "image_url")
    @Size(max = 300, message = "The image URL must be at most 300 characters long")
    private String imageURL;

    @Column(nullable = false)
    @NotNull(message = "Must insert a price")
    @DecimalMin(value = "0.00", inclusive = false, message = "The price cannot be equal or less than 0.00")
    private BigDecimal price;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<SpecialOffert> getSpecialOfferts() {
        return this.specialOfferts;
    }

    public void setSpecialOfferts(List<SpecialOffert> specialOfferts) {
        this.specialOfferts = specialOfferts;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", imageURL='" + getImageURL() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}
