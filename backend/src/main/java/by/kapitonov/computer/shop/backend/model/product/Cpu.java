package by.kapitonov.computer.shop.backend.model.product;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import by.kapitonov.computer.shop.backend.model.product.detail.Socket;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "cpus")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Cpu extends AuditEntity {

    @Column(name = "count_of_core", nullable = false)
    private Integer countOfCore;

    @Column(name = "max_count_of_thread", nullable = false)
    private Integer maxCountOfThread;

    @Column(name = "clock_frequency", nullable = false)
    private Integer clockFrequency;

    @Column(name = "max_clock_frequency", nullable = false)
    private Integer maxClockFrequency;

    @Column(name = "technical_process")
    private String technicalProcess;

    @OneToOne
    @JoinColumn(name = "socket_id", referencedColumnName = "id")
    private Socket socket;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
