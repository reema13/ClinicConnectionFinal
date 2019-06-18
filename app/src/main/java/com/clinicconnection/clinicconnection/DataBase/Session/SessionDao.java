package com.clinicconnection.clinicconnection.DataBase.Session;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao

public interface SessionDao {

    @Query("select * from session")
    public LiveData<List<Session>> getALL();

    @Insert
    public long insert(Session data);

    @Update
    public void update(Session data);

    @Delete
    public void delete(Session data);
}
