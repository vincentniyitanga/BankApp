package edu.weber.cs3230.projects.finalproject;

public class NoSuchBankAccountException extends Exception{

    @Override
    public String getMessage() {
        return "No such bank account found!";
    }
}
