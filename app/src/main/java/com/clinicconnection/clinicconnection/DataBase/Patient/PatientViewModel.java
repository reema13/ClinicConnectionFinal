package com.clinicconnection.clinicconnection.DataBase.Patient;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {

    private PatientRepository repository;
    private LiveData<List<Patient>> patientlist;


    public PatientViewModel(@NonNull Application application){

        super(application);
        repository=new PatientRepository(application);
        patientlist=repository.getPatientlist();
        
    }

    public LiveData<List<Patient>> getPatientlist(){
        return  patientlist;
    }

    public void insert(Patient data){
        repository.insert(data);
    }

    public void update(Patient data){
        repository.update(data);
    }

    public void delete(Patient data){
        repository.delete(data);
    }
}
