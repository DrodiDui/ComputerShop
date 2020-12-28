package by.kapitonov.computer.shop.backend.rest.controller.product;

import by.kapitonov.computer.shop.backend.model.product.HardDisk;
import by.kapitonov.computer.shop.backend.rest.mapper.HardDiskMapper;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.HardDiskVM;
import by.kapitonov.computer.shop.backend.service.HardDiskService;
import by.kapitonov.computer.shop.backend.service.dto.HardDiskDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hard-disk")
public class HardDiskRestController {

    private final HardDiskService hardDiskService;

    public HardDiskRestController(HardDiskService hardDiskService) {
        this.hardDiskService = hardDiskService;
    }

    @GetMapping
    public ResponseEntity<List<HardDiskVM>> getAll(Pageable pageable) {

        List<HardDisk> hardDisks = hardDiskService.getAll(pageable).getContent();
        List<HardDiskVM> hardDiskVMList = HardDiskMapper.toVMList(hardDisks);

        return new ResponseEntity<>(hardDiskVMList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<HardDiskVM> getHardDiskByName(@PathVariable(name = "name") String productName) {

        HardDisk hardDisk = hardDiskService.getByProductName(productName);
        HardDiskVM hardDiskVM = HardDiskMapper.toVM(hardDisk);

        return new ResponseEntity<>(hardDiskVM, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody HardDiskDTO hardDiskDTO) {

        hardDiskService.create(hardDiskDTO);

        return new ResponseEntity<>(new ApiResponse("Hard disk successfully created"), HttpStatus.OK);
    }
}
