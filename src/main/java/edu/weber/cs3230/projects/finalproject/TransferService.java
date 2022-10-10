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
    public void transfer(int from, int to, BigDecimal amount) throws NoSuchBankAccountException {

        BankAccount fromBankAccount, toBankAccount;
        fromBankAccount = bankAccountRepository.findByAccountNumber(from);
        toBankAccount = bankAccountRepository.findByAccountNumber(to);
        try {
            fromBankAccount.withdraw(amount);
        } catch (InsufficientFundException ex) {
            Logger.getLogger(TransferService.class.getName()).log(Level.SEVERE, null, ex);
        }
        toBankAccount.deposit(amount);
    }
}
