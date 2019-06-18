package com.clinicconnection.clinicconnection.DataBase.Patient;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.clinicconnection.clinicconnection.DataBase.Doctor.Doctor;


@Entity(tableName = "patient",
        foreignKeys =  @ForeignKey(entity = Doctor.class, parentColumns = "id", childColumns = "doctor_id", onDelete = ForeignKey.CASCADE),
        indices = {@Index("name"), @Index("doctor_id")})


public class Patient {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public Long patient_id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "history")
    public String history;
    @ColumnInfo(name = "phone")
    public String phone;
    @ColumnInfo(name = "doctor_id")
    public Long doctor_id;


    public Patient(){

    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }
}
