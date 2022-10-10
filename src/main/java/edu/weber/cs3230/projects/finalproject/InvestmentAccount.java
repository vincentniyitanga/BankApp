package edu.weber.cs3230.projects.finalproject;

import java.math.BigDecimal;

public class InvestmentAccount extends BankAccount {

    private BigDecimal serviceFee;

    public InvestmentAccount()
    {
        super();
        serviceFee = BigDecimal.ZERO;
    }
    public InvestmentAccount(BigDecimal serviceFee) {
        this();
        this.serviceFee = serviceFee;
    }

    public void chargeServiceFee()
    {
        this.balance = this.balance.subtract(serviceFee);
    }

}
