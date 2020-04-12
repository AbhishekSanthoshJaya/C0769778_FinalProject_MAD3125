package com.aby.c0769778_finalproject_mad3125.util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.NumberFormat;

public class HelperMethods {

    private static HelperMethods repoObj = new HelperMethods();
    public static HelperMethods getInstance() {
        return repoObj;
    }
    private HelperMethods()
    { }

    public LocalDate stringToDate(String aDate)
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MMM-yyyy");
        return formatter.parseLocalDate(aDate);
    }

    public String doubleFormatter(Double d)
    {
        return String.format("$" + "%,.2f", d);
    }

}
