package com.clinicconnection.clinicconnection.DataBase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.clinicconnection.clinicconnection.DataBase.Doctor.Doctor;
import com.clinicconnection.clinicconnection.DataBase.Medication.Medication;
import com.clinicconnection.clinicconnection.DataBase.Patient.Patient;
import com.clinicconnection.clinicconnection.DataBase.Payment.Payment;
import com.clinicconnection.clinicconnection.DataBase.Payment.PaymentDao;
import com.clinicconnection.clinicconnection.DataBase.Session.Session;


@Database(entities = {
        Payment.class, Session.class, Doctor.class, Medication.class, Patient.class

}
        , version = 1)

public abstract class PaymentDataBase extends RoomDatabase {

    private static PaymentDataBase instance;

    public abstract PaymentDao paymentDAO();


     public static synchronized PaymentDataBase getInstance(Context context){
         if(instance==null){
             instance= Room.databaseBuilder(context.getApplicationContext(),
                     PaymentDataBase.class,"payment_database")
                     .fallbackToDestructiveMigration().
                             addCallback(roomCallback).
                             build();
         }
         return instance;
     }



    //CallBack---------------------------
    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    //AsyncTask ------------------------------------------------------------
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {


        private PaymentDao paymentDAO;

        private PopulateDbAsyncTask(PaymentDataBase db) {


            paymentDAO = instance.paymentDAO();

        }


        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }
    }


}
