package com.aby.c0769778_finalproject_mad3125.abhishek.util;

import android.content.Context;
import android.widget.Toast;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return String.format("$ " + "%,.2f", d);
    }

    public void makeToast(String message, Context context)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public boolean emailValidation(String s) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public boolean mobileValidation(String s)
    {
        if(s.length() == 10)
        {
            return true;
        }
        return false;
    }

    public String gbFormatter(Integer s)
    {
        return s + " GB";
    }

    public String minsFormatter(String s)
    {
        return s + " MINS";
    }

}
