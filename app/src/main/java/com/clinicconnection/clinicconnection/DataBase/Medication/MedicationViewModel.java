package com.clinicconnection.clinicconnection.DataBase.Medication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class MedicationViewModel extends AndroidViewModel {


    private MedicationRepository repository;
    private LiveData<List<Medication>> medicationlist;

    public MedicationViewModel(@NonNull Application application) {
        super(application);
        repository=new MedicationRepository(application);
        medicationlist=repository.getMedicationlist();
    }






    public LiveData<List<Medication>> getMedicationlist(){
        return  medicationlist;
    }

    public void insert(Medication data){
        repository.insert(data);
    }

    public void update(Medication data){
        repository.update(data);
    }

    public void delete(Medication data){
        repository.delete(data);
    }

}
