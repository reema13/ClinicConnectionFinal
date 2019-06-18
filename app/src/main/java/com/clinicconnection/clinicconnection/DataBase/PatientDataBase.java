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
import com.clinicconnection.clinicconnection.DataBase.Patient.PatientDao;
import com.clinicconnection.clinicconnection.DataBase.Payment.Payment;
import com.clinicconnection.clinicconnection.DataBase.Session.Session;


@Database(entities = {
        Patient.class, Doctor.class, Medication.class, Payment.class, Session.class

}
        ,version = 1)

public abstract class PatientDataBase extends RoomDatabase {

    private static PatientDataBase instance;
    public abstract PatientDao patientDAO();


    public static synchronized PatientDataBase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    PatientDataBase.class,"patient_database")
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
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {


        private PatientDao patientDAO;

        private PopulateDbAsyncTask(PatientDataBase db){


            patientDAO=instance.patientDAO();

        }



        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }
    }

}


