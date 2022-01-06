/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package historyserver;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lenovo2
 */
public class historyHandler extends Thread {
    
    DataInputStream dis;
    BufferedWriter bw;
    PrintWriter pw;
    PrintStream ps;
    static int calcs = 0;
    String fileName;
    boolean onOffFlag = true;

    public historyHandler(Socket cs) {
        try {
            calcs = calcs + 1;
            fileName = "history" + calcs + ".txt";
            File myObj = new File(fileName);

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            ps = new PrintStream(cs.getOutputStream());
            dis = new DataInputStream(cs.getInputStream());
            new FileWriter("history" + calcs + ".txt");
            FileWriter myWriter = new FileWriter("history" + calcs + ".txt", true);
            bw = new BufferedWriter(myWriter);
            pw = new PrintWriter(bw);
            ps.println(fileName);
            start();
        } catch (IOException ex) {
            System.out.println("Exception detected");
        }
    }

    @Override
    public void run() {
        while (onOffFlag) {
            String str;
            try {
                str = dis.readLine();
                System.out.println(str);
                pw.write(str + "\n");
                pw.flush();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException ex) {
                try {
                    dis.close();
                    pw.close();
                    ps.close();
                    bw.close();
                    onOffFlag = false;
                    stop();
                } catch (IOException ex1) {
                    Logger.getLogger(historyHandler.class.getName()).log(Level.SEVERE, null, ex1);
                }
                System.out.println("An error occurred.");
            }
        }
    }

}