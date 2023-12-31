package com.example.bankmanagementsystem.Controller;

import com.example.bankmanagementsystem.DTO.CustomerDTO;
import com.example.bankmanagementsystem.DTO.EmployeeDTO;
import com.example.bankmanagementsystem.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;



    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid EmployeeDTO employeeDTO) {
        employeeService.register(employeeDTO);
        return ResponseEntity.status(200).body("employee Register");
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateEmployee(@PathVariable Integer id, @RequestBody @Valid EmployeeDTO employeeDTO, @AuthenticationPrincipal Integer auth){
        employeeService.updateEmployee(id,employeeDTO,auth);
        return ResponseEntity.status(200).body("employee updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Integer id, @AuthenticationPrincipal Integer auth){
        employeeService.deleteEmployee(id,auth);
        return ResponseEntity.status(200).body("employee deleted");

    }
}
