package by.kapitonov.computer.shop.backend.rest.controller.product;

import by.kapitonov.computer.shop.backend.model.product.PowerSupply;
import by.kapitonov.computer.shop.backend.rest.mapper.PowerSupplyMapper;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.PowerSupplyVM;
import by.kapitonov.computer.shop.backend.service.PowerSupplyService;
import by.kapitonov.computer.shop.backend.service.dto.PowerSupplyDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/power-supply")
public class PowerSupplyRestController {

    private final PowerSupplyService powerSupplyService;

    public PowerSupplyRestController(PowerSupplyService powerSupplyService) {
        this.powerSupplyService = powerSupplyService;
    }

    @GetMapping
    public ResponseEntity<List<PowerSupplyVM>> getAll(Pageable pageable) {

        List<PowerSupply> powerSupplies = powerSupplyService.getAll(pageable).getContent();
        List<PowerSupplyVM> powerSupplyVMList = PowerSupplyMapper.toVMList(powerSupplies);

        return new ResponseEntity<>(powerSupplyVMList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<PowerSupplyVM> getPowerSupply(@PathVariable(name = "name") String productName) {

        PowerSupply powerSupply = powerSupplyService.getByProductName(productName);
        PowerSupplyVM powerSupplyVM = PowerSupplyMapper.toVM(powerSupply);

        return new ResponseEntity<>(powerSupplyVM, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(PowerSupplyDTO powerSupplyDTO) {

        powerSupplyService.create(powerSupplyDTO);

        return new ResponseEntity<>(new ApiResponse("Power supply successfully created"), HttpStatus.OK);
    }
}
