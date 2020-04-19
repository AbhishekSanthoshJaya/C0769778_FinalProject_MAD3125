package com.aby.c0769778_finalproject_mad3125.abhishek.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Customer implements Parcelable {

    private String customerId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String userName;
    private String password;
    private String location;
    private String dateOfBirth;
    private HashMap<String, Bill> customerBillsHashMap = new HashMap<>();
    private Double allTotal;
    private int customerImg;

    public String getGender() {
        return gender;
    }

    public String getGenderLetter()
        {
            return getGender().substring(0,1).toUpperCase();
        }

    protected Customer(Parcel in) {
        customerId = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        gender = in.readString();
        email = in.readString();
        userName = in.readString();
        password = in.readString();
        location = in.readString();
        dateOfBirth = in.readString();
        customerBillsHashMap = in.readHashMap(Bill.class.getClassLoader());
        allTotal = in.readDouble();
        customerImg = in.readInt();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public int getCustomerImg() {
        return customerImg;
    }

    public Customer (String customerId,
                     String firstName,
                     String lastName,
                     String gender,
                     String email,
                     String userName,
                     String password,
                     String location,
                     String dateOfBirth,
                     Integer customerImg)
    {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.dateOfBirth = dateOfBirth;
        this.customerImg = customerImg;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addBill(String billId, Bill bill)
    {
        this.customerBillsHashMap.put(billId, bill);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getLocation() {
        return location;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public HashMap<String, Bill> getCustomerBills() {
        return customerBillsHashMap;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerId);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(gender);
        dest.writeString(email);
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeString(location);
        dest.writeString(dateOfBirth);
        dest.writeMap(customerBillsHashMap);
        if (allTotal == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(allTotal);
        }
        dest.writeInt(customerImg);
    }

    public ArrayList<Bill> getBills()
    {
        Collection<Bill> demoValues = customerBillsHashMap.values();
        ArrayList<Bill> billsList = new ArrayList<>(demoValues);
        return billsList;
    }

    public double getTotalAmount()
    {
        double allTotal2 = 0.0d;
        for (Bill b : customerBillsHashMap.values())
        {
            allTotal2 += b.billTotal;
        }
        return allTotal2;
      }
    }

