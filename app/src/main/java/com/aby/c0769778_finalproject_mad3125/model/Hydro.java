package com.aby.c0769778_finalproject_mad3125.model;

import android.os.Parcel;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;

public class Hydro extends Bill {
    private String agencyName;
    private Integer unitsUsed;

    public Hydro(String billId, LocalDate billDate, BillType billType, String agencyName, Integer unitsUsed){
        super(billId, billDate, billType);
        this.agencyName = agencyName;
        this.unitsUsed = unitsUsed;
        this.billTotal = billCalculate();
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

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public Integer getUnitsUsed() {
        return unitsUsed;
    }

    public void setUnitsUsed(Integer unitsUsed) {
        this.unitsUsed = unitsUsed;
    }

}
