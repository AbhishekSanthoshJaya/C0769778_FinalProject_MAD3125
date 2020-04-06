package com.aby.c0769778_finalproject_mad3125.model;

import android.view.ContextThemeWrapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class DataRepository
    {
        static private DataRepository repoObj = new DataRepository();
        private HashMap<String, Customer> customerMap = new HashMap<>();

        private DataRepository() {}

        private DataRepository getInstance(){
            return repoObj;
        }

        private void loadData(){
            
        }

    }
