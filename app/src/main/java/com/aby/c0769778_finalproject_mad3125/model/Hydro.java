package com.aby.c0769778_finalproject_mad3125.model;

import java.time.LocalDate;

public class Hydro extends Bill {
    private String agencyName;
    private Integer unitsUsed;

    public Hydro(String billId, LocalDate billDate, BillType billType, Double billTotal, String agencyName, Integer unitsUsed){
        super(billId, billDate, billType, billTotal);
        this.agencyName = agencyName;
        this.unitsUsed = unitsUsed;
    }

    @Override
    public Double billCalculate(){
        double billAmount = 0.0;
        if (unitsUsed < 10)
        {
            billAmount = 1.5 * unitsUsed;
        }
        else
        {
            billAmount = 2 * unitsUsed;
        }
        return billAmount;
    }
}
