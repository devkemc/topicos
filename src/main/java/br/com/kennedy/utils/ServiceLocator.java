package br.com.kennedy.utils;

import br.com.kennedy.data.AccountOperationsHistoryDaoPostgres;
import br.com.kennedy.data.interfaces.AccountDao;
import br.com.kennedy.data.AccountDaoPostgres;
import br.com.kennedy.data.ConnectionPostgreSQL;
import br.com.kennedy.data.interfaces.AccountOperationsHistoryDao;
import br.com.kennedy.domain.services.AccountOperationsV1;
import br.com.kennedy.domain.services.AccountOperations;

import java.sql.Connection;

public class ServiceLocator {

    static public Connection getConnection() {
        return ConnectionPostgreSQL.getConnection();
    }

    static public AccountDao getAccountDao() {
        return new AccountDaoPostgres(getConnection());
    }

    static public AccountOperationsHistoryDao getAccountOperationsHistoryDao() {
        return new AccountOperationsHistoryDaoPostgres(getConnection());
    }

    static public AccountOperations getAccountOperations() {
        return new AccountOperationsV1(getAccountOperationsHistoryDao(), getAccountDao());
    }
}
