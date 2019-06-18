package com.clinicconnection.clinicconnection.DataBase.Patient;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PatientDao {

    @Query("select * from patient")
    public LiveData<List<Patient>> getAll();

    @Insert
    public long insert(Patient data);

    @Update
    public void update(Patient data);

    @Delete
    public void delete(Patient data);

}
