package com.bankapp.service;

import com.bankapp.dao.TransactionDAO;
import com.bankapp.dao.TransactionDAOImpl;
import com.bankapp.model.Transaction;

import java.util.List;

public class TransactionService {
    private TransactionDAO dao = new TransactionDAOImpl();

    public List<Transaction> getTransactionsForAccount(int accountId) throws Exception { return dao.findByAccountId(accountId); }
}
