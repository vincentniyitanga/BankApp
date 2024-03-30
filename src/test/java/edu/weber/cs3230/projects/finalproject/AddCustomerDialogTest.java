package edu.weber.cs3230.projects.finalproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddCustomerDialogTest {

    private AddCustomerDialog dialog;
    private List<Customer> customers;

    @BeforeEach
    public void setUp() {
        customers = new ArrayList<>();
        dialog = new AddCustomerDialog(new JFrame(), true, customers);
    }

    @Test
    public void testAddCustomerOKButtonActionPerformed() {
        // Mock user input
        dialog.getFirstNameTextField().setText("John");
        dialog.getLastNameTextField().setText("Doe");
        dialog.getPhoneNumberTextField().setText("8015551234");
        dialog.getInitBalanceTextField().setText("1000");

        // Select "Checking" account type
        dialog.getAccountTypeComboBox().setSelectedItem("Checking");

        // Simulate button click
        dialog.getAddCustomerOKButton().doClick();

        // Verify if a new customer is added
        assertEquals(1, customers.size());

        // Verify the details of the newly added customer
        Customer customer = customers.get(0);
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("8015551234", customer.getPhoneNumber());
        assertEquals(1, customer.getBankAccounts().size());
        assertTrue(customer.getBankAccounts().get(0) instanceof CheckingAccount);
        assertEquals(new BigDecimal("1000"), customer.getBankAccounts().get(0).getBalance());
    }

    @Test
    public void testAddCustomerCancelButtonActionPerformed() {
        // Simulate button click
        dialog.getAddCustomerCancelButton().doClick();

        // Verify if the dialog is disposed
        assertFalse(dialog.isVisible());
    }

}
