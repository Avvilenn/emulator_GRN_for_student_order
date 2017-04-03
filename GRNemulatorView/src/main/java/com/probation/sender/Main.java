package com.probation.sender;

import com.probation.sender.gui.MainForm;
import com.probation.sender.server.SocketThread;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        MainForm froma = new MainForm();
        JFrame frame = new JFrame("GRN emulator");
        frame.setContentPane(froma.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        int port = 40245;
        System.out.println("Try to bind to port:" + port);
        try {
            ServerSocket server = new ServerSocket(port, 100);
            System.out.println("Server socket is opened");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Connection is accepted");
                new SocketThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
