package edu.weber.cs3230.projects.finalproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class WithdrawDialogTest {

    private WithdrawDialog dialog;
    private BankAccount mockAccount;
    private JOptionPane mockOptionPane;

    @BeforeEach
    void setUp() {
        mockAccount = mock(BankAccount.class);
        dialog = new WithdrawDialog(new JFrame(), true, mockAccount);
        dialog.getWithdrawAmountTextField().setText("100"); // Set a default withdrawal amount

        // Create mock JOptionPane
        mockOptionPane = mock(JOptionPane.class);
    }

    @Test
    void testCancelButtonActionPerformed() {
        JButton cancelButton = dialog.getWithdrawCancelButton();
        cancelButton.doClick(); // Simulate click event
        assertFalse(dialog.isVisible()); // Dialog should be closed after clicking cancel
    }

    @Test
    void testOKButtonActionPerformedWithValidAmount() throws InsufficientFundException {
        BigDecimal amount = new BigDecimal(dialog.getWithdrawAmountTextField().getText());
        dialog.getWithdrawOKButton().doClick(); // Simulate click event

        // Verify that account's withdraw method is called with the correct amount
        verify(mockAccount).withdraw(amount);
        // Verify that the dialog is closed after clicking OK
        assertFalse(dialog.isVisible());
    }


}