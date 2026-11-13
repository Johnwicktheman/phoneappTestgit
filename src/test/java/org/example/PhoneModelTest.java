package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneModelTest {

    private PhoneModel pm = new PhoneModel(new PhoneController());

    @Test
    void makeCall_validNumber() {
        int duration=pm.makeCall("0115675558933");
        assertTrue(duration>0);
    }

    @Test
    void makeCall_inValidNumber() {
        int duration=pm.makeCall("0115675");
        assertTrue(duration==0);
    }
}