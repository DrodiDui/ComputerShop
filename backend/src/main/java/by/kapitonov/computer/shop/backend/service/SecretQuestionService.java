package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.SecretQuestion;

import java.util.List;

public interface SecretQuestionService {

    List<SecretQuestion> getAll();
    List<String> getSecretQuestionsName();
    SecretQuestion getSecretQuestionByName(String questionName);
    SecretQuestion create(String secretQuestion);

}
