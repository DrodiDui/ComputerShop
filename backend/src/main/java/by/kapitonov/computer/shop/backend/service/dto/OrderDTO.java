package by.kapitonov.computer.shop.backend.service.dto;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class OrderDTO {

    private String orderStatus;
    private List<Long> productId;

}
