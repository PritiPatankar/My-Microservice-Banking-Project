package com.mybankms.accounts.service;


import com.mybankms.accounts.DTO.CustomerDTO;

public interface IAccountsService {

    void createAccount(CustomerDTO customer);

    CustomerDTO fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDTO customerDTO);

    boolean deleteAccount(String mobileNumber);
}
