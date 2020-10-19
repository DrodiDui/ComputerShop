package by.kapitonov.computer.shop.backend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Embeddable
public class Address {

    @Column(name = "country", nullable = true, length = 50)
    private String country;

    @Column(name = "city", nullable = true, length = 50)
    private String city;

    @Column(name = "street", nullable = true, length = 50)
    private String street;

    @Column(name = "house_number", nullable = true, length = 50)
    private String houseNumber;

}
