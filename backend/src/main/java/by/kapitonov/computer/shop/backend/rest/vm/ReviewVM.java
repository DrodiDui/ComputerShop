package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReviewVM {

    private Long id;
    private String message;
    private String advantages;
    private String disadvantages;
    private UserVM userVM;
    private Instant createdDate;

}
