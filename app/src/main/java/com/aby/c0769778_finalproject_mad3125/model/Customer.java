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
                     String dateOfBirth,
                     HashMap customerBills,
                     Double allTotal)
    {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.location = dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.customerBills = customerBills;
        this.allTotal = allTotal;
    }
}
