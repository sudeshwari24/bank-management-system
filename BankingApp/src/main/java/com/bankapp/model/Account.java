package com.bankapp.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Account {
private Integer id;
private Integer customerId;
private String accountNumber;
private BigDecimal balance;
private String accountType;
private LocalDateTime createdAt;


public Account() {}


// getters & setters
public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }
public Integer getCustomerId() { return customerId; }
public void setCustomerId(Integer customerId) { this.customerId = customerId; }
public String getAccountNumber() { return accountNumber; }
public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
public BigDecimal getBalance() { return balance; }
public void setBalance(BigDecimal balance) { this.balance = balance; }
public String getAccountType() { return accountType; }
public void setAccountType(String accountType) { this.accountType = accountType; }
public LocalDateTime getCreatedAt() { return createdAt; }
public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }


@Override
public String toString() {
return "Account{" + "id=" + id + ", accNo='" + accountNumber + '\'' + ", balance=" + balance + ", type='" + accountType + '\'' + '}';
}
}