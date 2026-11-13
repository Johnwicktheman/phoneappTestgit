package org.example;

import javafx.concurrent.Task;

import java.time.LocalTime;

public class Caller extends Task {

    private String number;
    private long duration;
    private PhoneController pc;

    public Caller(PhoneController pc, long duration, String number) {

        this.pc = pc;
        this.number = number;
        this.duration = duration;
    }

    //sdfsadsadas
    //dsadsadsa
    @Override
    protected Object call() throws Exception {
        System.out.println(LocalTime.now()+" ... Dialling "+number);
        pc.setOnCall();
//        duration=3000; // could make this random
        try {
            Thread.sleep(duration); // note how this hangs the interface! how can we fix that?
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // faking phone call time.
        System.out.println(LocalTime.now()+" ... Hanging up");
        pc.setOffCall();

        return null;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
