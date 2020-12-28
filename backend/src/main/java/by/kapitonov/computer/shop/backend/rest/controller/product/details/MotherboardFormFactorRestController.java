package by.kapitonov.computer.shop.backend.rest.controller.product.details;

import by.kapitonov.computer.shop.backend.service.MotherBoardFormFactorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/motherboard-form-factors")
public class MotherboardFormFactorRestController {

    private final MotherBoardFormFactorService formFactorService;

    public MotherboardFormFactorRestController(MotherBoardFormFactorService formFactorService) {
        this.formFactorService = formFactorService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllFormFactorNames() {

        List<String> formFactorNames = formFactorService.getAllFormFactorNames();

        return new ResponseEntity<>(formFactorNames, HttpStatus.OK);
    }
}
