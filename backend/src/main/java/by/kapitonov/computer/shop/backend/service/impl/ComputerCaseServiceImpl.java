package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.ComputerCase;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.detail.ComputerCaseType;
import by.kapitonov.computer.shop.backend.model.product.detail.MotherboardFormFactor;
import by.kapitonov.computer.shop.backend.repository.ComputerCaseRepository;
import by.kapitonov.computer.shop.backend.service.ComputerCaseService;
import by.kapitonov.computer.shop.backend.service.ComputerCaseTypeService;
import by.kapitonov.computer.shop.backend.service.MotherBoardFormFactorService;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.dto.ComputerCaseDTO;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComputerCaseServiceImpl implements ComputerCaseService {

    private final ComputerCaseRepository caseRepository;
    private final ComputerCaseTypeService caseTypeService;
    private final MotherBoardFormFactorService motherBoardFormFactorService;
    private final ProductService productService;

    public ComputerCaseServiceImpl(ComputerCaseRepository caseRepository,
                                   ComputerCaseTypeService caseTypeService,
                                   MotherBoardFormFactorService motherBoardFormFactorService,
                                   ProductService productService) {
        this.caseRepository = caseRepository;
        this.caseTypeService = caseTypeService;
        this.motherBoardFormFactorService = motherBoardFormFactorService;
        this.productService = productService;
    }

    @Override
    public Page<ComputerCase> getAll(Pageable pageable) {
        Page<ComputerCase> computerCases = caseRepository.findAll(pageable);

        if (!computerCases.hasContent()) {
            throw new ProductNotFoundException("Computer cases haven't been found");
        }

        return computerCases;
    }

    @Override
    public ComputerCase getOneByName(String caseName) {
        return caseRepository.findByProduct_ProductName(caseName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Computer case hasn't been found")
                );
    }

    @Override
    public ComputerCase create(ComputerCaseDTO computerCaseDTO) {

        ComputerCase computerCase = ComputerCase.builder()
                .color(computerCaseDTO.getColor())
                .windowMaterial(computerCaseDTO.getWindowMaterial())
                .width(computerCaseDTO.getWidth())
                .depth(computerCaseDTO.getDepth())
                .height(computerCaseDTO.getHeight())
                .weight(computerCaseDTO.getWeight())
                .computerCaseType(getCaseType(computerCaseDTO.getComputerCaseType()))
                .motherboardFormFactor(getFormFactor(computerCaseDTO.getFormFactorName()))
                .product(getProduct(computerCaseDTO.getProductDTO()))
                .build();

        return caseRepository.save(computerCase);
    }

    private MotherboardFormFactor getFormFactor(String motherboardFormFactor) {
        return motherBoardFormFactorService.getByFormFactorName(motherboardFormFactor);
    }

    private ComputerCaseType getCaseType(String caseType) {
        return caseTypeService.getByTypeName(caseType);
    }

    private Product getProduct(ProductDTO productDTO) {
        return productService.create(productDTO);
    }
}
