package com.bankapp.dao;

import com.bankapp.config.DBConnection;
import com.bankapp.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public Transaction create(Transaction tx) throws Exception {
        String sql = "INSERT INTO transactions(account_id, type, amount, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, tx.getAccountId());
            ps.setString(2, tx.getType());
            ps.setBigDecimal(3, tx.getAmount());
            ps.setString(4, tx.getDescription());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) { if (rs.next()) tx.setId(rs.getInt(1)); }
            return tx;
        }
    }

    @Override
    public List<Transaction> findByAccountId(int accountId) throws Exception {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE account_id = ? ORDER BY created_at DESC";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, accountId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Transaction t = new Transaction();
                    t.setId(rs.getInt("id"));
                    t.setAccountId(rs.getInt("account_id"));
                    t.setType(rs.getString("type"));
                    t.setAmount(rs.getBigDecimal("amount"));
                    t.setDescription(rs.getString("description"));
                    Timestamp ts = rs.getTimestamp("created_at"); if (ts != null) t.setCreatedAt(ts.toLocalDateTime());
                    list.add(t);
                }
            }
        }
        return list;
    }
}
