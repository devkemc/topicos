package br.com.kennedy.data.interfaces;

import br.com.kennedy.domain.entities.Account;

import java.sql.SQLException;

public interface AccountDao {

    Account getAccountById(Long id);
    void updateAccount(Account account) throws SQLException;

}
