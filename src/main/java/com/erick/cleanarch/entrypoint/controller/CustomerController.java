package com.erick.cleanarch.entrypoint.controller;

import com.erick.cleanarch.core.domain.Customer;
import com.erick.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.erick.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.erick.cleanarch.core.usecase.InsertCustomerUseCase;
import com.erick.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.erick.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.erick.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.erick.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        Customer customer = findCustomerByIdUseCase.findById(id);
        return ResponseEntity.ok(customerMapper.toCustomerResponse(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CustomerRequest customerRequest,
                                       @PathVariable String id) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerUseCase.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

}
