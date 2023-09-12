package br.com.kennedy.data;

import br.com.kennedy.data.interfaces.AccountOperationsHistoryDao;
import br.com.kennedy.domain.entities.AccountOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountOperationsHistoryDaoPostgres implements AccountOperationsHistoryDao {
    private final Connection conection;

    public AccountOperationsHistoryDaoPostgres(Connection conexao) {
        this.conection = conexao;
    }

    @Override
    public void recordOperation(AccountOperation accountOperation) throws SQLException {
        PreparedStatement sql = null;
        try {
            sql = conection.prepareStatement("""
                    INSERT INTO
                     account_histories
                     (ach_acc_id, ach_operation, ach_date_time, ach_value)
                     VALUES (?, ?, ?, ?)
                     """);
            sql.setLong(1, accountOperation.getAccount().getId());
            sql.setString(2, accountOperation.getTypeOperation().getValue());
            sql.setDate(3, new java.sql.Date(accountOperation.getDate().getTime()));
            sql.setDouble(4, accountOperation.getValue());
            sql.execute();
            conection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conection.rollback();
        } finally {
            sql.close();

        }
    }
}
