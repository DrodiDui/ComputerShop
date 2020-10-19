package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ProductVM {

    private Long id;
    private String productName;
    private String description;
    private Integer price;
    private String model;
    private String brand;
    private String ageOfRelease;
    private Integer countInStock;
    private String productCategory;
    private String productStatus;
    private List<ReviewVM> reviews = new ArrayList<>();

}
