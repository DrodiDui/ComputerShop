package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductDetailsAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.ProductDetailsNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.detail.ComputerCaseType;
import by.kapitonov.computer.shop.backend.repository.ComputerCaseTypeRepository;
import by.kapitonov.computer.shop.backend.service.ComputerCaseTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerCaseTypeServiceImpl implements ComputerCaseTypeService {

    private final ComputerCaseTypeRepository caseTypeRepository;

    public ComputerCaseTypeServiceImpl(ComputerCaseTypeRepository caseTypeRepository) {
        this.caseTypeRepository = caseTypeRepository;
    }

    @Override
    public List<ComputerCaseType> getAll() {
        List<ComputerCaseType> caseTypes = caseTypeRepository.findAll();

        if (caseTypes.isEmpty()) {
            throw new ProductDetailsNotFoundException("Computer case types haven't been found");
        }
        return caseTypes;
    }

    @Override
    public ComputerCaseType getByTypeName(String caseTypeName) {
        return caseTypeRepository.findByCaseTypeName(caseTypeName)
                .orElseThrow(
                        () -> new ProductDetailsNotFoundException("Computer case type hasn't been found")
                );
    }

    @Override
    public ComputerCaseType create(String caseType) {
        if (caseTypeRepository.existsByCaseTypeName(caseType)) {
            throw new ProductDetailsAlreadyExists("Computer case type already exists");
        }
        return caseTypeRepository.save(new ComputerCaseType(caseType));
    }
}
