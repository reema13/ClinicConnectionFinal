package com.clinicconnection.clinicconnection.DataBase.Doctor;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class DoctorViewModel extends AndroidViewModel {

    private DoctorRepository repository;
    private LiveData<List<Doctor>> doctorlist;

    public DoctorViewModel(@NonNull Application application) {
        super(application);
        repository=new DoctorRepository(application);
        doctorlist=repository.getDoctorlist();
    }






    public LiveData<List<Doctor>> getDoctorList(){
        return  doctorlist;
    }

    public void insert(Doctor data){
        repository.insert(data);
    }

    public void update(Doctor data){
        repository.update(data);
    }

    public void delete(Doctor data){
        repository.delete(data);
    }



}

