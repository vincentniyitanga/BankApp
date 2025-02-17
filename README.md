# CS3230-BankingAppGUI
In this project, we will develop the BankingApp into a graphical user interface based Banking application:

## Given Starter Code
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
In this project, you You need to implement the following items based on the given starter code:

### Finish implementing MainMenu Class
* Finish implementing the method `showAccountsButtonActionPerformed(java.awt.event.ActionEvent evt)` to display all bank accounts for a selected customer using ShowAccountsFrame, if a customer is not selected, or there is no customer in the application, display error message: "Select a customer or add a new customer to show accounts!"
* Finish implementing the method `addCustomerToTable(Customer customer)` to show the customer details in the table `customerTable`.

### Finish implementing AddAccountDialog Class
* Finish implementing the method `addAccountOKButtonActionPerformed(java.awt.event.ActionEvent evt)` to add a bank account to the customer. Students may use the method `addCustomerOKButtonActionPerformed(java.awt.event.ActionEvent evt)` defined in the `AddCustomerDialog` class as an example on how to implement this method.  

### Finish implementing WithdrawDialog Class
* Finish implementing the method `withdrawOKButtonActionPerformed` to withdraw a certain amount of money from a selected bank account. It checks if the withdrawal amount is empty. If it is, a warning message is appended to the warnings StringBuilder indicating that the withdrawal amount is empty. If the withdrawal amount is not empty, it's converted to a BigDecimal object for further processing. It checks if the withdrawal amount is greater than zero. If it is, it attempts to withdraw the specified amount from the account. If the withdrawal operation fails due to insufficient funds, the error message from the InsufficientFundException is appended to the warnings StringBuilder.
* After verifying the withdrawal amount and processing it, if there are any warnings (i.e., if the warnings StringBuilder is not empty), a message dialog is displayed to alert the user about any issues encountered during the withdrawal process.
* Finally, regardless of whether there are warnings or not, the current dialog (this) is disposed, indicating the completion of the withdrawal operation.

### Finish implementing TransferDialog Class
* Finish implementing the method `transferOKButtonActionPerformed(java.awt.event.ActionEvent evt)` to transfer a certain amount from one bank account to another. 

### Finish implementing AddCustomerDialog Class
* Finish implementing the method `addCustomerOKButtonActionPerformed` to checks the input fields for the first name, last name, phone number, and initial balance. If any of these fields are empty or contain invalid data, a message dialog is displayed to alert the user about the input issues.
* Also display a warning message when a new customer is being created with a phone number that is already associated with an existing customer.
* If there are no warnings, a new Customer object is created with the provided first name, last name, and phone number. Then, based on the selected account type from a combo box (accountTypeComboBox), a corresponding type of bank account (CheckingAccount, SavingsAccount, or InvestmentAccount) is created and associated with the customer. The initial balance is set for the account if provided. Finally, the newly created customer is added to the customers list.
* After adding the customer, the TransferDialog is disposed, indicating the completion of the operation.

## Testing
Unit tests have been written to test your code. While crafting your solution, feel free to run tests at any point to verify the correctness of your code. To execute tests on your local machine, you can either right-click on the `src/test/java` package in the left pane and choose `Run All Tests`, or use the mvn test command from the IntelliJ Maven button on the right vertical bar, or open a command prompt or terminal, navigate to the project folder, and execute the command `mvn test`. You can run tests for a particular program by right-clicking on the corresponding test code and choosing to run the test. As an example, within IntelliJ, you can right-click on the HelloWorldTest file under the test directory and then select Run HelloWorldTest.

## Submission
Ensure that your source code is committed and pushed to `GitHub.com`. Additionally, adhere to any instructions provided on Canvas for the submission of any other necessary documents to fulfill the grading requirements. When you're prepared to upload your solution code to GitHub.com, proceed to commit and push your changes. Feel free to stage, commit, and push the code to GitHub as often as necessary. GitHub.com will autonomously execute tests on its platform to validate your code.
