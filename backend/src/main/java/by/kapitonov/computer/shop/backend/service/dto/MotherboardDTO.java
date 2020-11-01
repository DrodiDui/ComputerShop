package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MotherboardDTO {

    private Integer numberOfMemorySlot;
    private Integer maximumMemorySize;
    private Integer maximumMemoryFrequency;
    private String socketName;
    private String formFactor;
    private String typeOfMemory;
    private ProductDTO productDTO;

}
