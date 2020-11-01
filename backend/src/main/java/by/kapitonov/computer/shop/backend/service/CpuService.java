package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.Cpu;
import by.kapitonov.computer.shop.backend.service.dto.CpuDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CpuService {

    Page<Cpu> getAll(Pageable pageable);

    Cpu getByProductName(String productName);

    Cpu create(CpuDTO cpuDTO);

}
