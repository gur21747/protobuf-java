package com.learning;

import example.complex.Complex;
//import example.complex.Complex.DummyMessage;
import example.complex.Complex.*;

import java.util.Arrays;

public class complexMain {
    public static void main(String[] args) {
        DummyMessage message1 = newMessage(10, "name1");
        ComplexMessage.Builder complexMessage = ComplexMessage.newBuilder();
        //set singular message field
        complexMessage.setOneDummy(message1);
        //set repeated field
        complexMessage.addMultipleDummy(newMessage(11,"name2"));
        complexMessage.addMultipleDummy(newMessage(12,"name3"));
        complexMessage.addMultipleDummy(newMessage(13,"name4"));

        complexMessage.addAllMultipleDummy(Arrays.asList(
                newMessage(14,"name5"),
                newMessage(15,"name6"),
                newMessage(16,"name7")
        ));

        ComplexMessage message = complexMessage.build();
        System.out.println(message);

        //GET
        System.out.println(complexMessage.getOneDummy());
        System.out.println(complexMessage.getMultipleDummyList());
    }

    public static DummyMessage newMessage(Integer id, String name){
        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();
        DummyMessage message = dummyMessageBuilder.setName(name)
                .setId(id)
                .build();

        return message;
    }
}
