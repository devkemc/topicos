package br.com.kennedy.domain.services;

import br.com.kennedy.data.interfaces.AccountDao;
import br.com.kennedy.data.interfaces.AccountOperationsHistoryDao;
import br.com.kennedy.domain.entities.Account;
import br.com.kennedy.domain.entities.AccountOperation;
import br.com.kennedy.domain.entities.TypeOperation;

import java.sql.SQLException;
import java.util.Date;

public class AccountOperationsV1 implements AccountOperations
{
    private final AccountOperationsHistoryDao accountOperationsHistoryDao;
    private final AccountDao accountDao;

    public AccountOperationsV1(AccountOperationsHistoryDao accountOperationsHistoryDao, AccountDao accountDao) {
        this.accountOperationsHistoryDao = accountOperationsHistoryDao;
        this.accountDao = accountDao;
    }

    @Override
    public void deposit(Account account, Double value) throws SQLException {

        account.setBalance(account.getBalance() + value);
        accountDao.updateAccount(account);
        AccountOperation accountOperation = new AccountOperation(account, TypeOperation.DEPOSIT, new Date(), value);
        accountOperationsHistoryDao.recordOperation(accountOperation);
    }

    @Override
    public void withdraw(Account account, Double value) throws SQLException {
        if (value > account.getBalance()) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        account.setBalance(account.getBalance() - value);
        accountDao.updateAccount(account);
        AccountOperation accountOperation = new AccountOperation(account, TypeOperation.WITHDRAWAL, new Date(), value);
        accountOperationsHistoryDao.recordOperation(accountOperation);
    }

    @Override
    public Double getBalance(Long numberAccount) {

        Account account = accountDao.getAccountById(numberAccount);
        return account.getBalance();
    }
}
