package br.com.kennedy.data;
import br.com.kennedy.data.interfaces.AccountDao;
import br.com.kennedy.domain.entities.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoPostgres implements AccountDao {
    private final Connection conection;

    public AccountDaoPostgres(Connection conection) {
        this.conection = conection;
    }

    @Override
    public Account getAccountById(Long id) {
        PreparedStatement sql = null;
        Account account = null;
        try {
            sql = conection.prepareStatement("""

                    SELECT  *   
                    FROM    accounts
                    WHERE   acc_id = ?
                    """);
            sql.setLong(1, id);
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setId(rs.getLong("acc_id"));
                account.setBalance(rs.getDouble("acc_balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public void updateAccount(Account account) throws SQLException {
        PreparedStatement sql = null;
        try {
            sql = conection.prepareStatement("""
                UPDATE accounts
                SET acc_balance = ?
                WHERE acc_id = ?
                """);
            sql.setDouble(1, account.getBalance());
            sql.setLong(2, account.getId());
            sql.executeUpdate();
            conection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conection.rollback();
        } finally {
            if (sql != null) {
                sql.close();
            }
        }
    }

}
