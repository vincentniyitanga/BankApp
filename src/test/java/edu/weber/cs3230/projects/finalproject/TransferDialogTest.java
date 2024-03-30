package edu.weber.cs3230.projects.finalproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TransferDialogTest {

    private TransferDialog dialog;
    private BankAccount mockAccount;
    private List<Customer> customers;
    private BankAccountRepository bankAccountRepository;
    private BankAccount account1;
    private BankAccount account2;


    @BeforeEach
    public void setUp() {
        // Create customers
        customers = new ArrayList<>();
        Customer customer1 = new Customer("John", "Doe", "", "123");
        Customer customer2 = new Customer("Jane", "Smith", "", "456");

        // Add bank accounts to customers
        account1 = new CheckingAccount(new BigDecimal("2000"));
        account2 = new CheckingAccount(new BigDecimal("2000"));
        System.out.println("account1 has acc#: " + account1.getAccountNumber());
        System.out.println("account2 has acc#: " + account2.getAccountNumber());

        account1.setBalance(new BigDecimal("1000"));
        account2.setBalance(new BigDecimal("1000"));
        customer1.addBankAccount(account1);
        customer2.addBankAccount(account2);

        // Add customers to the list
        customers.add(customer1);
        customers.add(customer2);

        mockAccount = Mockito.mock(BankAccount.class);
        dialog = new TransferDialog(new JFrame(), true, mockAccount, customers);

        setUpBankAccountRepository();
        dialog.setBankAccountRepository(bankAccountRepository);
        dialog.setAccount(account1);
    }

    private void setUpBankAccountRepository()
    {
        List<BankAccount> accounts = new ArrayList<>();
        for(Customer customer : customers)
        {
            accounts.addAll(customer.getBankAccounts());
        }

        this.bankAccountRepository = new BankAccountRepository(accounts);

    }

    @Test
    public void testTransferCancelButtonActionPerformed() {
        // Simulate button click
        dialog.getTransferCancelButton().doClick();
        // Verify if the dialog is disposed
        assertFalse(dialog.isVisible());
    }

    @Test
    public void testTransferOKButtonActionPerformed() throws NoSuchBankAccountException {
        // Mock user input
        dialog.getFromAccountTextField().setText("3");
        dialog.getToAccountTextField().setText("4");
        dialog.getTransferAmountTextField().setText("500");

        // Simulate button click
        dialog.getTransferOKButton().doClick();

        // assert
        assertEquals(new BigDecimal("500"), account1.getBalance());
        assertEquals(new BigDecimal("1500"), account2.getBalance());

    }

}