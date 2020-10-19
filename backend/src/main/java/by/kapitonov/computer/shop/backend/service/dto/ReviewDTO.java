package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ReviewDTO {

    private String message;
    private String advantages;
    private String disadvantages;
    private Long productId;

}
