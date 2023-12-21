package ru.netology.DGrigoryev.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.netology.DGrigoryev.controller.dto.CustomerDTO;
import ru.netology.DGrigoryev.domain.Customer;
import ru.netology.DGrigoryev.service.CustomerService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);

        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Object> saveCustomer(@RequestBody String nm) {
        Customer createdCustomer = customerService.saveCustomer(nm);
        CustomerDTO createdCustomerDTO = new CustomerDTO(createdCustomer.getId(), createdCustomer.getName());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCustomer.getId())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(createdCustomerDTO);
    }

    @GetMapping()
    public ResponseEntity<Object> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(customer -> new CustomerDTO(customer.getId(), customer.getName()))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(customerDTOS);
    }
}
