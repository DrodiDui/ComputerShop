package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class CreateProductVM {

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
