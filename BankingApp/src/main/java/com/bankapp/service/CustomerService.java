package com.bankapp.service;

import com.bankapp.dao.CustomerDAO;
import com.bankapp.dao.CustomerDAOImpl;
import com.bankapp.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDAO dao = new CustomerDAOImpl();

    public Customer createCustomer(String name, String email, String phone) throws Exception {
        Customer existing = dao.findByEmail(email);
        if (existing != null) throw new IllegalArgumentException("Email already registered");
        Customer c = new Customer(null, name, email, phone);
        return dao.create(c);
    }

    public Customer getCustomerById(int id) throws Exception { return dao.findById(id); }
    public List<Customer> getAllCustomers() throws Exception { return dao.findAll(); }
    public boolean updateCustomer(Customer c) throws Exception { return dao.update(c); }
    public boolean deleteCustomer(int id) throws Exception { return dao.delete(id); }
}
