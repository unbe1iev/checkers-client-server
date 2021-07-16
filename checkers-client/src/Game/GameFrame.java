package Game;

import java.net.*;
import java.io.*;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GameFrame extends javax.swing.JFrame {
    
    static Game game = new Game();
    static boolean whiteOne;
    static String message = "";
    
    //Przechowanie info: tablica klasy: pole i 2 tablice klasy pionek
    static Field[] field = new Field[64];
    static Pawn[] whitepawn = new Pawn[12];
    static Pawn[] blackpawn = new Pawn[12];
    static boolean readyToSend = false;
    static boolean whiteWon = false;
    static boolean blackWon = false;
    static int counter = 0;
    
    public GameFrame() {
        initUI();  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        for(int i = 0; i<64; i++){field[i] = new Field();}
        for(int i = 0; i<12; i++){whitepawn[i] = new Pawn();}
        for(int i = 0; i<12; i++){blackpawn[i] = new Pawn();}
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initUI() {
        add(new GamePanel());
        setTitle("Checkers");     
        setSize(488, 511);  
        ImageIcon img = new ImageIcon("icon.png");
        setIconImage(img.getImage());
        setLocationRelativeTo(null);
    }
    
    public static void main(String args[]) {
        GameFrame gameF = new GameFrame();
        int firstPort = 3000;   
        int secondPort = 3001;
        String hostname = "127.0.0.1";
        String line;
        boolean bool;
        int integ;
        Color col;
        
        //Wyswietlanie panelu i ustawianie frame'a
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GameFrame().setVisible(true);
        }); 
        
        //Chat frame
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chatFrame().setVisible(true);
            }
        });

        try {
            Socket kkSocket = new Socket(hostname, firstPort);
            Socket kk2Socket = new Socket(hostname, secondPort);
            
            PrintWriter output = new PrintWriter(kkSocket.getOutputStream());
            PrintWriter output2 = new PrintWriter(kk2Socket.getOutputStream());
            
            BufferedReader input = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
            BufferedReader input2 = new BufferedReader(new InputStreamReader(kk2Socket.getInputStream()));
                  
            while (true){
                if (!"".equals(GameFrame.message)){
                    output2.println("msg-" + GameFrame.message);
                    output2.flush();
                    GameFrame.message = "";
                }
                
                if (GameFrame.readyToSend){
                    output.println(GameFrame.game.whiteTurn);
                    output.println(GameFrame.game.ifActivatedField);
                    output.println(GameFrame.game.activatedField);
                    output.println(GameFrame.game.activatedPawn);
                    output.println(GameFrame.game.stopSearchingFields);
                    output.println(GameFrame.game.ifBeatingByWhite);
                    output.println(GameFrame.game.ifBeatingByBlack);

                    for (int y=0; y<64; y++){
                        output.println(GameFrame.field[y].Color);
                        output.println(GameFrame.field[y].whichRow);
                        output.println(GameFrame.field[y].whichInRow);
                        output.println(GameFrame.field[y].isOccupied);
                        output.println(GameFrame.field[y].isOccupiedByWhite);
                    }

                    for (int y=0; y<12; y++){
                        output.println(GameFrame.whitepawn[y].leveledUp);
                        output.println(GameFrame.whitepawn[y].field);
                        output.println(GameFrame.whitepawn[y].ifDeleted);
                    }

                    for (int y=0; y<12; y++){
                        output.println(GameFrame.blackpawn[y].leveledUp);
                        output.println(GameFrame.blackpawn[y].field);
                        output.println(GameFrame.blackpawn[y].ifDeleted);
                    }
                    output.flush();
                    readyToSend = false;
                }
                
                if (input2.ready()){
                    line = input2.readLine();
                    
                    if ("whiteOne".equals(line)){ 
                        GameFrame.whiteOne = true; 
                    } else if ("blackOne".equals(line)){ 
                        GameFrame.whiteOne = false; 
                    } else if ("msg-".equals(line.substring(0, 4))){
                        if (GameFrame.whiteOne) {chatFrame.textChat += "[black]: ";}
                        else {chatFrame.textChat += "[white]: ";}
                        
                        chatFrame.textChat += line.substring(4); 
                        chatFrame.textChat += "\n";
                        chatFrame.chatDisplay.setText(chatFrame.textChat);
                    }
                }
                
                if (input.ready()){
                    bool = Boolean.parseBoolean(input.readLine()); GameFrame.game.whiteTurn = bool;
                    bool = Boolean.parseBoolean(input.readLine()); GameFrame.game.ifActivatedField = bool;
                    integ = Integer.parseInt(input.readLine()); GameFrame.game.activatedField = integ;
                    integ = Integer.parseInt(input.readLine()); GameFrame.game.activatedPawn = integ;
                    bool = Boolean.parseBoolean(input.readLine()); GameFrame.game.stopSearchingFields = bool;
                    bool = Boolean.parseBoolean(input.readLine()); GameFrame.game.ifBeatingByWhite = bool;
                    bool = Boolean.parseBoolean(input.readLine()); GameFrame.game.ifBeatingByBlack = bool;

                    for (int y=0; y<64; y++){
                        line = input.readLine();
                        if (line.equals(Color.GRAY.toString())) GameFrame.field[y].Color = Color.GRAY;
                        if (line.equals(Color.WHITE.toString())) GameFrame.field[y].Color = Color.WHITE;
                        if (line.equals(Color.BLACK.toString())) GameFrame.field[y].Color = Color.BLACK;
                        if (line.equals(Color.RED.toString())) GameFrame.field[y].Color = Color.RED;
                        if (line.equals(Color.BLUE.toString())) GameFrame.field[y].Color = Color.BLUE;
                        if (line.equals(Color.PINK.toString())) GameFrame.field[y].Color = Color.PINK;
                        integ = Integer.parseInt(input.readLine()); GameFrame.field[y].whichRow = integ;
                        integ = Integer.parseInt(input.readLine()); GameFrame.field[y].whichInRow = integ;
                        bool = Boolean.parseBoolean(input.readLine()); GameFrame.field[y].isOccupied = bool;
                        integ = Integer.parseInt(input.readLine()); GameFrame.field[y].isOccupiedByWhite = integ;
                    }

                    for (int y=0; y<12; y++){
                        bool = Boolean.parseBoolean(input.readLine()); GameFrame.whitepawn[y].leveledUp = bool;
                        integ = Integer.parseInt(input.readLine()); GameFrame.whitepawn[y].field = integ;
                        bool = Boolean.parseBoolean(input.readLine()); GameFrame.whitepawn[y].ifDeleted = bool;
                    }

                    for (int y=0; y<12; y++){
                        bool = Boolean.parseBoolean(input.readLine()); GameFrame.blackpawn[y].leveledUp = bool;
                        integ = Integer.parseInt(input.readLine()); GameFrame.blackpawn[y].field = integ;
                        bool = Boolean.parseBoolean(input.readLine()); GameFrame.blackpawn[y].ifDeleted = bool;
                    }
                }
            }
        }
        
        catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostname + " .");
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostname + " .");
            System.exit(1);
        }
        System.out.println("Disconnected.");
    }  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}