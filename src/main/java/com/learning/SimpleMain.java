package com.learning;

import example.simple.Simple;
import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello Ribhu!");

        //This is the message builder which we are creating to set/get the proto fields
        SimpleMessage.Builder builder = SimpleMessage.newBuilder(); //newBuilder is static method

        //set the simple fields
        builder.setId(100)          //set id field
               .setIsSimple(true)   //set is_simple
               .setName("Simple message name : Ribhu"); //set name

        //set repeated fields
        builder.addSampleList(10)
                .addSampleList(11)
                .addSampleList(12);

        builder.addAllSampleList(Arrays.asList(13,14,15));
        builder.setSampleList(1,30);

        System.out.println(builder.toString());
        System.out.println(builder.getSampleList(5));

        SimpleMessage message = builder.build();
        System.out.println(message.getId());

        //write the protocol buffers binary to a file
        try {
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            try {
                message.writeTo(outputStream);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //send the message as byte array
        byte[] byteArray = message.toByteArray();

        try {
            System.out.println("Reading from file ...");
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            SimpleMessage msgFromFile = SimpleMessage.parseFrom(fileInputStream);
            System.out.println(msgFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

