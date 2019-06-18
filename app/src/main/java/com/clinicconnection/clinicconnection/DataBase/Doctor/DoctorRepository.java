package com.clinicconnection.clinicconnection.DataBase.Doctor;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.clinicconnection.clinicconnection.DataBase.DoctorDataBase;


import java.util.List;

public class DoctorRepository {

    private DoctorDao dao;
    private LiveData<List<Doctor>> doctorlist;

    public DoctorRepository(Application application) {
        DoctorDataBase dataBase = DoctorDataBase.getInstance(application);
        this.dao = dataBase.doctorDAO();
        this.doctorlist = dao.getALL();

    }


    public LiveData<List<Doctor>> getDoctorlist(){
        return  doctorlist;
    }


    public void insert(Doctor data){
        InsertTask task = new InsertTask(dao);
        task.execute(data);

    }
    public void update(Doctor data){
        UpdateTask task = new UpdateTask(dao);
        task.execute(data);

    }
    public void delete(Doctor data){
        DeleteTask task = new DeleteTask(dao);
        task.execute(data);

    }


    // Task-----------------------------------------------------

    private static class InsertTask extends AsyncTask<Doctor,Void,Void> {
        private DoctorDao dao;
        public InsertTask(DoctorDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Doctor... doctors) {
            dao.insert(doctors[0]);
            return null;
        }
    }
    private static class UpdateTask extends AsyncTask<Doctor,Void,Void> {
        private DoctorDao dao;
        public UpdateTask(DoctorDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Doctor... doctors) {
            dao.update(doctors[0]);
            return null;
        }
    }
    private static class DeleteTask extends AsyncTask<Doctor,Void,Void> {
        private DoctorDao dao;
        public DeleteTask(DoctorDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Doctor... doctors) {
            dao.delete(doctors[0]);
            return null;
        }
    }
}

