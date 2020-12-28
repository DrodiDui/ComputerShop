package by.kapitonov.computer.shop.backend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Image extends AuditEntity {

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "image_name", nullable = false)
    private String imageName;

    @Column(name = "image_original_name", nullable = false)
    private String imageOriginalName;

}
