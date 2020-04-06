package com.aby.c0769778_finalproject_mad3125.util;

import android.content.Context;
import android.widget.Toast;

import com.aby.c0769778_finalproject_mad3125.model.Bill;
import com.aby.c0769778_finalproject_mad3125.model.Customer;
import com.aby.c0769778_finalproject_mad3125.model.Hydro;
import com.aby.c0769778_finalproject_mad3125.model.Internet;
import com.aby.c0769778_finalproject_mad3125.model.Mobile;

import org.threeten.bp.LocalDate;

import java.util.HashMap;

public class DataRepository {
    static private DataRepository repoObj = new DataRepository();
    private HashMap<String, Customer> customerMap = new HashMap<>();

    private DataRepository()
    { }

    public static DataRepository getInstance() {
        return repoObj;
    }

    private void loadData() {
        Customer c1 = new Customer("ABY1",
                "Abhishek",
                "aby@gmail.com",
                "aby",
                "aby123",
                "Toronto",
                "18/04/1995");
        Customer c2 = new Customer("ABY2",
                "Prakash",
                "prakash@gmail.com",
                "Rana",
                "codemaster",
                "Toronto",
                "27/04/1995");
        Mobile m1 = new Mobile("MB100",
                LocalDate.of(2019, 10, 12),
                Bill.BillType.Mobile,
                "APPLE INC.",
                "Student Plan",
                "4379077578",
                1,
                6);
        Hydro h1 = new Hydro( "HY100",
                LocalDate.of(2019, 10, 12),
                Bill.BillType.Hydro,
                "PUREWATA",
                22);
        Internet in1 = new Internet("IN100",
                LocalDate.of(2019, 10, 12),
                Bill.BillType.Internet,
                "SKYLINK",
                22.8);
        c1.addBill("MB100", m1);
        c1.addBill("HY100", h1);
        customerMap.put(c1.getCustomerId(),c1);
        customerMap.put(c2.getCustomerId(),c2);
    }

    public void makeToast(String message, Context context){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
