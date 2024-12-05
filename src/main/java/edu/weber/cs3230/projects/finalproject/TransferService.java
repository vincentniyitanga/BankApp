package edu.weber.cs3230.projects.finalproject;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransferService implements ITransfer {
    private IBankAccountRepository bankAccountRepository;

    public TransferService(IBankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void transfer(int from, int to, BigDecimal amount)
            throws NoSuchBankAccountException, InsufficientFundException {
        BankAccount fromBankAccount = bankAccountRepository.findByAccountNumber(from);
        BankAccount toBankAccount = bankAccountRepository.findByAccountNumber(to);

        // Remove try-catch and let the exception propagate
        fromBankAccount.withdraw(amount);
        toBankAccount.deposit(amount);
    }
}

