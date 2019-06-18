package com.clinicconnection.clinicconnection.DataBase.Medication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.clinicconnection.clinicconnection.DataBase.Patient.Patient;


@Entity(tableName = "medication",
        foreignKeys =  @ForeignKey(entity = Patient.class, parentColumns = "id", childColumns = "patient_id", onDelete = ForeignKey.CASCADE),
        indices = {@Index("name"), @Index("patient_id")})

public class Medication {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public Long id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "cause")
    public String cause;
    @ColumnInfo(name = "patient_id")
    public Long patient_id;

    public Medication(){

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

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }
}
