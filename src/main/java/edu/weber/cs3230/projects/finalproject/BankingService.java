package edu.weber.cs3230.projects.finalproject;

public class BankingService implements IBankingService {

    private ICustomerRepository customerRepository;
    private IBankAccountRepository bankAccountRepository;

    public BankingService(ICustomerRepository customerRepository, IBankAccountRepository bankAccountRepository) {
        this.customerRepository = customerRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount openBankAccount(BankAccountType accountType, Customer customer) {
        BankAccount account = switch (accountType)
                {
                    case CHECKING -> new CheckingAccount();
                    case SAVINGS -> new SavingsAccount();
                    case INVESTMENT -> new InvestmentAccount();
                };
        customer.getBankAccounts().add(account);
        return account;
    }

    @Override
    public void closeBankAccount(int accountNumber) {

        try {
            Customer customer = customerRepository.findCustomerByAccountNumber(accountNumber);
            BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
            customer.getBankAccounts().remove(account);

        } catch (NoSuchBankAccountException e) {
            System.out.println(e.getMessage());;
        } catch (NoSuchCustomerException e) {
            System.out.println(e.getMessage());;
        }
    }
}
