package by.kapitonov.computer.shop.backend.model.product;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import by.kapitonov.computer.shop.backend.model.Image;
import by.kapitonov.computer.shop.backend.model.PaymentMethod;
import by.kapitonov.computer.shop.backend.model.product.detail.ProductCategory;
import by.kapitonov.computer.shop.backend.model.product.detail.ProductStatus;
import by.kapitonov.computer.shop.backend.model.Review;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preview_image_id", referencedColumnName = "id")
    private Image previewImage;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "product_images",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")}
    )
    private List<Image> images;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private ProductStatus productStatus;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Review> reviews = new ArrayList<>();

}
