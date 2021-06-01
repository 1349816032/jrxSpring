package com.example.jrxspring.model;

import java.sql.Date;

public class all {
    private long cust_id;
    Date txn_datetime;
    int count;
    double sum;

    @Override
    public String toString() {
        return "all{" +
                "cust_id=" + cust_id +
                ", txn_datetime=" + txn_datetime +
                ", count=" + count +
                ", sum=" + sum +
                '}';
    }
}
