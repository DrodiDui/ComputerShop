package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class SignUpVm {

    private String username;
    private String email;
    private String password;
    private String secretQuestion;
    private String questionAnswer;

}
