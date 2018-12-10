package com.angel.prospective.serialization.proto;

public class PbMain {
    public static void main(String[] args) {
        ProtoBufferPractice.msgInfo.Builder builder=ProtoBufferPractice.msgInfo.newBuilder();
        builder.setGoodID(100);
        builder.setGuid("11111-23222-3333-444");
        builder.setOrder(0);
        builder.setType("ITEM");
        builder.setID(10);
        builder.setUrl("http://xxx.jpg");
        ProtoBufferPractice.msgInfo info=builder.build();
        System.out.println(info);
        byte[] result=info.toByteArray() ;
        try{
            ProtoBufferPractice.msgInfo msg = ProtoBufferPractice.msgInfo.parseFrom(result);
            System.out.println(msg);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
