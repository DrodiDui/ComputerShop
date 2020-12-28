package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.Gender;

import java.util.List;

public interface GenderService {

    List<Gender> getAll();
    List<String> getAllGenderNames();
    Gender create(String genderName);

}
