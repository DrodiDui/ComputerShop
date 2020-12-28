package by.kapitonov.computer.shop.backend.rest.controller.product;

import by.kapitonov.computer.shop.backend.model.product.Motherboard;
import by.kapitonov.computer.shop.backend.rest.mapper.MotherboardMapper;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.MotherboardVM;
import by.kapitonov.computer.shop.backend.service.MotherboardService;
import by.kapitonov.computer.shop.backend.service.dto.MotherboardDTO;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/motherboards")
@Api
public class MotherboardRestController {

    private final MotherboardService motherboardService;

    public MotherboardRestController(MotherboardService motherboardService) {
        this.motherboardService = motherboardService;
    }

    @GetMapping("")
    public ResponseEntity<List<MotherboardVM>> getAllMotherboard(Pageable pageable) {

        List<Motherboard> motherboards = motherboardService.getAll(pageable).getContent();
        List<MotherboardVM> resultList = MotherboardMapper.motherboardsToMotherboardsVM(motherboards);

        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<MotherboardVM> getMotherboardByName(@PathVariable(name = "name") String productName) {

        Motherboard motherboard = motherboardService.getByProductName(productName);
        MotherboardVM motherboardVM = MotherboardMapper.motherboardToMotherboardVM(motherboard);

        return new ResponseEntity<>(motherboardVM, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createMotherboard(
            @RequestBody MotherboardDTO motherboardDTO,
            MultipartFile previewImage
    ) {

        motherboardDTO.getProductDTO().setPreviewImage(previewImage);
        motherboardService.create(motherboardDTO);

        return new ResponseEntity<>(new ApiResponse("Motherboard successfully created"), HttpStatus.OK);
    }
}
