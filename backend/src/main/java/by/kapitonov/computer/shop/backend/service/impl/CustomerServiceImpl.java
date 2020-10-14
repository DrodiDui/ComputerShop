package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.CustomerNotFoundException;
import by.kapitonov.computer.shop.backend.exception.GenderNotFoundException;
import by.kapitonov.computer.shop.backend.model.Customer;
import by.kapitonov.computer.shop.backend.model.Gender;
import by.kapitonov.computer.shop.backend.repository.CustomerRepository;
import by.kapitonov.computer.shop.backend.repository.GenderRepository;
import by.kapitonov.computer.shop.backend.service.CustomerService;
import by.kapitonov.computer.shop.backend.service.dto.CustomerDTO;
import by.kapitonov.computer.shop.backend.util.SecurityUtil;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final GenderRepository genderRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               GenderRepository genderRepository) {
        this.customerRepository = customerRepository;
        this.genderRepository = genderRepository;
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDTO) {
        return customerRepository.findById(SecurityUtil.getUserId())
                .map(customer -> {
                    customer.setFirstName(customerDTO.getFirstName());
                    customer.setLastName(customerDTO.getLastName());
                    customer.setGender(getGender(customerDTO.getGender()));
                    customer.setCellPhone(customerDTO.getCellPhone());
                    customer.getAddress().setCountry(customerDTO.getCountry());
                    customer.getAddress().setCity(customerDTO.getCity());
                    customer.getAddress().setStreet(customerDTO.getStreet());
                    customer.getAddress().setHouseNumber(customerDTO.getHouseNumber());
                    return customerRepository.save(customer);
                })
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer hasn't been found")
                );
    }

    private Gender getGender(String gender) {
        return genderRepository.findByGenderName(gender)
                .orElseThrow(
                        () -> new GenderNotFoundException("Gender hasn't been found")
                );
    }
}
