package edu.weber.cs3230.projects.finalproject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CheckingAccount extends BankAccount {
    private ArrayList deposits;
    private ArrayList withdraws;
    private BigDecimal withdrawLimit;

    public CheckingAccount() {
        super();  // This sets balance to ZERO
        deposits = new ArrayList();
        withdraws = new ArrayList();
        this.withdrawLimit = BigDecimal.valueOf(Integer.MAX_VALUE);
    }

    // Fixed this constructor to properly set both balance and withdraw limit
    public CheckingAccount(BigDecimal initBalance) {
        super(initBalance);  // This properly sets the initial balance
        deposits = new ArrayList();
        withdraws = new ArrayList();
        this.withdrawLimit = BigDecimal.valueOf(Integer.MAX_VALUE);
    }

    // Constructor with both balance and limit
    public CheckingAccount(BigDecimal initBalance, BigDecimal withdrawLimit) {
        super(initBalance);
        deposits = new ArrayList();
        withdraws = new ArrayList();
        this.withdrawLimit = withdrawLimit;
    }

    // Rest of the class remains the same
    public void setLimit(BigDecimal withdrawLimit) throws InvalidLimitException {
        if(withdrawLimit.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidLimitException("Invalid limit!");
        }
        this.withdrawLimit = withdrawLimit;
    }

    @Override
    public boolean withdraw(BigDecimal amount) throws InsufficientFundException {
        if(amount.compareTo(withdrawLimit) > 0) {
            return false;  // Just return false if amount exceeds limit
        }
        if(balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            return true;
        } else {
            throw new InsufficientFundException();  // Throw without string parameter
        }
    }


    @Override
    public String getStatement() {
        return super.getStatement() + ", type = Checking Account";
    }
}
