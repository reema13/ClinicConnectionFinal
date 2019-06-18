package com.clinicconnection.clinicconnection.DataBase.Session;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class SessionViewModel extends AndroidViewModel {

    private SessionRepository repository;
    private LiveData<List<Session>> sessionlist;


    public SessionViewModel(@NonNull Application application){

        super(application);
        repository=new SessionRepository(application);
        sessionlist=repository.getSessionlist();

    }

    public LiveData<List<Session>> getPatientlist(){
        return  sessionlist;
    }

    public void insert(Session data){
        repository.insert(data);
    }

    public void update(Session data){
        repository.update(data);
    }

    public void delete(Session data){
        repository.delete(data);
    }
}
