package com.bankapp.model;


import java.time.LocalDateTime;


public class Customer {
private Integer id;
private String name;
private String email;
private String phone;
private LocalDateTime createdAt;


public Customer() {}
public Customer(Integer id, String name, String email, String phone) {
this.id = id; this.name = name; this.email = email; this.phone = phone;
}


// getters & setters
public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }
public String getPhone() { return phone; }
public void setPhone(String phone) { this.phone = phone; }
public LocalDateTime getCreatedAt() { return createdAt; }
public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }


@Override
public String toString() {
return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + '}';
}
}