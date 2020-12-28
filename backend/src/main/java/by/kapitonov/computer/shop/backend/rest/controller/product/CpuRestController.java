package by.kapitonov.computer.shop.backend.rest.controller.product;

import by.kapitonov.computer.shop.backend.model.product.Cpu;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.service.CpuService;
import by.kapitonov.computer.shop.backend.service.dto.CpuDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products/cpus")
public class CpuRestController {

    private final CpuService cpuService;

    public CpuRestController(CpuService cpuService) {
        this.cpuService = cpuService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCpu(Pageable pageable) {

        Page<Cpu> cpuPage = cpuService.getAll(pageable);

        return new ResponseEntity<>(cpuPage.getContent(), HttpStatus.OK);
    }

    @GetMapping("/{product-name}")
    public ResponseEntity getProduct(@PathVariable(name = "product-name") String productName) {

        Cpu cpu = cpuService.getByProductName(productName);

        return new ResponseEntity(cpu, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCPU(CpuDTO cpuDTO) {

        cpuService.create(cpuDTO);

        return new ResponseEntity<>(new ApiResponse("Cpu successfully created"), HttpStatus.OK);
    }
}
