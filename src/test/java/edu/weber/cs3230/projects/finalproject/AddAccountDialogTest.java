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
        // Prepare test data
        String balanceStr = "100";
        String accountType = "Checking";
        BigDecimal balance = new BigDecimal(balanceStr);

        // Set up mock behavior
        when(mockCustomer.getBankAccounts()).thenReturn(new ArrayList<>());

        // Set input values
        dialog.getInitBalanceTextField().setText(balanceStr);
        dialog.getAccountTypeComboBox().setSelectedItem(accountType);

        // Trigger action
        dialog.getAddAccountOKButton().doClick();

        // Verify customer's bank accounts have been updated
        List<BankAccount> updatedAccounts = mockCustomer.getBankAccounts();
        assertEquals(1, updatedAccounts.size()); // One account should be added
        BankAccount addedAccount = updatedAccounts.get(0);
        assertEquals(balance, addedAccount.getBalance()); // Check balance
        assertTrue(addedAccount instanceof CheckingAccount); // Check account type
    }

}