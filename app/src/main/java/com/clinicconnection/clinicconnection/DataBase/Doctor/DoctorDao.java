package com.clinicconnection.clinicconnection.DataBase.Doctor;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DoctorDao {


    @Query("select * from doctor")
    public LiveData<List<Doctor>> getALL();

    @Insert
    public long insert(Doctor data);

    @Update
    public void update(Doctor data);

    @Delete
    public void delete(Doctor data);

}
