package com.clinicconnection.clinicconnection.DataBase.Payment;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao

public interface PaymentDao {
    @Query("select * from payment")
    public LiveData<List<Payment>> getALL();

    @Insert
    public long insert(Payment data);

    @Update
    public void update(Payment data);

    @Delete
    public void delete(Payment data);
}
