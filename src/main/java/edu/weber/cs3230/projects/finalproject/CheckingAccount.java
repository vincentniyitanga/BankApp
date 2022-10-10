package edu.weber.cs3230.projects.finalproject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CheckingAccount extends BankAccount {

    private ArrayList deposits;
    private ArrayList withdraws;
    private BigDecimal withdrawLimit;

    public CheckingAccount()
    {
        super();
        deposits = new ArrayList();
        withdraws = new ArrayList();
        this.withdrawLimit = BigDecimal.valueOf(Integer.MAX_VALUE);
    }

    public CheckingAccount(BigDecimal withdrawLimit)
    {
        this();
        this.withdrawLimit = withdrawLimit;

    }

    //  set a limit for this account,
    //  if you try to set a negative limit, it will throw an exception.
    //  message should be "Limit is less than zero!"
    public void setLimit(BigDecimal withdrawLimit) throws InvalidLimitException {
        if(withdrawLimit.compareTo(BigDecimal.ZERO) < 0)
        {
            throw new InvalidLimitException("Invalid limit!");
        }

        this.withdrawLimit = withdrawLimit;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if(balance.compareTo(amount) >= 0 && amount.compareTo(withdrawLimit) <= 0)
        {
            balance = balance.subtract(amount);
            return true;
        }
        else {
            System.out.println("Warning: no enough balance or amount over the limit, withdraw failed!");
            return false;
        }
    }

    @Override
    public String getStatement() {
        return super.getStatement() + ", type = Checking Account";
    }
}
