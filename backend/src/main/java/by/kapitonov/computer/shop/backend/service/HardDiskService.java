package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.HardDisk;
import by.kapitonov.computer.shop.backend.service.dto.HardDiskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HardDiskService {

    Page<HardDisk> getAll(Pageable pageable);

    HardDisk getByProductName(String productName);

    HardDisk create(HardDiskDTO hardDiskDto);

}
