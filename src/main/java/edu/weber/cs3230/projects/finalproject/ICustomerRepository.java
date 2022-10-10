package edu.weber.cs3230.projects.finalproject;

public interface ICustomerRepository {

    Customer findCustomerByAccountNumber(int accountNumber) throws NoSuchCustomerException;
    Customer findCustomerByPhoneNumber(String phoneNumber) throws NoSuchCustomerException;

}
