package com.learning;
/*
  Created by  : Ribhu Kashyap
  Created on  : 25/06/2020
  Purpose     : Demo of consuming the proto buffer services
 */
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
