package com.aby.c0769778_finalproject_mad3125.util;

import android.content.Context;
import android.widget.Toast;

import com.aby.c0769778_finalproject_mad3125.R;
import com.aby.c0769778_finalproject_mad3125.model.Bill;
import com.aby.c0769778_finalproject_mad3125.model.Customer;
import com.aby.c0769778_finalproject_mad3125.model.Hydro;
import com.aby.c0769778_finalproject_mad3125.model.Internet;
import com.aby.c0769778_finalproject_mad3125.model.Mobile;

import org.joda.time.DateTime;
import org.threeten.bp.LocalDate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class DataRepository {

    private static DataRepository repoObj = new DataRepository();
    public static DataRepository getInstance() {
        return repoObj;
    }
    private DataRepository() { }
    private HashMap<String, Customer> customerMap = new HashMap<>();

    public HashMap getCustomerMap(){
        return this.customerMap;
    }

    public void loadData() {
        Customer c1 = new Customer("ID001",
                "Abhishek",
                "Santhosh",
                "Male",
                "aby@gmail.com",
                "aby",
                "aby123",
                "Kerala, India",
                "18/04/1995", R.drawable.icon_aby);
        Customer c2 = new Customer("ID002",
                "Prakash",
                "Rana",
                "Male",
                "prakash@gmail.com",
                "Rana",
                "codemaster",
                "Kathmandu, Nepal",
                "27/04/1995", R.drawable.icon_prakash);
        Customer c3 = new Customer("ID003",
                "Priteshkumar",
                "Patel",
                "Male",
                "pritesh@gmail.com",
                "TheLion",
                "codegod",
                "Gujarat, India",
                "21/07/1983", R.drawable.icon_pritesh);
        Customer c4 = new Customer("ID004",
                "Kritima",
                "Kukreja",
                "Female",
                "kritima@gmail.com",
                "Kritima",
                "codepro",
                "Delhi, India",
                "05/01/1996", R.drawable.icon_kritima);
        Customer c5 = new Customer("ID005",
                "Raghav",
                "Bobal",
                "Male",
                "raghav@gmail.com",
                "Raghav",
                "password",
                "Delhi, India",
                "27/07/1998",R.drawable.icon_raghav);
        Customer c6 = new Customer("ID006",
                "Jyothi",
                "Thomas",
                "Female",
                "jyothi@gmail.com",
                "jyothi",
                "password2",
                "Kerala, India",
                "27/07/1991",R.drawable.woman2);
        Mobile m1 = new Mobile("MB100",
                org.joda.time.LocalDate.now(),
                Bill.BillType.Mobile,
                "APPLE INC.",
                "Student Plan",
                "4379077578",
                1,
                6);
        Hydro h1 = new Hydro( "HY100",
                org.joda.time.LocalDate.now(),
                Bill.BillType.Hydro,
                "PUREWATA",
                22);
        Internet in1 = new Internet("IN100",
                org.joda.time.LocalDate.now(),
                Bill.BillType.Internet,
                "SKYLINK",
                22.8);
        c2.addBill("IN100", in1);
        c1.addBill("MB100", m1);
        c1.addBill("HY100", h1);
        customerMap.put(c1.getCustomerId(),c1);
        customerMap.put(c2.getCustomerId(),c2);
        customerMap.put(c3.getCustomerId(),c3);
        customerMap.put(c4.getCustomerId(),c4);
        customerMap.put(c5.getCustomerId(),c5);
        customerMap.put(c6.getCustomerId(),c6);
    }
}
