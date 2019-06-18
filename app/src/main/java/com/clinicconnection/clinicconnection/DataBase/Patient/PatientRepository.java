package com.clinicconnection.clinicconnection.DataBase.Patient;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.clinicconnection.clinicconnection.DataBase.PatientDataBase;


import java.util.List;

public class PatientRepository {

    private PatientDao dao;
    private LiveData<List<Patient>> patientlist;


    public PatientRepository(Application application) {
        PatientDataBase dataBase = PatientDataBase.getInstance(application);
        this.dao = dataBase.patientDAO();
        this.patientlist = dao.getAll();


    }

   public LiveData<List<Patient>> getPatientlist(){
        return patientlist;
   }

    public void insert(Patient data) {

        InsertTask task = new InsertTask(dao);
        task.execute(data);

    }

    public void update(Patient data) {
        UpdateTask task = new UpdateTask(dao);
        task.execute(data);
    }

    public void delete(Patient data) {

        DeleteTask task = new DeleteTask(dao);
        task.execute(data);
    }

    //Task----------------------------------------------------------------------

    private static class InsertTask extends AsyncTask<Patient,Void,Void> {
        private PatientDao dao;

        public InsertTask(PatientDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Patient... patients) {
            dao.insert(patients[0]);
            return null;
        }

    }

    private static class UpdateTask extends AsyncTask<Patient,Void,Void> {
        private PatientDao dao;
        public UpdateTask(PatientDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Patient... patients) {
            dao.update(patients[0]);
            return null;
        }
    }

    private static class DeleteTask extends AsyncTask<Patient,Void,Void> {
        private PatientDao dao;
        public DeleteTask(PatientDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Patient... patients) {
            dao.delete(patients[0]);
            return null;
        }
    }

}
