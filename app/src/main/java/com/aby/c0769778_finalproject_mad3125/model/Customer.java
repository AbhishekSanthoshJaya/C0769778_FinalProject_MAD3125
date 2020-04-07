package com.aby.c0769778_finalproject_mad3125.model;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String userName;
    private String password;
    private String location;
    private String dateOfBirth;
    private HashMap<String, Bill> customerBills;
    private Double allTotal;

    public Customer (String customerId,
                     String name,
                     String email,
                     String userName,
                     String password,
                     String location,
                     String dateOfBirth
                     )
    {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.dateOfBirth = dateOfBirth;
    }

    public void addBill(String billId, Bill bill)
    {
        this.customerBills.put(billId, bill);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public HashMap<String, Bill> getCustomerBills() {
        return customerBills;
    }

    public void setCustomerBills(HashMap<String, Bill> customerBills) {
        this.customerBills = customerBills;
    }

    public Double getAllTotal() {
        return allTotal;
    }

    public void setAllTotal(Double allTotal) {
        this.allTotal = allTotal;
    }
}
