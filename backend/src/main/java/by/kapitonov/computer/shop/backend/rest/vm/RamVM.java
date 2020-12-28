package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RamVM {

    private Integer size;
    private Integer frequency;
    private Boolean cooling;
    private Boolean backlight;
    private String ramMemoryType;
    private ProductVM product;

}
