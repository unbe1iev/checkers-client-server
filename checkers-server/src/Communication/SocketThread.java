package Communication;

import java.net.*;
import java.io.*;

public class SocketThread {
    public static void main(String[] args){
        int firstPort = 3000;
        int secondPort = 3001;
        ServerSocket serverSocket1 = null;
        ServerSocket serverSocket2 = null;

        try {
            serverSocket1 = new ServerSocket(firstPort);
            serverSocket2 = new ServerSocket(secondPort);
        } catch (IOException e) {
            System.out.println("serverSocket1 or serverSocket2 exception.");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("Searching 2 clients...");
        while(true){
            try{
                if (serverSocket1 != null){
                    Socket clientSocket1 = serverSocket1.accept();
                    System.out.println("Client1 connected");
                    Socket clientSocket2 = serverSocket1.accept();
                    System.out.println("Client2 connected");

                    Socket clientSocket3 = serverSocket2.accept();
                    Socket clientSocket4 = serverSocket2.accept();


                    Connection1 clientsConnection1 = new Connection1(clientSocket1, clientSocket2);
                    Connection2 clientsConnection2 = new Connection2(clientSocket3, clientSocket4);

                    Thread gameThread = new Thread(clientsConnection1);
                    gameThread.start();

                    Thread gameThread2 = new Thread(clientsConnection2);
                    gameThread2.start();
                }
            } catch(IOException e){
                System.out.println("Listening exception.");
                System.out.println(e.getMessage());
            }
        }
    }
}
