package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.dto.PhoneDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

    //@Mapping(source = "type", target = "dataType") // map caso atributo com nome diferente
    Phone phoneDTOToPhone(PhoneDTO phoneDTO); //para o relacionamento List

    @InheritInverseConfiguration
    PhoneDTO phoneToPhoneDTO(Phone phone); //para o relacionamento List

}
