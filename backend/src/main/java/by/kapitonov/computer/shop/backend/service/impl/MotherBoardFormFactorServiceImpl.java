package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductDetailsAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.ProductDetailsNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.detail.MotherboardFormFactor;
import by.kapitonov.computer.shop.backend.repository.MotherboardFormFactorRepository;
import by.kapitonov.computer.shop.backend.service.MotherBoardFormFactorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotherBoardFormFactorServiceImpl implements MotherBoardFormFactorService {

    private final MotherboardFormFactorRepository formFactorRepository;

    public MotherBoardFormFactorServiceImpl(MotherboardFormFactorRepository formFactorRepository) {
        this.formFactorRepository = formFactorRepository;
    }

    @Override
    public List<MotherboardFormFactor> getAll() {
        List<MotherboardFormFactor> formFactors = formFactorRepository.findAll();

        if (formFactors.isEmpty()) {
            throw new ProductDetailsNotFoundException("Mother board form factors haven't been found");
        }

        return formFactors;
    }

    @Override
    public MotherboardFormFactor getByFormFactorName(String formFactorName) {
        return formFactorRepository.findByProduct_ProductName(formFactorName)
                .orElseThrow(
                        () -> new ProductDetailsNotFoundException("Motherboard form factor hasn't been found")
                );
    }

    @Override
    public MotherboardFormFactor create(String formFactorName) {
        if (formFactorRepository.existsByFormFactorName(formFactorName)) {
            throw new ProductDetailsAlreadyExists("Motherboard form factor already exists");
        }
        return formFactorRepository.save(new MotherboardFormFactor(formFactorName));
    }
}
