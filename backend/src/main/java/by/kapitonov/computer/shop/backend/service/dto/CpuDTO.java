package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CpuDTO {

    private Integer countOfCore;
    private Integer maxCountOfThread;
    private Integer clockFrequency;
    private Integer maxClockFrequency;
    private String technicalProcess;
    private String socket;
    private ProductDTO productDTO;

}
