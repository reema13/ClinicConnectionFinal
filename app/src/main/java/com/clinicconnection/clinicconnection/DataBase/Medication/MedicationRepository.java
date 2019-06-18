package com.clinicconnection.clinicconnection.DataBase.Medication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.clinicconnection.clinicconnection.DataBase.MedicationDataBase;


import java.util.List;

public class MedicationRepository {

    private MedicationDao dao;
    private LiveData<List<Medication>> medicationlist;


    public MedicationRepository(Application application) {
        MedicationDataBase dataBase = MedicationDataBase.getInstance(application);
        this.dao = dataBase.medicationDAO();
        this.medicationlist = dao.getALL();

    }

    public LiveData<List<Medication>> getMedicationlist(){
        return  medicationlist;
    }


    public void insert(Medication data){
        InsertTask task = new InsertTask(dao);
        task.execute(data);

    }
    public void update(Medication data){
        UpdateTask task = new UpdateTask(dao);
        task.execute(data);

    }
    public void delete(Medication data){
        DeleteTask task = new DeleteTask(dao);
        task.execute(data);

    }


    // Task-----------------------------------------------------

    private static class InsertTask extends AsyncTask<Medication,Void,Void> {
        private MedicationDao dao;
        public InsertTask(MedicationDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Medication... medications) {
            dao.insert(medications[0]);
            return null;
        }
    }
    private static class UpdateTask extends AsyncTask<Medication,Void,Void> {
        private MedicationDao dao;
        public UpdateTask(MedicationDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Medication... medications) {
            dao.update(medications[0]);
            return null;
        }
    }
    private static class DeleteTask extends AsyncTask<Medication,Void,Void> {
        private MedicationDao dao;
        public DeleteTask(MedicationDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Medication... medications) {
            dao.delete(medications[0]);
            return null;
        }
    }


}
