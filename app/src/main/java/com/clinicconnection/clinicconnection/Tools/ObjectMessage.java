package com.clinicconnection.clinicconnection.Tools;



/**
 * Created by Shaban on 11/12/2015.
 */
public class ObjectMessage {

    private Object object;
    private IReceivable receiver;

    public ObjectMessage(IReceivable receiver, Object object){
        this.receiver = receiver;
        this.object = object;
    }

    public Object get_object() {
        return object;
    }

    public IReceivable get_receiver() {
        return receiver;
    }

}
