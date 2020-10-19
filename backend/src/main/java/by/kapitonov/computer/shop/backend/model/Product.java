package by.kapitonov.computer.shop.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Table(name = "products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Product extends AuditEntity {

    @Column(name = "product_name", nullable = false, length = 50)
    private String productName;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "price", nullable = false, length = 100)
    private Integer price;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;

    @Column(name = "age_of_release", nullable = false, length = 10)
    private String ageOfRelease;

    @Column(name = "count_in_stock", nullable = false, length = 255)
    private Integer countInStock;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private ProductStatus productStatus;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Review> reviews = new ArrayList<>();

}
