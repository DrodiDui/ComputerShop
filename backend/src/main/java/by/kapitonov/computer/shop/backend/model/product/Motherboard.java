package by.kapitonov.computer.shop.backend.model.product;

import by.kapitonov.computer.shop.backend.model.*;
import by.kapitonov.computer.shop.backend.model.product.detail.MotherboardFormFactor;
import by.kapitonov.computer.shop.backend.model.product.detail.Socket;
import by.kapitonov.computer.shop.backend.model.product.detail.RamMemoryType;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "motherboards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Motherboard extends AuditEntity {


    @Column(name = "number_of_memory_slot", nullable = false)
    private Integer numberOfMemorySlot;

    @Column(name = "maximum_memory_size", nullable = false)
    private Integer maximumMemorySize;

    @Column(name = "maximum_memory_frequency", nullable = false)
    private Integer maximumMemoryFrequency;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "socket_id", referencedColumnName = "id")
    private Socket socket;

    @OneToOne
    @JoinColumn(name = "form_factor_id", referencedColumnName = "id")
    private MotherboardFormFactor formFactor;

    @OneToOne
    @JoinColumn(name = "type_of_memory_id", referencedColumnName = "id")
    private RamMemoryType typeOfMemory;


}