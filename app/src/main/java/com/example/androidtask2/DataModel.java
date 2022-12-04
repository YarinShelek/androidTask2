package com.example.androidtask2;

import android.provider.ContactsContract;
import android.util.EventLogTags;

import javax.security.auth.Destroyable;

public class DataModel {

    String name;
    String description;
    String details;
    int image;

    public DataModel(String name, String description,String details, int image){
        this.name = name;
        this.description = description;
        this.details = details;
        this.image = image;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getDetails() {return details;}
    public int getImage() {return image;}
}

