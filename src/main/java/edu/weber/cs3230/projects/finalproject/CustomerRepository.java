package edu.weber.cs3230.projects.finalproject;

import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private List<Customer> customers;
    private IBankAccountRepository bankAccountRepository;

    public CustomerRepository(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerRepository(List<Customer> customers, IBankAccountRepository bankAccountRepository) {
        this.customers = customers;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Customer findCustomerByAccountNumber(int accountNumber) throws NoSuchCustomerException {
        BankAccount account = null;
        try {
            account = bankAccountRepository.findByAccountNumber(accountNumber);
        } catch (NoSuchBankAccountException e) {
            System.out.println(e.getMessage());
        }

        for(Customer customer : customers)
        {
            if(customer.getBankAccounts().contains(account))
            {
                return customer;
            }
        }

        throw(new NoSuchCustomerException());

    }

    @Override
    public Customer findCustomerByPhoneNumber(String phoneNumber) throws NoSuchCustomerException {
        for(Customer customer : customers)
        {
            if(customer.getPhoneNumber().equals(phoneNumber))
            {
                return customer;
            }
        }
        throw(new NoSuchCustomerException());
    }
}
