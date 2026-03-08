package com.bankapp.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Transaction {
private Integer id;
private Integer accountId;
private String type; // CREDIT / DEBIT
private BigDecimal amount;
private String description;
private LocalDateTime createdAt;


// getters & setters
public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }
public Integer getAccountId() { return accountId; }
public void setAccountId(Integer accountId) { this.accountId = accountId; }
public String getType() { return type; }
public void setType(String type) { this.type = type; }
public BigDecimal getAmount() { return amount; }
public void setAmount(BigDecimal amount) { this.amount = amount; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
public LocalDateTime getCreatedAt() { return createdAt; }
public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }


@Override
public String toString() {
return "Transaction{" + "id=" + id + ", accountId=" + accountId + ", type='" + type + '\'' + ", amount=" + amount + '}';
}
}