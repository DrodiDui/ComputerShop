package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.PowerSupply;
import by.kapitonov.computer.shop.backend.service.dto.PowerSupplyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PowerSupplyService {

    Page<PowerSupply> getAll(Pageable pageable);

    PowerSupply getByProductName(String productName);

    PowerSupply create(PowerSupplyDTO powerSupplyDTO);

}
