package com.mybankms.accounts.mapper;

import com.mybankms.accounts.DTO.CustomerDTO;
import com.mybankms.accounts.entity.Customer;


public class CustomerMapper {

    public static CustomerDTO MapToCustomerDTO(Customer customer, CustomerDTO customerDTO){
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setName(customer.getName());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }

    public static Customer MapToCustomer(CustomerDTO customerDTO, Customer customer){
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        return customer;
    }
}
