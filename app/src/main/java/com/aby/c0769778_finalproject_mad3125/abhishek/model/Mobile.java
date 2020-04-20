package com.aby.c0769778_finalproject_mad3125.abhishek.model;


import org.joda.time.LocalDate;

public class Mobile extends Bill {

     String manufacturerName;
     String planName;
     String mobileNumber;
     Integer mobGbUsed;
     Integer minute;

    public Mobile(String billId, LocalDate billDate, BillType billType, String manufacturerName, String planName, String mobileNumber, Integer mobGbUsed, Integer minute){
        super(billId, billDate, billType);
        this.manufacturerName = manufacturerName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.mobGbUsed = mobGbUsed;
        this.minute = minute;
        this.billTotal = billCalculate();
    }

    @Override
     public Double billCalculate(){
        double billAmount = 0.0;
        billAmount = (this.mobGbUsed) * 25 + (this.minute) * 0.2;
        return billAmount;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getPlanName() {
        return planName;
    }

    public Integer getMobGbUsed() {
        return mobGbUsed;
    }

    public Integer getMinute() {
        return minute;
    }

}
