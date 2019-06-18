package com.clinicconnection.clinicconnection.Tools;

import android.os.Bundle;


/**
 */
public class DataMessage {

    private Bundle bundle;
    private IReceivable receiver;

    public DataMessage(IReceivable receiver){
        bundle = new Bundle();
        this.receiver = receiver;
    }

    public Bundle get_extra(){
        return  bundle;
    }

    public IReceivable get_receiver() {
        return receiver;
    }

}
