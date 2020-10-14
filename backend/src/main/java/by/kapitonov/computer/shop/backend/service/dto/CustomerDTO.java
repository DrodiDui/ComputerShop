package by.kapitonov.computer.shop.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String gender;
    private String cellPhone;
    private String country;
    private String city;
    private String street;
    private String houseNumber;

}
