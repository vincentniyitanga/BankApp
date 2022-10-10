package edu.weber.cs3230.projects.finalproject;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

    private BigDecimal interestRate;

    public SavingsAccount()
    {
        super();
        this.interestRate = BigDecimal.ZERO;
    }
    public SavingsAccount(BigDecimal interestRate)
    {
        this();
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal calculateMonthlyInterest()
    {
        return balance.multiply(interestRate).divide(new BigDecimal(100.0));
    }

    public void updateBalanceWithInterest()
    {
        balance = balance.add(calculateMonthlyInterest());
    }

    @Override
    public String getStatement() {
        return super.getStatement() + ", type: Savings Account";
    }
}
