package com.example.bankmanagementsystem.Service;


import com.example.bankmanagementsystem.API.ApiException;
import com.example.bankmanagementsystem.DTO.CustomerDTO;
import com.example.bankmanagementsystem.Model.Customer;
import com.example.bankmanagementsystem.Model.User;
import com.example.bankmanagementsystem.Repository.AuthRepository;
import com.example.bankmanagementsystem.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AuthRepository authRepository;


    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public void register(CustomerDTO customerDTO){
        User user=new User(null,customerDTO.getUsername(),customerDTO.getPassword(),customerDTO.getName(),customerDTO.getEmail(),customerDTO.getRole(),null,null);
        user.setRole("CUSTOMER");
        String hash=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        authRepository.save(user);

        Customer customer=new Customer(user.getId(), customerDTO.getPhoneNumber(),user,null);
        customerRepository.save(customer);

    }


    public void updateCustomer(Integer id, CustomerDTO customerDTO,  Integer auth ){
        User user =authRepository.findUserById(auth);
        Customer oldCustomer = customerRepository.findCustomerById(id);
        if(user==null){
            throw new ApiException("user not found");
        }
        if(user.getCustomer().getId()!=oldCustomer.getId()){

            throw new ApiException("Customer not found");
        }

        oldCustomer.setEmail(customerDTO.getEmail());
        oldCustomer.setPhoneNumber(customerDTO.getPhoneNumber());
        oldCustomer.setName(customerDTO.getName());
        oldCustomer.setUsername(customerDTO.getUsername());
        oldCustomer.setPassword(customerDTO.getPassword());

        customerRepository.save(oldCustomer);


    }

    public void deleteCustomer(Integer id, Integer auth){
        User user= authRepository.findUserById(auth);
        Customer customer=customerRepository.findCustomerById(id);

        if(user==null){
            throw new ApiException("user not found");
        }

        if(user.getCustomer().getId()!=customer.getId()){
            throw new ApiException("Customer not found");
        }
        customerRepository.delete(customer);

    }

//    public Customer getCustomerById(Integer id, Integer auth){
//        Customer customer =customerRepository.findCustomerById(id);
//        if(customer==null){
//            throw new ApiException("customer id not found");
//        }
//        if(customer.getUser().getId()!= auth){
//            throw new ApiException("Sorry , You do not have the authority to get this customer!");
//        }
//        return customer;
//
//    }
//
//    public void addCustomer(CustomerDTO customerDTO){
//
//        User user = authRepository.findUserById(customerDTO.getUser_id());
//        if(user==null){
//        throw new ApiException("user id not found");
//        }
//
//        user.setRole("Customer");
//
//        Customer customer= new Customer(null,customerDTO.getPhoneNumber(),user,null);
//        customerRepository.save(customer);
//    }
//
//
//    public void updateCustomer(Integer id,CustomerDTO customerDTO,Integer auth){
//
//    }
//    public void deleteCustomer(Integer id, Integer auth){
//        Customer customer = customerRepository.findCustomerById(id);
//        if(customer==null){
//            throw new ApiException("customer not found");
//        }else if(customer.getUser().getId() != auth){
//            throw new ApiException("Sorry , You do not have the authority to get this customer!");
//        }
//        customerRepository.delete(customer);
//    }

}
