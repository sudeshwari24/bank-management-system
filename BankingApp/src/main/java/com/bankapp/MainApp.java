package com.bankapp;

import com.bankapp.model.Customer;
import com.bankapp.service.AccountService;
import com.bankapp.service.CustomerService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static CustomerService customerService = new CustomerService();
    private static AccountService accountService = new AccountService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--- Banking App ---");
            System.out.println("1. Create customer");
            System.out.println("2. Create account for customer");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. List customers");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Email: "); String email = sc.nextLine();
                        System.out.print("Phone: "); String phone = sc.nextLine();
                        Customer c = customerService.createCustomer(name, email, phone);
                        System.out.println("Created: " + c);
                        break;
                    case 2:
                        System.out.print("Customer ID: "); int cid = Integer.parseInt(sc.nextLine());
                        System.out.print("Account Number: "); String accNo = sc.nextLine();
                        System.out.print("Account Type: "); String atype = sc.nextLine();
                        System.out.print("Initial Balance: "); BigDecimal bal = new BigDecimal(sc.nextLine());
                        accountService.createAccount(cid, accNo, atype, bal);
                        System.out.println("Account created");
                        break;
                    case 3:
                        System.out.print("Account Number: "); String depAcc = sc.nextLine();
                        System.out.print("Amount: "); BigDecimal damt = new BigDecimal(sc.nextLine());
                        accountService.deposit(depAcc, damt, "Deposit via CLI");
                        System.out.println("Deposit success");
                        break;
                    case 4:
                        System.out.print("Account Number: "); String wAcc = sc.nextLine();
                        System.out.print("Amount: "); BigDecimal wamt = new BigDecimal(sc.nextLine());
                        accountService.withdraw(wAcc, wamt, "Withdrawal via CLI");
                        System.out.println("Withdrawal success");
                        break;
                    case 5:
                        List<Customer> list = customerService.getAllCustomers();
                        list.forEach(System.out::println);
                        break;
                    case 6:
                        System.out.println("Bye"); sc.close(); System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
