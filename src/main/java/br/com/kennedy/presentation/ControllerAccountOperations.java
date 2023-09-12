package br.com.kennedy.presentation;


import br.com.kennedy.data.interfaces.AccountDao;
import br.com.kennedy.domain.entities.Account;
import br.com.kennedy.domain.entities.TypeOperation;
import br.com.kennedy.domain.services.AccountOperations;
import br.com.kennedy.utils.ServiceLocator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class ControllerAccountOperations extends HttpServlet {
    private final AccountOperations accountOperations;

    public ControllerAccountOperations() {
        this.accountOperations = ServiceLocator.getAccountOperations();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String balance = String.format("%.2f",accountOperations.getBalance(1L));
        resp.sendRedirect("/accoutOperations.jsp?balance=" + balance);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean error = false;
        Long accountId = 1L;
        Double value = Double.valueOf(req.getParameter("value"));
        AccountDao accountDao = ServiceLocator.getAccountDao();
        AccountOperations accountOperations = ServiceLocator.getAccountOperations();
        Account account = accountDao.getAccountById(accountId);
        if (account == null) {
            resp.sendError(404, "Account not found");
            return;
        }
        if (req.getParameter(TypeOperation.DEPOSIT.getValue()) != null) {
            try {
                accountOperations.deposit(account, value);
            } catch (Exception e) {
                error = true;
            }
        }
        if (req.getParameter(TypeOperation.WITHDRAWAL.getValue()) != null) {
            try {
                accountOperations.withdraw(account, value);
            } catch (Exception e) {
                error = true;
            }
        }
        String balance = String.format("%.2f", account.getBalance());
        resp.sendRedirect(resp.encodeRedirectURL("/accoutOperations.jsp?balance=" + balance + "&error=" + error));
    }


}
