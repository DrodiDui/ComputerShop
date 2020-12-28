package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.detail.ComputerCaseType;

import java.util.List;

public interface ComputerCaseTypeService {

    List<ComputerCaseType> getAll();
    List<String> getComputerCaseTypesName();

    ComputerCaseType getByTypeName(String caseTypeName);

    ComputerCaseType create(String caseType);

}
