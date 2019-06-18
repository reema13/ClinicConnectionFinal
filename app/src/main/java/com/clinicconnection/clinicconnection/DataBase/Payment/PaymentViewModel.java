package com.clinicconnection.clinicconnection.DataBase.Payment;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class PaymentViewModel extends AndroidViewModel {

    private PaymentRepository repository;
    private LiveData<List<Payment>> paymentlist;

    public PaymentViewModel(@NonNull Application application) {
        super(application);
        repository=new PaymentRepository(application);
        paymentlist=repository.getPaymentlist();
    }






    public LiveData<List<Payment>> getPaymentlist(){
        return paymentlist;
    }

    public void insert(Payment data){
        repository.insert(data);
    }

    public void update(Payment data){
        repository.update(data);
    }

    public void delete(Payment data){
        repository.delete(data);
    }
}
