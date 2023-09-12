package br.com.kennedy.domain.entities;

import java.util.Date;

public class AccountOperation extends BaseEntity {
    private Account account;
    private TypeOperation typeOperation;
    private Date date;
    private Double value;

    public AccountOperation() {
    }
    public AccountOperation(Account account, TypeOperation typeOperation, Date date, Double value) {
        this.account = account;
        this.typeOperation = typeOperation;
        this.date = date;
        this.value = value;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
