package com.aby.c0769778_finalproject_mad3125.model;

import java.time.LocalDate;

public class Mobile extends Bill {

    private String manufacturerName;
    private String planName;
    private String PlanName;
    private String mobileNumber;
    private Integer mobGbUsed;
    private Integer minute;

    public Mobile(String billId, LocalDate billDate, BillType billType, Double billTotal, String manufacturerName, String planName, String mobileNumber, Integer mobGbUsed, Integer minute){
        super(billId, billDate, billType, billTotal);
        this.manufacturerName = manufacturerName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.mobGbUsed = mobGbUsed;
        this.minute = minute;
    }

    //Overriding default implementation of billCalculate in Bill class
    @Override
     public Double billCalculate(){
        Double billAmount = 0.0;
        billAmount = (this.mobGbUsed) * 25 + (this.minute) * 0.2;
        return billAmount;
    }
}
