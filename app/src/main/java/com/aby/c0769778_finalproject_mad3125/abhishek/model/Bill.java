package com.aby.c0769778_finalproject_mad3125.abhishek.model;


import org.joda.time.LocalDate;

import java.io.Serializable;

public abstract class Bill implements Serializable {

    public enum BillType {
        Mobile,
        Hydro,
        Internet,
    }
     String billId;
     LocalDate billDate;
     BillType billType;
     Double billTotal = 0.0;

    Bill(String billId, LocalDate billDate, BillType billType)
        {
          this.billId = billId;
          this.billDate = billDate;
          this.billType = billType;
        }

    public Double billCalculate(){
        double dummyAmount = 0.0;
        return dummyAmount;
    }

    public String getBillId() {
        return billId;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public BillType getBillType() {
        return billType;
    }

    public Double getBillTotal() {
        return billTotal;
    }

}
