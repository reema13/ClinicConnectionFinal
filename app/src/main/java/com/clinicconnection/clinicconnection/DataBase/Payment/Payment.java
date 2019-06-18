package com.clinicconnection.clinicconnection.DataBase.Payment;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.clinicconnection.clinicconnection.DataBase.Session.Session;


@Entity(tableName = "payment",
        foreignKeys =  @ForeignKey(entity = Session.class, parentColumns = "id", childColumns = "session_id", onDelete = ForeignKey.CASCADE),
        indices = {@Index("id"), @Index("session_id")})


public class Payment {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public Long id;
    @ColumnInfo(name = "price")
    public String price;
    @ColumnInfo(name = "session_id")
    public Long session_id;


    public Payment(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }
}
