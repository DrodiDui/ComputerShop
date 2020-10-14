package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private String role;
    private String status;
    private String secretQuestion;
    private String secretQuestionAnswer;

}
