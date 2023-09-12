package br.com.kennedy.data.interfaces;

import br.com.kennedy.domain.entities.AccountOperation;

import java.sql.SQLException;

public interface AccountOperationsHistoryDao {
    void recordOperation(AccountOperation accountOperation) throws SQLException;

}
