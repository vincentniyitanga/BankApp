package edu.weber.cs3230.projects.finalproject;

import java.math.BigDecimal;

public interface ITransfer {
    public void transfer(int from, int to, BigDecimal amount) throws NoSuchBankAccountException;
}
