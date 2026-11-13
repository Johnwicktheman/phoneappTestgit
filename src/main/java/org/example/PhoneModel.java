package org.example;

import java.time.LocalTime;

public class PhoneModel implements ITelephone{
    private String number=""; // where we store the phone number. Like the phone's internal memory.
    private PhoneController pc;

    public PhoneModel(PhoneController pc) {
        this.pc = pc;
    }

    //dsadsad
    public void addDigit(String digit) {
        number=number+digit;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber(){
        return this.number;
    }

    @Override
    public int makeCall(String number) { // this could just use the internal number variable. But we ... have to use the interface so lets pass it as a parameter
        int duration=0;
        if(number.matches("[0-9]+")&&number.length()>7){ // only 'dial' if a valid number
            duration=3000;
            Caller caller = new Caller(pc,duration+3000,number);
            Caller caller1 = new Caller(pc,duration,number);
            new Thread(caller).start();
            new Thread(caller1).start();
        }else{
            System.out.println(LocalTime.now()+" ... Error");
        }
        return duration;
    }

    public void resetNumber() {
        number="";
    }
}
