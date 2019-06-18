package com.clinicconnection.clinicconnection.DataBase.Doctor;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.clinicconnection.clinicconnection.DataBase.Patient.Patient;


@Entity(tableName = "doctor",
        foreignKeys =  @ForeignKey(entity = Patient.class, parentColumns = "id", childColumns = "patient_id",  onDelete = ForeignKey.CASCADE),
indices = {@Index("name"), @Index("patient_id")})

public class Doctor {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "patient_id")
    private Long patient_id;


    public Doctor() {


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }
}
