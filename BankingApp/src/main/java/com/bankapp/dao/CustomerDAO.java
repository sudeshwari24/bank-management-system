package com.bankapp.dao;


import com.bankapp.model.Customer;
import java.util.List;


public interface CustomerDAO {
Customer create(Customer customer) throws Exception;
Customer findById(int id) throws Exception;
Customer findByEmail(String email) throws Exception;
List<Customer> findAll() throws Exception;
boolean update(Customer customer) throws Exception;
boolean delete(int id) throws Exception;
}