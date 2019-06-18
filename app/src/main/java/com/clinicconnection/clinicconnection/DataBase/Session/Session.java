package com.clinicconnection.clinicconnection.DataBase.Session;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.clinicconnection.clinicconnection.DataBase.Payment.Payment;


//import java.util.Date;

@Entity(tableName = "session",
        foreignKeys =  @ForeignKey(entity = Payment.class, parentColumns = "id", childColumns = "payment_id", onDelete = ForeignKey.CASCADE),
        indices = {@Index("id"), @Index("payment_id")})

public class Session {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public Long id;
   /* @ColumnInfo(name = "date")
    public Date date;*/
    @ColumnInfo(name = "status")
    public String status;
    @ColumnInfo(name = "payment_id")
    public Long payment_id;

    public Session(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 /*   public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }
}
