/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package historyserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HistoryServer {

    ServerSocket myServerSocket;
    Socket s;
    DataInputStream ps;

    public HistoryServer() {
        try {
            myServerSocket = new ServerSocket(5005);
            while (true) {
                Socket s = myServerSocket.accept();
                new historyHandler(s);
            }
        } catch (IOException ex) {
            System.out.println("IOException Detected");
        }
    }
    public static void start() {
    }

    public static void main(String args[]) {
        new HistoryServer();
    }
}
