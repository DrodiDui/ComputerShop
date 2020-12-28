package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.exception.SecretQuestionNotFoundException;
import by.kapitonov.computer.shop.backend.model.SecretQuestion;
import by.kapitonov.computer.shop.backend.repository.SecretQuestionRepository;
import by.kapitonov.computer.shop.backend.service.SecretQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecretQuestionServiceImpl implements SecretQuestionService {

    private final SecretQuestionRepository secretQuestionRepository;

    public SecretQuestionServiceImpl(SecretQuestionRepository secretQuestionRepository) {
        this.secretQuestionRepository = secretQuestionRepository;
    }

    @Override
    public List<SecretQuestion> getAll() {
        List<SecretQuestion> secretQuestions = secretQuestionRepository.findAll();

        if (secretQuestions.isEmpty()) {
            throw new SecretQuestionNotFoundException("Secret question haven't been found");
        }

        return secretQuestions;
    }

    @Override
    public List<String> getSecretQuestionsName() {
        List<String> questions = secretQuestionRepository.findAll()
                .stream()
                .map(SecretQuestion::getSecretQuestionName)
                .collect(Collectors.toList());

        if (questions.isEmpty()) {
            throw new SecretQuestionNotFoundException("Secret questions hasn't been found");
        }

        return questions;
    }

    @Override
    public SecretQuestion getSecretQuestionByName(String questionName) {
        return secretQuestionRepository.findBySecretQuestionName(questionName)
                .orElseThrow(
                        () -> new SecretQuestionNotFoundException("Secret question hasn't been found")
                );
    }

    @Override
    public SecretQuestion create(String secretQuestion) {
        return secretQuestionRepository.save(new SecretQuestion(secretQuestion));
    }
}
