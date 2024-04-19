package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.controller;

import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.dto.CustomerDTO;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Kavithma Thushal
 * @project : Demo
 * @since : 10:58 AM - 4/19/2024
 **/
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        System.out.println("Request Received...!");
        return customerService.geAllCustomers();
    }
}
