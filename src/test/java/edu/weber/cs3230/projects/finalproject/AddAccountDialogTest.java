package edu.weber.cs3230.projects.finalproject;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class AddAccountDialogTest {

    private AddAccountDialog dialog;
    private Customer mockCustomer;

    @BeforeEach
    public void setUp() {
        mockCustomer = mock(Customer.class);
        dialog = new AddAccountDialog(new JFrame(), true, mockCustomer);
    }

    @Test
    public void testCancelButtonActionPerformed() {
        dialog.getAddAccountCancelButton().doClick();
        assertFalse(dialog.isShowing()); // Check if dialog is still visible after clicking cancel button
    }

    @Test
    public void testOKButtonActionPerformed() {
        // Create a list to store accounts
        ArrayList<BankAccount> accounts = new ArrayList<>();

        // Set up mock behavior
        doAnswer(invocation -> {
            BankAccount account = invocation.getArgument(0);
            accounts.add(account);
            return null;
        }).when(mockCustomer).addBankAccount(any(BankAccount.class));

        when(mockCustomer.getBankAccounts()).thenReturn(accounts);

        // Set input values
        dialog.getInitBalanceTextField().setText("100");
        dialog.getAccountTypeComboBox().setSelectedItem("Checking");

        // Trigger action
        dialog.getAddAccountOKButton().doClick();

        // Verify account was added correctly
        assertEquals(1, accounts.size());
        BankAccount addedAccount = accounts.get(0);
        assertEquals(new BigDecimal("100"), addedAccount.getBalance());
        assertTrue(addedAccount instanceof CheckingAccount);
    }


}