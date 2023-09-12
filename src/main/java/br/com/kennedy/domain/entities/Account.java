package br.com.kennedy.domain.entities;

import java.util.Objects;

public class Account extends BaseEntity {
    private Double balance;

    public Account() {
    }

    public Account(Double saldo) {
        setBalance(saldo);
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account conta = (Account) o;
        return Objects.equals(balance, conta.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
