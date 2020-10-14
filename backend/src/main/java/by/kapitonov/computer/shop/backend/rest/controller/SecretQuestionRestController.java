package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.model.SecretQuestion;
import by.kapitonov.computer.shop.backend.rest.mapper.SecretQuestionMapper;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.SecretQuestionVM;
import by.kapitonov.computer.shop.backend.service.SecretQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secret-questions")
public class SecretQuestionRestController {

    private final SecretQuestionService secretQuestionService;

    public SecretQuestionRestController(SecretQuestionService secretQuestionService) {
        this.secretQuestionService = secretQuestionService;
    }

    @GetMapping()
    public ResponseEntity<List<SecretQuestionVM>> getAllSecretQuestion() {

        List<SecretQuestion> secretQuestions = secretQuestionService.getAll();
        List<SecretQuestionVM> secretQuestionVMList = SecretQuestionMapper.INSTANCE.entityListToVMList(secretQuestions);

        return new ResponseEntity<>(secretQuestionVMList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createSecretQuestion(@RequestBody String secretQuestion) {

        secretQuestionService.create(secretQuestion);

        return new ResponseEntity<>(new ApiResponse("Secret question successfully created"), HttpStatus.OK);
    }
}
