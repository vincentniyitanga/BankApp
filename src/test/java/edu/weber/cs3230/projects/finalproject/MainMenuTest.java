package edu.weber.cs3230.projects.finalproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuTest {

    private MainMenu mainMenu;

    @BeforeEach
    void setUp() {
        mainMenu = new MainMenu();
    }

    @Test
    void testAddCustomerToTable() {
        // Create a new customer
        Customer customer = new Customer("John", "Doe", "123 Main St.", "1234567890");

        // Add the customer to the table
        mainMenu.addCustomerToTable(customer);

        // Get the customer table model
        javax.swing.table.DefaultTableModel tableModel = (javax.swing.table.DefaultTableModel) mainMenu.getCustomerTable().getModel();

        // Check if the customer is added correctly
        assertEquals(1, tableModel.getRowCount());
        assertEquals("John", tableModel.getValueAt(0, 0));
        assertEquals("Doe", tableModel.getValueAt(0, 1));
        assertEquals("1234567890", tableModel.getValueAt(0, 2));
        assertEquals("123 Main St.", tableModel.getValueAt(0, 3));
        assertEquals(0, tableModel.getValueAt(0, 4)); // No accounts added yet
    }

    @Test
    void testRemoveCustomerFromTable() {
        // Create customers and add them to the table
        Customer customer1 = new Customer("John", "Doe", "123 Main St.", "1234567890");
        Customer customer2 = new Customer("Jane", "Smith", "456 Elm St.", "0987654321");
        mainMenu.addCustomerToTable(customer1);
        mainMenu.addCustomerToTable(customer2);

        // Remove the second customer from the table
        mainMenu.removeCustomerFromTable(1);

        // Get the customer table model
        javax.swing.table.DefaultTableModel tableModel = (javax.swing.table.DefaultTableModel) mainMenu.getCustomerTable().getModel();

        // Check if the second customer is removed correctly
        assertEquals(1, tableModel.getRowCount());
        assertEquals("John", tableModel.getValueAt(0, 0));
        assertEquals("Doe", tableModel.getValueAt(0, 1));
        assertEquals("1234567890", tableModel.getValueAt(0, 2));
        assertEquals("123 Main St.", tableModel.getValueAt(0, 3));
        assertEquals(0, tableModel.getValueAt(0, 4)); // No accounts added yet
    }


}