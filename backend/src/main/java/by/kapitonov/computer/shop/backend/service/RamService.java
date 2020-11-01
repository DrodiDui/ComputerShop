package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.Ram;
import by.kapitonov.computer.shop.backend.service.dto.RamDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RamService {

    Page<Ram> getAll(Pageable pageable);

    Ram getByProductName(String productName);

    Ram create(RamDTO ramDTO);

}
