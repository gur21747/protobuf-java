package com.learning;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;
public class EnumMain {
    public static void main(String[] args) {
        EnumMessage.Builder builder = EnumMessage.newBuilder();
        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.WEDNESDAY);

        EnumMessage message = builder.build();
        System.out.println(message);
    }
}
