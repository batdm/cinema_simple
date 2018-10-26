package me.baturov;

import me.baturov.sql2o.ConnectDB;

public class Main {
    public static ConnectDB connectDB;

    //insert into hall (c_id,number_of_seats) values (1,50), (2,70), (3,100)
    public static void main(String[] args) {
        connectDB = new ConnectDB();
    }
}
