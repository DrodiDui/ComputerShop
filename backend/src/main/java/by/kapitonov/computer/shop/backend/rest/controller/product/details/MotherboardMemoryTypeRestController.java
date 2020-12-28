package by.kapitonov.computer.shop.backend.rest.controller.product.details;

import by.kapitonov.computer.shop.backend.service.RamMemoryTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/motherboard-memory-types")
public class MotherboardMemoryTypeRestController {

    private final RamMemoryTypeService memoryTypeService;

    public MotherboardMemoryTypeRestController(RamMemoryTypeService memoryTypeService) {
        this.memoryTypeService = memoryTypeService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllMemoryTypeName() {
        List<String> memoryTypeNames = memoryTypeService.getAllMemoryTypeNames();

        return new ResponseEntity<>(memoryTypeNames, HttpStatus.OK);
    }
}
