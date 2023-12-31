package com.example.bankmanagementsystem.Controller;


import com.example.bankmanagementsystem.DTO.CustomerDTO;
import com.example.bankmanagementsystem.DTO.EmployeeDTO;
import com.example.bankmanagementsystem.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {


    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomers() {
        return ResponseEntity.status(200).body(customerService.getAllCustomers());
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid CustomerDTO customerDTO) {
        customerService.register(customerDTO);
        return ResponseEntity.status(200).body("Customer Register");
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody @Valid CustomerDTO customerDTO, @AuthenticationPrincipal Integer auth){
        customerService.updateCustomer(id,customerDTO,auth);
        return ResponseEntity.status(200).body("Customer updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id, @AuthenticationPrincipal Integer auth){
        customerService.deleteCustomer(id,auth);
        return ResponseEntity.status(200).body("Customer deleted");

    }
}

