package edu.weber.cs3230.projects.finalproject;

public interface IBankAccountRepository {

    public BankAccount findByAccountNumber(int accountNumber) throws NoSuchBankAccountException;


}
