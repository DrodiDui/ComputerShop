package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductDTO {

    private String productName;
    private String description;
    private Integer price;
    private String model;
    private String brand;
    private String ageOfRelease;
    private Integer countInStock;
    private String productCategory;
    private String productStatus;

}
