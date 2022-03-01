package com.example.a5180_mad;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    String name;
    String dateString;
//    Date date;
    String priority;

    public Task(String name, String dateString, String priority) {
        this.name = name;
        this.dateString = dateString;
//        this.date = date;
        this.priority = priority;
    }
}
