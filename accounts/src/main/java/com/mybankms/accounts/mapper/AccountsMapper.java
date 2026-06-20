package com.mybankms.accounts.mapper;

import com.mybankms.accounts.DTO.AccountsDTO;
import com.mybankms.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDTO MapToAccountsDTO(Accounts accounts, AccountsDTO accountDTO){
        accountDTO.setAccountNumber(accounts.getAccountNumber());
        accountDTO.setAccountType(accounts.getAccountType());
        accountDTO.setBranchAddress(accounts.getBranchAddress());
        return accountDTO;
    }

    public static Accounts MapToAccounts(AccountsDTO accountDTO, Accounts accounts){
        accounts.setAccountNumber(accountDTO.getAccountNumber());
        accounts.setAccountType(accountDTO.getAccountType());
        accounts.setBranchAddress(accountDTO.getBranchAddress());
        return accounts;
    }
}
