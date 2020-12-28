package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.Motherboard;
import by.kapitonov.computer.shop.backend.service.dto.MotherboardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface MotherboardService {

    Page<Motherboard> getAll(Pageable pageable);

    Motherboard getByProductName(String motherboardName);

    Motherboard create(MotherboardDTO motherboardDTO);

}
