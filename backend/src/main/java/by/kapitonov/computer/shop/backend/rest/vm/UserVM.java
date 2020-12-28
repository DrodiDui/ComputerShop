package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UserVM {

    private String username;
    private String email;
    private CustomerVM customer;

}
