package com.bankapp.dao;

import com.bankapp.model.Transaction;
import java.util.List;

public interface TransactionDAO {
    Transaction create(Transaction tx) throws Exception;
    List<Transaction> findByAccountId(int accountId) throws Exception;
}
