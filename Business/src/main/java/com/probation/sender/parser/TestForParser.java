package com.probation.sender.parser;

import com.probation.sender.parserTypes.StudentOrders;

import java.io.*;

public class TestForParser {
    public static void main(String[] args) throws Exception{
        ParseFromXML fromXML = ParseFromXML.getInstance();
        ParseToXML toXML = ParseToXML.getInstance();
        System.out.println(fromXML.getClass().getCanonicalName());
        File file = new File("D:\\idea\\SenderOne\\Business\\src\\main\\java\\com\\probation\\sender\\parser\\student_orders.xml");
        TestForParser test = new TestForParser();
        System.out.println(test.getClass().getCanonicalName());
       // com/probation/sender/parser/student_orders.xml
        InputStream is = new FileInputStream(file);

        StudentOrders order = fromXML.readXML(is);
        System.out.println(order.toString());

        StringWriter wr = new StringWriter();

        toXML.writeToXML(order, wr);
        StringBuilder str = new StringBuilder(wr.getBuffer());
        System.out.println(str);
    }
}
