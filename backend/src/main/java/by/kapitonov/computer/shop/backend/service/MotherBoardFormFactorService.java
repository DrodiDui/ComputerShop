package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.detail.MotherboardFormFactor;

import java.util.List;

public interface MotherBoardFormFactorService {

    List<MotherboardFormFactor> getAll();
    List<String> getAllFormFactorNames();

    MotherboardFormFactor getByFormFactorName(String formFactorName);

    MotherboardFormFactor create(String formFactorName);
}
