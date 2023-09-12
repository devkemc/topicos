package br.com.kennedy.domain.services;

import br.com.kennedy.domain.entities.Account;

import java.sql.SQLException;

public interface AccountOperations {

    void deposit(Account account, Double value) throws SQLException;

    void withdraw(Account account, Double value) throws SQLException;

    Double getBalance(Long numberAccount);
}
