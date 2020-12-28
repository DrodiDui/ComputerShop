package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class MotherboardVM {

    private Integer numberOfMemorySlot;
    private Integer maximumMemorySize;
    private Integer maximumMemoryFrequency;
    private String socket;
    private String formFactor;
    private String typeOfMemory;
    private ProductVM product;

}
