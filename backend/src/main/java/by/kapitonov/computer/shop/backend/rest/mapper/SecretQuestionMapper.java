package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.SecretQuestion;
import by.kapitonov.computer.shop.backend.rest.vm.SecretQuestionVM;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SecretQuestionMapper {
    SecretQuestionMapper INSTANCE = Mappers.getMapper(SecretQuestionMapper.class);

    List<SecretQuestionVM> entityListToVMList(List<SecretQuestion> secretQuestions);
}
