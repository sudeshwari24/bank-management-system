package com.bankapp.service;

import com.bankapp.dao.AccountDAO;
import com.bankapp.dao.AccountDAOImpl;
import com.bankapp.dao.TransactionDAO;
import com.bankapp.dao.TransactionDAOImpl;
import com.bankapp.model.Account;
import com.bankapp.model.Transaction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.bankapp.config.DBConnection;

public class AccountService {
    private AccountDAO accountDAO = new AccountDAOImpl();
    private TransactionDAO txDAO = new TransactionDAOImpl();

    // create account with initial balance
    public Account createAccount(int customerId, String accountNumber, String accountType, BigDecimal initialBalance) throws Exception {
        Account a = new Account();
        a.setCustomerId(customerId);
        a.setAccountNumber(accountNumber);
        a.setAccountType(accountType);
        a.setBalance(initialBalance == null ? BigDecimal.ZERO : initialBalance);
        return accountDAO.create(a);
    }

    public Account getByAccountNumber(String accNo) throws Exception { return accountDAO.findByAccountNumber(accNo); }
    public List<Account> getAccountsForCustomer(int customerId) throws Exception { return accountDAO.findByCustomerId(customerId); }

    // deposit and withdraw should be transactional
    public void deposit(String accNo, BigDecimal amount, String description) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be > 0");
        // simple implementation without explicit transaction: balance updated then tx inserted
        synchronized (this) {
            Account acc = accountDAO.findByAccountNumber(accNo);
            if (acc == null) throw new IllegalArgumentException("Account not found");
            acc.setBalance(acc.getBalance().add(amount));
            accountDAO.update(acc);
            Transaction tx = new Transaction();
            tx.setAccountId(acc.getId()); tx.setType("CREDIT"); tx.setAmount(amount); tx.setDescription(description);
            txDAO.create(tx);
        }
    }

    public void withdraw(String accNo, BigDecimal amount, String description) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be > 0");
        synchronized (this) {
            Account acc = accountDAO.findByAccountNumber(accNo);
            if (acc == null) throw new IllegalArgumentException("Account not found");
            if (acc.getBalance().compareTo(amount) < 0) throw new IllegalArgumentException("Insufficient funds");
            acc.setBalance(acc.getBalance().subtract(amount));
            accountDAO.update(acc);
            Transaction tx = new Transaction();
            tx.setAccountId(acc.getId()); tx.setType("DEBIT"); tx.setAmount(amount); tx.setDescription(description);
            txDAO.create(tx);
        }
    }

    public List<Transaction> getTransactions(String accNo) throws Exception {
        Account acc = accountDAO.findByAccountNumber(accNo);
        if (acc == null) throw new IllegalArgumentException("Account not found");
        return txDAO.findByAccountId(acc.getId());
    }
}
