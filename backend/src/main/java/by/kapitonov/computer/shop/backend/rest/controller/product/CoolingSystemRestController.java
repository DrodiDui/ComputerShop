package by.kapitonov.computer.shop.backend.rest.controller.product;

import by.kapitonov.computer.shop.backend.model.product.CoolingSystem;
import by.kapitonov.computer.shop.backend.rest.mapper.CoolingSystemMapper;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.CoolingSystemVM;
import by.kapitonov.computer.shop.backend.service.CoolingSystemService;
import by.kapitonov.computer.shop.backend.service.dto.CoolingSystemDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cooling-system")
public class CoolingSystemRestController {

    private final CoolingSystemService coolingSystemService;

    public CoolingSystemRestController(CoolingSystemService coolingSystemService) {
        this.coolingSystemService = coolingSystemService;
    }

    @GetMapping
    public ResponseEntity<List<CoolingSystemVM>> getAllCoolingSystem(Pageable pageable) {

        List<CoolingSystem> coolingSystems = coolingSystemService.getAll(pageable).getContent();
        List<CoolingSystemVM> coolingSystemVMList = CoolingSystemMapper.toVMList(coolingSystems);

        return new ResponseEntity<>(coolingSystemVMList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CoolingSystemVM> getCoolingSystemByName(@PathVariable(name = "name") String productName) {

        CoolingSystem coolingSystem = coolingSystemService.getByProductName(productName);
        CoolingSystemVM coolingSystemVM = CoolingSystemMapper.toVM(coolingSystem);

        return new ResponseEntity<>(coolingSystemVM, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody CoolingSystemDTO coolingSystemDTO) {

        coolingSystemService.create(coolingSystemDTO);

        return new ResponseEntity<>(new ApiResponse("Cooling system successfully created"), HttpStatus.OK);
    }
}
