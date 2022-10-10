package edu.weber.cs3230.projects.finalproject;

public interface IBankingService {

    BankAccount openBankAccount(BankAccountType accountType, Customer customer);
    void closeBankAccount(int accountNumber);
}
