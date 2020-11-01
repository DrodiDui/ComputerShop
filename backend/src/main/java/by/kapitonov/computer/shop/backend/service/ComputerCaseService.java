package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.ComputerCase;
import by.kapitonov.computer.shop.backend.service.dto.ComputerCaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ComputerCaseService {

    Page<ComputerCase> getAll(Pageable pageable);

    ComputerCase getOneByName(String caseName);

    ComputerCase create(ComputerCaseDTO computerCaseDTO);

}
