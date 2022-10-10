package edu.weber.cs3230.projects.finalproject;

public class NoSuchCustomerException extends Exception {

    @Override
    public String getMessage() {
        return "No such customer found!";
    }
}
