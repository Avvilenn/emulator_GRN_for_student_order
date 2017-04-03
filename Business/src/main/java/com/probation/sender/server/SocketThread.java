package com.probation.sender.server;


import com.probation.sender.checkers.CheckIfPersonLivesInSTPeter;
import com.probation.sender.domain.Person;
import com.probation.sender.parser.ParseFromXML;
import com.probation.sender.parser.ParseToXML;
import com.probation.sender.parserTypes.StudentOrder;
import com.probation.sender.parserTypes.StudentOrders;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketThread extends Thread{
    private Socket socket;
    private ParseFromXML parseFromXML;
    private Person personDomain;
    private CheckIfPersonLivesInSTPeter cheker;
    private ParseToXML parseToXML;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("method run work");

        parseFromXML = ParseFromXML.getInstance();
        cheker = CheckIfPersonLivesInSTPeter.getInstance();
        parseToXML = ParseToXML.getInstance();
        StringBuilder sb;
        String s;

        try {
            sb = new StringBuilder();
            Reader br = new InputStreamReader(socket.getInputStream());
            char[] request = new char[20];
            int count = br.read(request);
            while(count != -1) {
                sb.append(new String(request, 0, count));
                count = br.read(request);
                if(sb.toString().endsWith("</student-orders>")) {
                    break;
                }
                System.out.println(count);
            }
            System.out.println(sb.toString());
            s = sb.toString();


        StudentOrders studentOrders = null;
            InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));

            System.out.println(stream.toString());
            studentOrders = parseFromXML.readXML(stream);
            System.out.println(studentOrders.toString());
            System.out.println("4");

            //проверяет в заявках проживают ли люди в питере
            for (int i = 0; i< studentOrders.getStudentOrders().size(); i++){
                StudentOrder order = studentOrders.getStudentOrders().get(i);
                personDomain.setSurName(order.getHusband().getSurName());
                personDomain.setGivenName(order.getHusband().getGivenName());
                personDomain.setPatronymic(order.getHusband().getPatronymic());
                personDomain.setDateOfBirth(order.getHusband().getDateOfBirth());
                personDomain.setPassportNumber(order.getHusband().getPassportNumber());
                personDomain.setPassportSeria(order.getHusband().getPassportSeria());
                boolean husbantFromStPeter = cheker.check(personDomain);
                personDomain.setSurName(order.getWife().getSurName());
                personDomain.setGivenName(order.getWife().getGivenName());
                personDomain.setPatronymic(order.getWife().getPatronymic());
                personDomain.setDateOfBirth(order.getWife().getDateOfBirth());
                personDomain.setPassportNumber(order.getWife().getPassportNumber());
                personDomain.setPassportSeria(order.getWife().getPassportSeria());
                boolean wifeFromStPeter = cheker.check(personDomain);
                if (husbantFromStPeter == true && wifeFromStPeter == true) {
                    order.setGrnAnswer(true);
                } else {
                    order.setGrnAnswer(false);
                }
                System.out.println("5");
                System.out.println(order.isGrnAnswer());

        //превращает объекты классов в xml строку и отпарвляет обратно
            StringWriter sw = new StringWriter();
            parseToXML.writeToXML(studentOrders, sw);
            StringBuilder str = new StringBuilder(sw.getBuffer());
            System.out.println(str.toString());
            String w = str.toString();
            OutputStream os = socket.getOutputStream();
            os.write(w.getBytes());
            socket.close();
        }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
