package edu.weber.cs3230.projects.finalproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {

    private Customer customer;
    private List<Customer> customers;
    private BankAccount account;

    @BeforeEach
    public void setUp()
    {
        customer = new Customer("Jane", "Doe", "", "8015551234");
        customers = new ArrayList<>();
        account = new BankAccount();
    }

    @AfterEach
    public void resetAccountNumber()
    {
        BankAccount.setNextAccountNumber(1);
    }

    @Test
    public void testMainMenu()
    {
        MainMenu menu = new MainMenu();
        assertNotNull(menu);
    }

    @Test
    public void testAddAccountDialog()
    {
        AddAccountDialog dialog = new AddAccountDialog(null, true, customer);
        assertNotNull(dialog);
    }

    @Test
    public void testAddCustomerDialog()
    {
        AddCustomerDialog dialog = new AddCustomerDialog(null, true, customers);
        assertNotNull(dialog);
    }

    @Test
    public void testShowAccountsFrame()
    {
        ShowAccountsFrame frame = new ShowAccountsFrame(customer, customers);
        assertNotNull(frame);
    }

    @Test
    public void testDepositDialog()
    {
        DepositDialog dialog = new DepositDialog(null, true, account);
        assertNotNull(dialog);
    }

    @Test
    public void testWithdrawDialog()
    {
        WithdrawDialog dialog = new WithdrawDialog(null, true, account);
        assertNotNull(dialog);
    }

    @Test
    public void testTransferDialog()
    {
        TransferDialog dialog = new TransferDialog(null, true, account, customers);
        assertNotNull(dialog);
    }


}