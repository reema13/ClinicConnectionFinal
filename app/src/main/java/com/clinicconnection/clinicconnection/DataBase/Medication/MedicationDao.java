package com.clinicconnection.clinicconnection.DataBase.Medication;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MedicationDao {

    @Query("select * from medication")
    public LiveData<List<Medication>> getALL();

    @Insert
    public long insert(Medication data);

    @Update
    public void update(Medication data);

    @Delete
    public void delete(Medication data);
}
