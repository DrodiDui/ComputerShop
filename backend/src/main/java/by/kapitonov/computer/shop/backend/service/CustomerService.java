package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.Customer;
import by.kapitonov.computer.shop.backend.service.dto.CustomerDTO;

public interface CustomerService {

    Customer updateCustomer(CustomerDTO customerDTO);

}
