package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.GenderNotFoundException;
import by.kapitonov.computer.shop.backend.model.Gender;
import by.kapitonov.computer.shop.backend.repository.GenderRepository;
import by.kapitonov.computer.shop.backend.service.GenderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;

    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public List<Gender> getAll() {
        List<Gender> genders = genderRepository.findAll();

        if (genders.isEmpty()) {
            throw new GenderNotFoundException("Genders haven't been found");
        }

        return genders;
    }

    @Override
    public List<String> getAllGenderNames() {
        List<String> genderNames = genderRepository.findAll()
                .stream()
                .map(Gender::getGenderName)
                .collect(Collectors.toList());
        if (genderNames.isEmpty()) {
            throw new GenderNotFoundException("Gender names haven't been found");
        }

        return genderNames;
    }

    @Override
    public Gender create(String genderName) {
        return genderRepository.save(new Gender(genderName));
    }
}
