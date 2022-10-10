package edu.weber.cs3230.projects.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

    private String address;
    private String phoneNumber;
    private List<BankAccount> bankAccounts;

    public Customer(String firstName, String lastName, String phoneNumber, List<BankAccount> bankAccounts) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
        this.bankAccounts = bankAccounts;
    }

    public Customer(String firstName, String lastName, String address, String phoneNumber) {
        super(firstName, lastName);
        this.address = address;
        this.phoneNumber = phoneNumber;
        bankAccounts = new ArrayList<>();
    }

    public void addBankAccount(BankAccount account)
    {
        bankAccounts.add(account);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }



    @Override
    public String getDescription() {
        return "a Bank customer.";
    }
}
