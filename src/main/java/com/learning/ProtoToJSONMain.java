package com.learning;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;
import java.util.Arrays;

public class ProtoToJSONMain {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        builder.setId(100)          //set id field
                .setIsSimple(true)   //set is_simple
                .setName("Simple message name : Ribhu"); //set name

        builder.addSampleList(10)
                .addSampleList(11)
                .addSampleList(12);

        builder.addAllSampleList(Arrays.asList(13,14,15));

        //Print this as a JSON
        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        //Parse JSON back to proto
        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder(); //newBuilder is static method
        JsonFormat.parser().ignoringUnknownFields().merge(jsonString, builder2);
        System.out.println(builder2);

    }
}
