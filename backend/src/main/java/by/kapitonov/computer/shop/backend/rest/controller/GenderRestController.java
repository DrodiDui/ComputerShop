package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.model.Gender;
import by.kapitonov.computer.shop.backend.rest.mapper.GenderMapper;
import by.kapitonov.computer.shop.backend.rest.vm.GenderVM;
import by.kapitonov.computer.shop.backend.service.GenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genders")
public class GenderRestController {

    private final GenderService genderService;

    public GenderRestController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping()
    public ResponseEntity<List<GenderVM>> getAllGenders() {

        List<Gender> genders = genderService.getAll();
        List<GenderVM> genderVMList = GenderMapper.INSTANCE.entityListToVMList(genders);

        return new ResponseEntity<>(genderVMList, HttpStatus.OK);
    }

}
