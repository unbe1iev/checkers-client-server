package Communication;

import Game.Game;
import Game.Field;
import Game.Pawn;

import java.net.*;
import java.io.*;
import java.awt.Color;

public class Connection1 implements Runnable {
    static Game game = new Game();

    static Field[] field = new Field[64];
    static Pawn[] whitepawn = new Pawn[12];
    static Pawn[] blackpawn = new Pawn[12];

    private final Socket clientSocket1;
    private final Socket clientSocket2;

    private Boolean runThread = true;

    private BufferedReader input1 = null;
    private PrintWriter output1 = null;

    private BufferedReader input2 = null;
    private PrintWriter output2 = null;

    Connection1(Socket client1, Socket client2) {
        this.clientSocket1 = client1;
        this.clientSocket2 = client2;

        for(int i = 0; i<64; i++){field[i] = new Field();}
        for(int i = 0; i<12; i++){whitepawn[i] = new Pawn();}
        for(int i = 0; i<12; i++){blackpawn[i] = new Pawn();}

        //Wstawienie kolorów dla pól:
        for(int i=0; i<64;){
            if (i % 16 == 0){
                for (int j=0; j<8; j++){
                    if(j % 2 == 0){field[j+i].Color = Color.WHITE;}
                    else{field[j+i].Color = Color.GRAY;}
                }
                i +=8;
            }else{
                for (int j=0; j<8; j++){
                    if(j % 2 == 0){field[j+i].Color = Color.GRAY;}
                    else{field[j+i].Color = Color.WHITE;}
                }
                i +=8;
            }
        }
        field[0].Color = Color.WHITE;

        //Wstawienie isOccupied dla pól:
        //Dla czarnych pionków

        for(int h=1;h<8;h+=2){
            field[h].isOccupied = true;
            field[h].isOccupiedByWhite = 0;
        }

        for(int h=0;h<8;h+=2){
            field[h+8].isOccupied = true;
            field[h+8].isOccupiedByWhite = 0;
        }

        for(int h=1;h<8;h+=2){
            field[h+16].isOccupied = true;
            field[h].isOccupiedByWhite = 0;
        }

        //Dla białych pionków
        for(int h=0;h<8;h+=2){
            field[h+40].isOccupied = true;
            field[h+40].isOccupiedByWhite = 1;
        }
        for(int h=1;h<8;h+=2){
            field[h+48].isOccupied = true;
            field[h+48].isOccupiedByWhite = 1;
        }
        for(int h=0;h<8;h+=2){
            field[h+56].isOccupied = true;
            field[h+56].isOccupiedByWhite = 1;
        }

        //Wstawianie domyślnych zajęć pól przez pionki:
        int defField = 0;
        //czarne
        for(int i=1;i<8;i+=2){
            blackpawn[defField].field = i;
            defField += 1;
        }
        for(int i=8;i<15;i+=2){
            blackpawn[defField].field = i;
            defField += 1;
        }
        for(int i=17;i<24;i+=2){
            blackpawn[defField].field = i;
            defField += 1;
        }

        defField = 0;
        //białe
        for(int i=40;i<47;i+=2){
            whitepawn[defField].field = i;
            defField += 1;
        }
        for(int i=49;i<56;i+=2){
            whitepawn[defField].field = i;
            defField += 1;
        }
        for(int i=56;i<63;i+=2){
            whitepawn[defField].field = i;
            defField += 1;
        }

        //Wstawienie whichRow i whichInRow - które pole w rzędzie:
        int currentField = 0;
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                field[currentField].whichRow = i;
                field[currentField].whichInRow = j;
                currentField += 1;
            }
        }
    }

    public void sendInfo(){
        output1.println(game.whiteTurn);
        output1.println(game.ifActivatedField);
        output1.println(game.activatedField);
        output1.println(game.activatedPawn);
        output1.println(game.stopSearchingFields);
        output1.println(game.ifBeatingByWhite);
        output1.println(game.ifBeatingByBlack);

        for (int y=0; y<64; y++){
            output1.println(field[y].Color);
            output1.println(field[y].whichRow);
            output1.println(field[y].whichInRow);
            output1.println(field[y].isOccupied);
            output1.println(field[y].isOccupiedByWhite);
        }

        for (int y=0; y<12; y++){
            output1.println(whitepawn[y].leveledUp);
            output1.println(whitepawn[y].field);
            output1.println(whitepawn[y].ifDeleted);
        }

        for (int y=0; y<12; y++){
            output1.println(blackpawn[y].leveledUp);
            output1.println(blackpawn[y].field);
            output1.println(blackpawn[y].ifDeleted);
        }
        output1.flush();

        output2.println(game.whiteTurn);
        output2.println(game.ifActivatedField);
        output2.println(game.activatedField);
        output2.println(game.activatedPawn);
        output2.println(game.stopSearchingFields);
        output2.println(game.ifBeatingByWhite);
        output2.println(game.ifBeatingByBlack);

        for (int y=0; y<64; y++){
            output2.println(field[y].Color);
            output2.println(field[y].whichRow);
            output2.println(field[y].whichInRow);
            output2.println(field[y].isOccupied);
            output2.println(field[y].isOccupiedByWhite);
        }

        for (int y=0; y<12; y++){
            output2.println(whitepawn[y].leveledUp);
            output2.println(whitepawn[y].field);
            output2.println(whitepawn[y].ifDeleted);
        }

        for (int y=0; y<12; y++){
            output2.println(blackpawn[y].leveledUp);
            output2.println(blackpawn[y].field);
            output2.println(blackpawn[y].ifDeleted);
        }
        output2.flush();
    }

    @Override
    public void run(){
        String line;
        try {
            output1 = new PrintWriter(clientSocket1.getOutputStream());
            input1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
            output2 = new PrintWriter(clientSocket2.getOutputStream());
            input2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));

        } catch(IOException e) {}

        sendInfo();

        while(runThread){
            try{
                if (input1.ready()){
                    for (int i=0; i<399; i++){
                        line = input1.readLine();
                        output2.println(line);

                    }
                    output2.flush();
                }

                if (input2.ready()){
                    for (int i=0; i<399; i++){
                        line = input2.readLine();
                        output1.println(line);
                    }
                    output1.flush();
                }
            } catch(IOException e){ this.runThread = false; }
        }

        try {
            this.clientSocket1.close();
            this.clientSocket2.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {System.out.println("On closing client sockets exception.");}
    }
}