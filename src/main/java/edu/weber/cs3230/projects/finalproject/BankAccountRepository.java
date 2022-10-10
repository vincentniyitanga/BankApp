package edu.weber.cs3230.projects.finalproject;

import java.util.List;

public class BankAccountRepository implements IBankAccountRepository {

    private List<BankAccount> bankAccounts;

    public BankAccountRepository(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public BankAccount findByAccountNumber(int accountNumber) throws NoSuchBankAccountException {

        for(BankAccount account : bankAccounts)
        {
            if(account.getAccountNumber() == accountNumber)
            {
                return account;
            }
        }

        throw(new NoSuchBankAccountException());
        //return null;
    }




}
