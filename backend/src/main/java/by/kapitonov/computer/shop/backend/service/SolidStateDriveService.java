package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.SolidStateDrive;
import by.kapitonov.computer.shop.backend.service.dto.SolidStateDriveDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SolidStateDriveService {

    Page<SolidStateDrive> getAll(Pageable pageable);

    SolidStateDrive getByProductName(String productName);

    SolidStateDrive create(SolidStateDriveDTO solidStateDriveDTO);

}
