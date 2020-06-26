package com.learning;
/*
  Created by  : Ribhu Kashyap
  Created on  : 25/06/2020
  Purpose     : Demo of consuming the proto buffer services
 */
import com.learning.options.OptionMessageOther;

public class OptionsMain {
    public static void main(String[] args) {
        OptionMessageOther.Builder newOther = OptionMessageOther.newBuilder();
        newOther.setHello("HELLO !!!");

        //OptionMessageOther other = OptionMessageOther.newBuilder().build();
        OptionMessageOther other = newOther.build();
        System.out.println(other.getHello());
    }
}
