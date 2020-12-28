package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.model.SecretQuestion;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.SecretQuestionVM;
import by.kapitonov.computer.shop.backend.service.SecretQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/secret-questions")
public class SecretQuestionRestController {

    private final SecretQuestionService secretQuestionService;

    public SecretQuestionRestController(SecretQuestionService secretQuestionService) {
        this.secretQuestionService = secretQuestionService;
    }

    @GetMapping()
    public ResponseEntity<List<String>> getAllSecretQuestion() {

        List<String> questions = secretQuestionService.getSecretQuestionsName();

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createSecretQuestion(@RequestBody String secretQuestion) {

        secretQuestionService.create(secretQuestion);

        return new ResponseEntity<>(new ApiResponse("Secret question successfully created"), HttpStatus.OK);
    }
}
