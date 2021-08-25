package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.entity.Phone;
import one.digitalinnovation.personapi.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneService {

    private PhoneRepository phoneRepository;

    public Phone find(Long id){
        return phoneRepository.getOne(id);
    }

    public Phone save(Phone phone){
        Phone respPhone = phoneRepository.save(phone);
        return respPhone;
    }


}
