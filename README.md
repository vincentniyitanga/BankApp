# CS3230-BankingAppGUI
In this project, we will develop the BankingApp into a graphical user interface based Banking application:

## Software Requirements
The best IDE to develop a desktop GUI applicaiton is Apache NetBeans, please visit <a href="https://netbeans.apache.org/">NetBeans Official Website</a> to download and install the software.

## Given Starting Code
In this project, you are given the following starting code:
* `Person`, an abstract class to model a person;
* `BankAccount`, a class to be used as a super class for `CheckingAccount`, `SavingsAccout`, and `InvestmentAccount`;
* `CheckingAccount`, a class to model a checking account;
* `SavingsAccount`, a class to model a savings account;
* `IBankAccountRepository`, an interface to define a method `findByAccountNumber`;
* `BankAccountRepository`, a class to implement the `IBankAccountRepository` interface; this class can be used as an example of how to search for a bank account from a list of bank account objects.
* `IBankingService`, an interface to define methods `openBankAccount` and `closeBankAccount`;
* `ICustomerRepository`, an interface to define methods `findCustomerByAccountNumber` and `findCustomerByPhoneNumber`;
* `ITransfer`, an interface to define a method transfer;
* `NoSuchBankAccountException`, a customized exception class to indicate a "bank account not found" situation;
* `NoSuchCustomerException`, a customized exception class to indicate a "no such customer found" situation;
* `BankAccountType`, an enum class to define a set of bank account types;

You are also give the following list of GUI programs:
* `MainMenu`, the main GUI frame to display the starting user interface of the application;
* `AddCustomerDialog`, the GUI dialog to add a customer and show the customer's details in the table;
* `AddAccountDialog`, the GUI dialog to add a bank account to a selected customer;
* `ShowAccountsFrame`, the GUI frame to show all the bank accounts for a selected customer;
* `DepositDialog`, the GUI dialog to depoist a certain amount of money to a selected bank account;
* `TransferDialog`, the GUI dialog to transfer a certain amount of money from a selected bank account to anther bank account;

## Your Tasks
In this project, you You need to implement the following items based on the given starting code:

### Finish implementing MainMenu Class
* Finish implementing the method `showAccountsButtonActionPerformed(java.awt.event.ActionEvent evt)` to display all bank accounts for a selected customer using ShowAccountsFrame, if a customer is not selected, or there is no customer in the application, display error message: "Select a customer or add a new customer to show accounts!"
* Finish implementing the method `addCustomerToTable(Customer customer)` to show the customer details in the table `customerTable`.

### Finish implementing AddAccountDialog Class
* Finish implementing the method `addAccountOKButtonActionPerformed(java.awt.event.ActionEvent evt)` to add a bank account to the customer. Students may use the method `addCustomerOKButtonActionPerformed(java.awt.event.ActionEvent evt)` defined in the `AddCustomerDialog` class as an example on how to implement this method.  

### Add WithdrawDialog Class
* Implement a `WithdrawDialog`, the GUI dialog to withdraw a certain amount of money from a selected bank account; Students may use the `DepositDialog` class as an example on how to implement this dialog.

### Finish implementing TransferDialog Class
* Finish implementing the method `transferOKButtonActionPerformed(java.awt.event.ActionEvent evt)` to transfer a certain amount from one bank account to another. 

### Add Functionality to AddCustomerDialog Class
* Implement the functionality that displays a warning message when a new customer is being created with a phone number that is already associated with an existing customer. 
