package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.SecretQuestion;

import java.util.List;

public interface SecretQuestionService {

    List<SecretQuestion> getAll();
    SecretQuestion create(String secretQuestion);

}
