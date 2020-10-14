package by.kapitonov.computer.shop.backend.rest.vm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerVM {

    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String city;
    private String street;
    private String houseNumber;

}
