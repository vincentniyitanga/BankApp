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
* `WithdrawDialog`, the GUI dialog to withdraw a certain amount of money from a selected bank account;
* `TransferDialog`, the GUI dialog to transfer a certain amount of money from a selected bank account to anther bank account;

## Your Tasks
In this project, you You need to implement the following items based on the given starting code:

### InvestmentAccount Class
* Implement a class `InvestmentAccount` to use `BankAccount` as the Super class. 
* In this class, add a private member variable `serviceFee` of `BigDecimal` type; 
* Add a constructor to initialize `serviceFee` with a parameter of BigDecimal type; 
* Add getter and setter for `serviceFee`; 
* Add a public method `chargeServiceFee`, in this method, subtract `serviceFee` from `balance`, and update `balance`.

### Customer Class
* Implement a class `Customer` to use `Person` as the Super class. 
* In this class, there are two private member variable `phoneNumber` of String type, and a private member variable `bankAccounts` of `List<BankAccount>` type which stores all the bank accounts for this customer; 
* Add a constructor `Customer(String name, String phoneNumber, List<BankAccount> bankAccounts)` to initialize the member variables; add another constructor to initialize `serviceFee` with a parameter of BigDecimal type; 
* Add getters and setters for `bankAccounts` and `phoneNumber`; 
* Add a public method `addBankAccount(BankAccount account)` to add the parameter `account` to the list of bank accounts for this customer.

### CustomerRepository Class
* Implement a `CustomerRepository` class to implement the `ICustomerRepository` interface; 
* In this class, implement a method `findCustomerByAccountNumber` which takes an accountNumber of int type as the parameter; in this method, first look for an `BankAccount` object using `bankAccountRepository` to match the parameter accountNumber; proper try/catch blocks should be used in case no such bank account can be found; then look for a customer who owns this bank account; if no such customer can be found, a `NoSuchCustomerException` object should be thrown; 
* Implement a method `findCustomerByPhoneNumber(String phoneNumber)` to return a customer with the matching phone number; in this method if no such customer can be found, a `NoSuchCustomerException` object should be thrown.

### BankingService Class
* Implement a `BankingService` class to implement the `IBankingService` interface; 
* In this class, implement a method `openBankAccount(BankAccountType accountType, Customer customer)` to create a `BankAccount` object based on the type of the account, then add the account to the customer.
* Implement a method `closeBankAccount(int accountNumber)` to remove a `BankAccount` object from a customer; in this method, first find the customer who owns the bank account based on the account number, then find the `BankAccount` object based on the account number, then remove it from the list of bank accounts for that customer. Proper try/catch block should be used if a customer cannot be found or if a bank account cannot be found.

### TransferService Class
* Implement a `TransferService` class to implement the `ITransfer` interface; 
* In this class, implement a method `transfer(int from, int to, BigDecimal amount)` to transfer a certain amount of money from the bank account with the account number `from` to a bank account with the account number `to`.

Unit tests have been written to test your code. Once you commit and push your changes to GitHub, you will see whether or not your code succeeds the tests. You may stage, commit, and push the code to GitHub as many times as needed. To run tests on your local computer, run the command `mvn test` from intellij or command prompt.
