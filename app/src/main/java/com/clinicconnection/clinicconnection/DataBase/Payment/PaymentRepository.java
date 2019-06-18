package com.clinicconnection.clinicconnection.DataBase.Payment;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.clinicconnection.clinicconnection.DataBase.PaymentDataBase;


import java.util.List;

public class PaymentRepository {

    private PaymentDao dao;
    private LiveData<List<Payment>> paymentlist;

    public PaymentRepository(Application application) {
        PaymentDataBase dataBase = PaymentDataBase.getInstance(application);
        this.dao = dataBase.paymentDAO();
        this.paymentlist = dao.getALL();

    }


    public LiveData<List<Payment>> getPaymentlist(){
        return  paymentlist;
    }


    public void insert(Payment data){
        InsertTask task = new InsertTask(dao);
        task.execute(data);

    }
    public void update(Payment data){
        UpdateTask task = new UpdateTask(dao);
        task.execute(data);

    }
    public void delete(Payment data){
        DeleteTask task = new DeleteTask(dao);
        task.execute(data);

    }


    // Task-----------------------------------------------------

    private static class InsertTask extends AsyncTask<Payment,Void,Void> {
        private PaymentDao dao;
        public InsertTask(PaymentDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Payment... payments) {
            dao.insert(payments[0]);
            return null;
        }
    }
    private static class UpdateTask extends AsyncTask<Payment,Void,Void> {
        private PaymentDao dao;
        public UpdateTask(PaymentDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Payment... payments) {
            dao.update(payments[0]);
            return null;
        }
    }
    private static class DeleteTask extends AsyncTask<Payment,Void,Void> {
        private PaymentDao dao;
        public DeleteTask(PaymentDao dao){
            this.dao = dao;

        }

        @Override
        protected Void doInBackground(Payment... payments) {
            dao.delete(payments[0]);
            return null;
        }
    }
}
