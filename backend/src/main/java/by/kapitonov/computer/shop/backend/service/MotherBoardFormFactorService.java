package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.detail.MotherboardFormFactor;

import java.util.List;

public interface MotherBoardFormFactorService {

    List<MotherboardFormFactor> getAll();

    MotherboardFormFactor getByFormFactorName(String formFactorName);

    MotherboardFormFactor create(String formFactorName);
}
