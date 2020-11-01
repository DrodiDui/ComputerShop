package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.CoolingSystem;
import by.kapitonov.computer.shop.backend.service.dto.CoolingSystemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoolingSystemService {

    Page<CoolingSystem> getAll(Pageable pageable);

    CoolingSystem getByProductName(String productName);

    CoolingSystem create(CoolingSystemDTO coolingSystemDTO);

}
