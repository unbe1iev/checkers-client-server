package Communication;

import java.net.*;
import java.io.*;

public class Connection2 implements Runnable {

    private final Socket clientSocket3;
    private final Socket clientSocket4;

    private Boolean runThread = true;

    private BufferedReader input3 = null;
    private PrintWriter output3 = null;

    private BufferedReader input4 = null;
    private PrintWriter output4 = null;

    Connection2(Socket client1, Socket client2) {
        this.clientSocket3 = client1;
        this.clientSocket4 = client2;
    }

    @Override
    public void run(){
        String line;
        try {
            output3 = new PrintWriter(clientSocket3.getOutputStream());
            input3 = new BufferedReader(new InputStreamReader(clientSocket3.getInputStream()));
            output4 = new PrintWriter(clientSocket4.getOutputStream());
            input4 = new BufferedReader(new InputStreamReader(clientSocket4.getInputStream()));
        } catch(IOException e) {}

        output3.println("whiteOne");
        output3.flush();
        output4.println("blackOne");
        output4.flush();

        while(runThread){
            try{
                if (input3.ready()){
                    line = input3.readLine();
                    output4.println(line);
                    output4.flush();
                }

                if (input4.ready()){
                    line = input4.readLine();
                    output3.println(line);
                    output3.flush();
                }
            } catch(IOException e){ this.runThread = false; }
        }

        try {
            this.clientSocket3.close();
            this.clientSocket4.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {System.out.println("On closing client 3 & 4  of sockets exception.");}
    }
}