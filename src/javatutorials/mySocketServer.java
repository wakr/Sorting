/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorials;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 *
 * @author kride
 */
public class mySocketServer implements Runnable {

    private ServerSocket serverSocket;

    public mySocketServer(int port) throws IOException {

        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(1000000);

    }

    @Override
    public void run() {
        
        clientOutputHandlerer ch = new clientOutputHandlerer();
        
        while (true) {

            try {
                System.out.println("Waiting for a client on port "
                        + serverSocket.getLocalPort() + "...");

                Socket clientSocket = serverSocket.accept();
                PrintWriter out
                        = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in
                        = new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream()));

                String inputLine, outputLine;
                outputLine = "Hello there who are you?";
                out.println(outputLine);
                
                System.out.println("Client address: "+clientSocket.getLocalAddress());
                
                while ((inputLine = in.readLine()) != null) {
                  
                    outputLine = ch.handle(inputLine);
                    out.println(outputLine);
                    if (outputLine.equals("Bye.")) {
                        System.out.println("Client released and"
                                + " port is ready to be used again...");
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

        }
    }

}
