/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package edu.weber.cs3230.projects.finalproject;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author zycmm
 */
public class DepositDialog extends javax.swing.JDialog {

    /**
     * Creates new form DepositDialog
     */
    public DepositDialog(java.awt.Frame parent, boolean modal, BankAccount account) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.account = account;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        depositAmountLabel = new javax.swing.JLabel();
        depositAmountTextField = new javax.swing.JTextField();
        depositOKButton = new javax.swing.JButton();
        depositCancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        depositAmountLabel.setText("Deposit Amount:");
        getContentPane().add(depositAmountLabel);
        getContentPane().add(depositAmountTextField);

        depositOKButton.setText("OK");
        depositOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositOKButtonActionPerformed(evt);
            }
        });
        getContentPane().add(depositOKButton);

        depositCancelButton.setText("Cancel");
        depositCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositCancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(depositCancelButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void depositCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositCancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_depositCancelButtonActionPerformed

    private void depositOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositOKButtonActionPerformed
        StringBuilder warnings = new StringBuilder();
        // verifty depoist amount is  not empty and is a positive number
        if(depositAmountTextField.getText().isEmpty())
        {
            warnings.append("Deposit amount is empty.\n");
        }
        else
        {
            BigDecimal amount = new BigDecimal(depositAmountTextField.getText());
            if(amount.compareTo(BigDecimal.ZERO) > 0)
            {
                account.deposit(amount);
            }
        }
        
        if(warnings.length() > 0)
        {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Deposit Warnings", JOptionPane.WARNING_MESSAGE);
        }
        this.dispose(); 
    }//GEN-LAST:event_depositOKButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel depositAmountLabel;
    private javax.swing.JTextField depositAmountTextField;
    private javax.swing.JButton depositCancelButton;
    private javax.swing.JButton depositOKButton;
    // End of variables declaration//GEN-END:variables
    
    private BankAccount account;

}