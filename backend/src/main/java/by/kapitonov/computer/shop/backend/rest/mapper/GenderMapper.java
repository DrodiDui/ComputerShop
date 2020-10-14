package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.Gender;
import by.kapitonov.computer.shop.backend.rest.vm.GenderVM;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenderMapper {


    GenderMapper INSTANCE = Mappers.getMapper(GenderMapper.class);

    List<GenderVM> entityListToVMList(List<Gender> genders);
}
