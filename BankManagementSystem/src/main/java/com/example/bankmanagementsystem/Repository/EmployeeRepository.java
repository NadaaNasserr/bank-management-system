package com.example.bankmanagementsystem.Repository;

import com.example.bankmanagementsystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

Employee findEmployeeById(Integer id);
}
