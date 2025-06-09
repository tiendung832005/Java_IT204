package com.data.session20.entity;


import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "seeds", uniqueConstraints = @UniqueConstraint(columnNames = "seedName"))
public class Seed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Seed name cannot be empty")
    @Size(max = 100, message = "Seed name must be at most 100 characters")
    private String seedName;

    @Column
    private String description;

    @Column(nullable = false)
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @Column(nullable = false)
    @Min(value = 0, message = "Stock must be greater than or equal to 0")
    private Integer stock;

    @Column
    private String image; // URL of the image uploaded to Cloudinary

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeedName() {
        return seedName;
    }

    public void setSeedName(String seedName) {
        this.seedName = seedName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}