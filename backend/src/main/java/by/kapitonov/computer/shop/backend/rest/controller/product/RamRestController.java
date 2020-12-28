package by.kapitonov.computer.shop.backend.rest.controller.product;

import by.kapitonov.computer.shop.backend.model.product.Ram;
import by.kapitonov.computer.shop.backend.rest.mapper.RamMapper;
import by.kapitonov.computer.shop.backend.rest.vm.RamVM;
import by.kapitonov.computer.shop.backend.service.RamService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rams")
public class RamRestController {

    public final RamService ramService;

    public RamRestController(RamService ramService) {
        this.ramService = ramService;
    }

    @GetMapping
    public ResponseEntity<List<RamVM>> getAllRams(Pageable pageable) {

        List<Ram> rams = ramService.getAll(pageable).getContent();
        List<RamVM> ramVMList = RamMapper.toVMList(rams);

        return new ResponseEntity<>(ramVMList, HttpStatus.OK);
    }
}
