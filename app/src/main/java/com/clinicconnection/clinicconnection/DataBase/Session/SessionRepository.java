package com.clinicconnection.clinicconnection.DataBase.Session;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.clinicconnection.clinicconnection.DataBase.SessionDataBase;


import java.util.List;

public class SessionRepository {

    private SessionDao dao;
    private LiveData<List<Session>> sessionlist;


    public SessionRepository(Application application) {
        SessionDataBase dataBase = SessionDataBase.getInstance(application);
        this.dao = dataBase.sessionDAO();
        this.sessionlist = dao.getALL();


    }

    public LiveData<List<Session>> getSessionlist() {
        return sessionlist;
    }

    public void insert(Session data) {

        InsertTask task = new InsertTask(dao);
        task.execute(data);

    }

    public void update(Session data) {
        UpdateTask task = new UpdateTask(dao);
        task.execute(data);
    }

    public void delete(Session data) {

        DeleteTask task = new DeleteTask(dao);
        task.execute(data);
    }

    //Task----------------------------------------------------------------------

    private static class InsertTask extends AsyncTask<Session,Void,Void> {
        private SessionDao dao;

        public InsertTask(SessionDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Session... sessions) {
            dao.insert(sessions[0]);
            return null;
        }

    }

    private static class UpdateTask extends AsyncTask<Session,Void,Void> {
        private SessionDao dao;
        public UpdateTask(SessionDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Session... sessions) {
            dao.update(sessions[0]);
            return null;
        }
    }

    private static class DeleteTask extends AsyncTask<Session,Void,Void> {
        private SessionDao dao;
        public DeleteTask(SessionDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Session... sessions) {
            dao.delete(sessions[0]);
            return null;
        }
    }


}
