package by.kapitonov.computer.shop.backend.rest.controller.product;

import by.kapitonov.computer.shop.backend.model.product.ComputerCase;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.service.ComputerCaseService;
import by.kapitonov.computer.shop.backend.service.dto.ComputerCaseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computer-cases")
public class ComputerCaseRestController {

    private final ComputerCaseService computerCaseService;

    public ComputerCaseRestController(ComputerCaseService computerCaseService) {
        this.computerCaseService = computerCaseService;
    }

    @GetMapping
    public ResponseEntity<List<ComputerCase>> getAllCases(Pageable pageable) {

        List<ComputerCase> computerCases = computerCaseService.getAll(pageable).getContent();

        return new ResponseEntity<>(computerCases, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ComputerCase> getCaseByName(@PathVariable(name = "name") String caseName) {

        ComputerCase computerCase = computerCaseService.getOneByName(caseName);

        return new ResponseEntity<>(computerCase, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createComputerCase(@RequestBody ComputerCaseDTO computerCaseDTO) {

        computerCaseService.create(computerCaseDTO);

        return new ResponseEntity<>(new ApiResponse("Computer case successfully created"), HttpStatus.OK);
    }
}
