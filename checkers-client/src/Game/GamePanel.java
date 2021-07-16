package Game;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GamePanel extends javax.swing.JPanel implements ActionListener{
    
    private BufferedImage image1=null;
    private BufferedImage image2=null;
    private BufferedImage image3=null;
    private BufferedImage image4=null;
    private BufferedImage winImage = null;
    private BufferedImage loseImage = null;
    Timer timer = new Timer(100, this);
    boolean pauseSearching = false;
    boolean ifBreakLoops = false;
    
    //skalator, wysrodkowanie ...
    int scale, toCenter, actWidth, actHeight;
    
    public GamePanel() {
        initComponents();
        timer.start();
        
        //wczytanie grafiki z dysku:
        File blackPawnFile = new File("pawnblack.png");
        File whitePawnFile = new File("pawnwhite.png");
        File crownblackPawnFile = new File("crownpawnblack.png");
        File crownwhitePawnFile = new File("crownpawnwhite.png");
        File winFile = new File("win.png");
        File loseFile = new File("lose.png");
        
	try {
            image1 = ImageIO.read(blackPawnFile);
            image2 = ImageIO.read(whitePawnFile);
            image3 = ImageIO.read(crownblackPawnFile);
            image4 = ImageIO.read(crownwhitePawnFile);
            winImage = ImageIO.read(winFile);
            loseImage = ImageIO.read(loseFile);
	} catch (IOException e) {
            System.err.println("Error - file not found!");
	}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int xPointed;
        int yPointed;
        int fieldFound;
        xPointed = evt.getPoint().x;
        yPointed = evt.getPoint().y;
        
        fieldFound = checkFieldAtClick(xPointed, yPointed);
        
        if (fieldFound != -1){
            if ((GameFrame.field[fieldFound].Color == Color.GRAY) || (GameFrame.field[fieldFound].Color == Color.PINK) || (GameFrame.field[fieldFound].Color == Color.RED)){
                if (GameFrame.game.whiteTurn){ //White side
                    if (GameFrame.whiteOne){
                    if (!GameFrame.game.ifBeatingByWhite){
                        if (GameFrame.game.ifActivatedField){
                            for (int i = 0; i<12; i++){
                                if (GameFrame.whitepawn[i].field == fieldFound){
                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                    GameFrame.field[fieldFound].Color = Color.BLUE;
                                    GameFrame.game.activatedField = fieldFound;
                                    GameFrame.game.activatedPawn = i;
                                    for (int j=0; j<64; j++){
                                            if(GameFrame.field[j].Color == Color.PINK){
                                                GameFrame.field[j].Color = Color.GRAY;
                                            }
                                    }

                                    if (GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp){
                                        boolean przerwij = false;
                                        //1.lewo-gora
                                        for (int k=1; k<8; k++){
                                            if (przerwij == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        przerwij = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        przerwij = false;
                                        //2.lewo-dol
                                        for (int k=1; k<8; k++){
                                            if (przerwij == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        przerwij = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        przerwij = false;
                                        //3.prawo-gora
                                        for (int k=1; k<8; k++){
                                            if (przerwij == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        przerwij = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        przerwij = false;
                                        //4.prawo-dol
                                        for (int k=1; k<8; k++){
                                            if (przerwij == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        przerwij = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                    }else{
                                        for (int j=0;j<64;j++){
                                            if ((GameFrame.field[j].whichRow == (GameFrame.field[GameFrame.game.activatedField].whichRow-1)) && 
                                               ((GameFrame.field[j].whichInRow == (GameFrame.field[GameFrame.game.activatedField].whichInRow-1)) || 
                                               (GameFrame.field[j].whichInRow == (GameFrame.field[GameFrame.game.activatedField].whichInRow+1))) && !GameFrame.field[j].isOccupied){
                                                GameFrame.field[j].Color = Color.PINK;
                                            }
                                        }
                                    }
                                }
                            }
                            
                            if (!GameFrame.field[fieldFound].isOccupied){
                                if (GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp){
                                    GameFrame.game.stopSearchingFields = false;

                                        //1.lewo-gora
                                        if (GameFrame.game.stopSearchingFields == false){
                                            for (int k=1; k<8; k++){
                                                if (GameFrame.game.stopSearchingFields == true) break;
                                                if ((GameFrame.field[fieldFound].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[fieldFound].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k) &&
                                                   (GameFrame.field[fieldFound].Color == Color.PINK)){
                                                    GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                    GameFrame.field[fieldFound].isOccupied = true;
                                                    GameFrame.field[fieldFound].isOccupiedByWhite = 1;
                                                    GameFrame.game.activatedField = -1;
                                                    GameFrame.game.ifActivatedField = false;
                                                    for (int i=0; i<64; i++){
                                                        if(GameFrame.field[i].Color == Color.PINK){
                                                            GameFrame.field[i].Color = Color.GRAY;
                                                        }
                                                    } 
                                                    GameFrame.game.stopSearchingFields = true;
                                                }
                                            }
                                        }

                                        //2.lewo-dol
                                        if (GameFrame.game.stopSearchingFields == false){
                                            for (int k=1; k<8; k++){
                                                if (GameFrame.game.stopSearchingFields == true) break;
                                                if ((GameFrame.field[fieldFound].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[fieldFound].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k) &&
                                                   (GameFrame.field[fieldFound].Color == Color.PINK)){
                                                    GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                    GameFrame.field[fieldFound].isOccupied = true;
                                                    GameFrame.field[fieldFound].isOccupiedByWhite = 1;
                                                    GameFrame.game.activatedField = -1;
                                                    GameFrame.game.ifActivatedField = false;
                                                    for (int i=0; i<64; i++){
                                                        if(GameFrame.field[i].Color == Color.PINK){
                                                            GameFrame.field[i].Color = Color.GRAY;
                                                        }
                                                    }
                                                    GameFrame.game.stopSearchingFields = true;
                                                }
                                            }
                                        }

                                        //3.prawo-gora
                                        if (GameFrame.game.stopSearchingFields == false){
                                            for (int k=1; k<8; k++){
                                                if (GameFrame.game.stopSearchingFields == true) break;
                                                if ((GameFrame.field[fieldFound].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[fieldFound].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k) &&
                                                   (GameFrame.field[fieldFound].Color == Color.PINK)){
                                                    GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                    GameFrame.field[fieldFound].isOccupied = true;
                                                    GameFrame.field[fieldFound].isOccupiedByWhite = 1;
                                                    GameFrame.game.activatedField = -1;
                                                    GameFrame.game.ifActivatedField = false;
                                                    for (int i=0; i<64; i++){
                                                        if(GameFrame.field[i].Color == Color.PINK){
                                                            GameFrame.field[i].Color = Color.GRAY;
                                                        }
                                                    }
                                                    GameFrame.game.stopSearchingFields = true;
                                                }
                                            }
                                        }

                                        //4.prawo-dol
                                        if (GameFrame.game.stopSearchingFields == false){
                                            for (int k=1; k<8; k++){
                                                if (GameFrame.game.stopSearchingFields == true) break;
                                                if ((GameFrame.field[fieldFound].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[fieldFound].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k) &&
                                                   (GameFrame.field[fieldFound].Color == Color.PINK)){
                                                    GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;                       
                                                    GameFrame.field[fieldFound].isOccupied = true;
                                                    GameFrame.field[fieldFound].isOccupiedByWhite = 1;
                                                    GameFrame.game.activatedField = -1;
                                                    GameFrame.game.ifActivatedField = false;
                                                    for (int i=0; i<64; i++){
                                                        if(GameFrame.field[i].Color == Color.PINK){
                                                            GameFrame.field[i].Color = Color.GRAY;
                                                        }
                                                    }
                                                    GameFrame.game.stopSearchingFields = true;
                                                }
                                            }
                                        }
                                }else{
                                    if (GameFrame.field[fieldFound].Color == Color.PINK){
                                        GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                        GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                        GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                        GameFrame.field[fieldFound].isOccupied = true;
                                        GameFrame.field[fieldFound].isOccupiedByWhite = 1;
                                        GameFrame.game.activatedField = -1;
                                        GameFrame.game.ifActivatedField = false;
                                        for (int i=0; i<64; i++){
                                            if(GameFrame.field[i].Color == Color.PINK){
                                                GameFrame.field[i].Color = Color.GRAY;
                                            }
                                        }
                                        //Check if the pawn will be leveled up:
                                        if (GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow == 0){
                                            GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp = true;
                                        }
                                        GameFrame.game.activatedPawn = -1;
                                    }
                                }
                                
                                checkIfBeatingByBlack();
                                GameFrame.game.whiteTurn = false;
                            }
                        }else{
                            for (int i = 0; i<12; i++){
                                if (GameFrame.whitepawn[i].field == fieldFound){
                                    GameFrame.field[fieldFound].Color = Color.BLUE;
                                    GameFrame.game.ifActivatedField = true;
                                    GameFrame.game.activatedField = fieldFound;
                                    GameFrame.game.activatedPawn = i;
                                    
                                    if (GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp){
                                        GameFrame.game.stopSearchingFields = false;
                                        //1.lewo-gora
                                        for (int k=1; k<8; k++){
                                            if (GameFrame.game.stopSearchingFields == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        GameFrame.game.stopSearchingFields = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        GameFrame.game.stopSearchingFields = false;
                                        //2.lewo-dol
                                        for (int k=1; k<8; k++){
                                            if (GameFrame.game.stopSearchingFields == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        GameFrame.game.stopSearchingFields = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        GameFrame.game.stopSearchingFields = false;
                                        //3.prawo-gora
                                        for (int k=1; k<8; k++){
                                            if (GameFrame.game.stopSearchingFields == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        GameFrame.game.stopSearchingFields = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        GameFrame.game.stopSearchingFields = false;
                                        //4.prawo-dol
                                        for (int k=1; k<8; k++){
                                            if (GameFrame.game.stopSearchingFields == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        GameFrame.game.stopSearchingFields = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                    }else{
                                        for (int j=0;j<64;j++){
                                            if ((GameFrame.field[j].whichRow == (GameFrame.field[GameFrame.game.activatedField].whichRow-1)) && 
                                               ((GameFrame.field[j].whichInRow == (GameFrame.field[GameFrame.game.activatedField].whichInRow-1)) || 
                                               (GameFrame.field[j].whichInRow == (GameFrame.field[GameFrame.game.activatedField].whichInRow+1))) && !GameFrame.field[j].isOccupied){
                                                GameFrame.field[j].Color = Color.PINK;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if (GameFrame.game.ifActivatedField){
                            for (int i=0; i<12; i++){
                                if (GameFrame.whitepawn[i].field == fieldFound){
                                    if (GameFrame.whitepawn[i].leveledUp){ //dla bicia damkami
                                        for (int j=0; j<64; j++){
                                            for (int k=1; k<9; k++){
                                                if (GameFrame.field[j].isOccupiedByWhite != 1){

                                                    //1. zaznaczenie: lewo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }
                                                                        if (pauseSearching == false){
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                        GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                        GameFrame.game.activatedPawn = i;
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}
                                                    
                                                    pauseSearching = false;
                                                    
                                                    //2. zaznaczenie: lewo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }
                                                                        if (pauseSearching == false){
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                        GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                        GameFrame.game.activatedPawn = i;
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}
                                                    
                                                    pauseSearching = false;
                                                    
                                                    //3. zaznaczenie: prawo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }
                                                                        
                                                                        if (pauseSearching == false){
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                        GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                        GameFrame.game.activatedPawn = i;
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}  

                                                    pauseSearching = false;
                                                    
                                                    //4. zaznaczenie: prawo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }
                                                                        
                                                                        if (pauseSearching == false){
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                        GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                        GameFrame.game.activatedPawn = i;
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){} 
                                                    pauseSearching = false;
                                                }
                                            }
                                        }
                                    }else{
                                        for (int j=0; j<64; j++){
                                            if (GameFrame.field[j].isOccupiedByWhite != 1){
                                                //1. zaznaczenie: lewo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                    GameFrame.game.activatedPawn = i;
                                                                    GameFrame.game.ifActivatedField = true;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //2. zaznaczenie: lewo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                    GameFrame.game.activatedPawn = i;
                                                                    GameFrame.game.ifActivatedField = true;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //3. zaznaczenie: prawo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                    GameFrame.game.activatedPawn = i;
                                                                    GameFrame.game.ifActivatedField = true;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //4. zaznaczenie: prawo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                    GameFrame.game.activatedPawn = i;
                                                                    GameFrame.game.ifActivatedField = true;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}
                                            }
                                        }
                                    }
                                }
                            }
                            
                            //Pole zaktywowane i bedzie wykonywane bicie pionka:
                            if (!GameFrame.field[fieldFound].isOccupied){
                                if (GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp){
                                    for (int j=0; j<64; j++){
                                            for (int k=1; k<9; k++){
                                                    //1. bicie: lewo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }
                                                                        
                                                                        if (pauseSearching == false){
                                                                            if (l == fieldFound){
                                                                                //Niszczenie pionka zbitego:
                                                                                GameFrame.field[j].isOccupied = false;
                                                                                GameFrame.field[j].isOccupiedByWhite = -1;

                                                                                for (int m=0; m<12; m++){
                                                                                    if (GameFrame.blackpawn[m].field == j){
                                                                                        GameFrame.blackpawn[m].ifDeleted = true;
                                                                                        GameFrame.blackpawn[m].field = -1;
                                                                                    }
                                                                                }

                                                                                GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                                GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                                GameFrame.field[l].Color = Color.GRAY;
                                                                                GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                                GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                                GameFrame.field[l].isOccupied = true;
                                                                                GameFrame.field[l].isOccupiedByWhite = 1;
                                                                                GameFrame.game.activatedField = -1;
                                                                                GameFrame.game.activatedPawn = -1;
                                                                                GameFrame.game.ifActivatedField = false;
                                                                            }
                                                                            
                                                                        try{
                                                                            for (int t=1; t<=6; t++){
                                                                                for (int y=0; y<64; y++){
                                                                                    if ((GameFrame.field[y].whichRow == GameFrame.field[l].whichRow-t) &&
                                                                                        (GameFrame.field[y].whichInRow == GameFrame.field[l].whichInRow-t) &&
                                                                                        (!GameFrame.field[y].isOccupied) && (y == fieldFound)){
                                                                                        
                                                                                            //Niszczenie pionka zbitego:
                                                                                            GameFrame.field[j].isOccupied = false;
                                                                                            GameFrame.field[j].isOccupiedByWhite = -1;

                                                                                            for (int m=0; m<12; m++){
                                                                                                if (GameFrame.blackpawn[m].field == j){
                                                                                                    GameFrame.blackpawn[m].ifDeleted = true;
                                                                                                    GameFrame.blackpawn[m].field = -1;
                                                                                                }
                                                                                            }

                                                                                            GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                                            GameFrame.field[y].Color = Color.GRAY;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                                            GameFrame.field[y].isOccupied = true;
                                                                                            GameFrame.field[y].isOccupiedByWhite = 1;
                                                                                            GameFrame.game.activatedField = -1;
                                                                                            GameFrame.game.activatedPawn = -1;
                                                                                            GameFrame.game.ifActivatedField = false;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch(Exception e){}
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}
                                                    
                                                    pauseSearching = false;
                                                    
                                                    //2. bicie: lewo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (l == fieldFound){
                                                                            //Niszczenie pionka zbitego:
                                                                            GameFrame.field[j].isOccupied = false;
                                                                            GameFrame.field[j].isOccupiedByWhite = -1;
                                                                            
                                                                            for (int m=0; m<12; m++){
                                                                                if (GameFrame.blackpawn[m].field == j){
                                                                                    GameFrame.blackpawn[m].ifDeleted = true;
                                                                                    GameFrame.blackpawn[m].field = -1;
                                                                                }
                                                                            }

                                                                            GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                            GameFrame.field[l].Color = Color.GRAY;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                            GameFrame.field[l].isOccupied = true;
                                                                            GameFrame.field[l].isOccupiedByWhite = 1;
                                                                            GameFrame.game.activatedField = -1;
                                                                            GameFrame.game.activatedPawn = -1;
                                                                            GameFrame.game.ifActivatedField = false;
                                                                        }
                                                                        
                                                                        try{
                                                                            for (int t=1; t<=6; t++){
                                                                                for (int y=0; y<64; y++){
                                                                                    if ((GameFrame.field[y].whichRow == GameFrame.field[l].whichRow+t) &&
                                                                                        (GameFrame.field[y].whichInRow == GameFrame.field[l].whichInRow-t) &&
                                                                                        (!GameFrame.field[y].isOccupied) && (y == fieldFound)){
                                                                                        
                                                                                            //Niszczenie pionka zbitego:
                                                                                            GameFrame.field[j].isOccupied = false;
                                                                                            GameFrame.field[j].isOccupiedByWhite = -1;

                                                                                            for (int m=0; m<12; m++){
                                                                                                if (GameFrame.blackpawn[m].field == j){
                                                                                                    GameFrame.blackpawn[m].ifDeleted = true;
                                                                                                    GameFrame.blackpawn[m].field = -1;
                                                                                                }
                                                                                            }

                                                                                            GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                                            GameFrame.field[y].Color = Color.GRAY;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                                            GameFrame.field[y].isOccupied = true;
                                                                                            GameFrame.field[y].isOccupiedByWhite = 1;
                                                                                            GameFrame.game.activatedField = -1;
                                                                                            GameFrame.game.activatedPawn = -1;
                                                                                            GameFrame.game.ifActivatedField = false;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch(Exception e){}
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}
                                                    
                                                    pauseSearching = false;
                                                    
                                                    //3. bicie: prawo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (l == fieldFound){
                                                                            //Niszczenie pionka zbitego:
                                                                            GameFrame.field[j].isOccupied = false;
                                                                            GameFrame.field[j].isOccupiedByWhite = -1;
                                                                            
                                                                            for (int m=0; m<12; m++){
                                                                                if (GameFrame.blackpawn[m].field == j){
                                                                                    GameFrame.blackpawn[m].ifDeleted = true;
                                                                                    GameFrame.blackpawn[m].field = -1;
                                                                                }
                                                                            }

                                                                            GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                            GameFrame.field[l].Color = Color.GRAY;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                            GameFrame.field[l].isOccupied = true;
                                                                            GameFrame.field[l].isOccupiedByWhite = 1;
                                                                            GameFrame.game.activatedField = -1;
                                                                            GameFrame.game.activatedPawn = -1;
                                                                            GameFrame.game.ifActivatedField = false;
                                                                        }
                                                                        
                                                                        try{
                                                                            for (int t=1; t<=6; t++){
                                                                                for (int y=0; y<64; y++){
                                                                                    if ((GameFrame.field[y].whichRow == GameFrame.field[l].whichRow-t) &&
                                                                                        (GameFrame.field[y].whichInRow == GameFrame.field[l].whichInRow+t) &&
                                                                                        (!GameFrame.field[y].isOccupied) && (y == fieldFound)){
                                                                                        
                                                                                            //Niszczenie pionka zbitego:
                                                                                            GameFrame.field[j].isOccupied = false;
                                                                                            GameFrame.field[j].isOccupiedByWhite = -1;

                                                                                            for (int m=0; m<12; m++){
                                                                                                if (GameFrame.blackpawn[m].field == j){
                                                                                                    GameFrame.blackpawn[m].ifDeleted = true;
                                                                                                    GameFrame.blackpawn[m].field = -1;
                                                                                                }
                                                                                            }

                                                                                            GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                                            GameFrame.field[y].Color = Color.GRAY;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                                            GameFrame.field[y].isOccupied = true;
                                                                                            GameFrame.field[y].isOccupiedByWhite = 1;
                                                                                            GameFrame.game.activatedField = -1;
                                                                                            GameFrame.game.activatedPawn = -1;
                                                                                            GameFrame.game.ifActivatedField = false;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch(Exception e){}
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}  

                                                    pauseSearching = false;
                                                    
                                                    //4. bicie: prawo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                         if (pauseSearching == false){
                                                                         if (l == fieldFound){
                                                                            //Niszczenie pionka zbitego:
                                                                            GameFrame.field[j].isOccupied = false;
                                                                            GameFrame.field[j].isOccupiedByWhite = -1;
                                                                            
                                                                            for (int m=0; m<12; m++){
                                                                                if (GameFrame.blackpawn[m].field == j){
                                                                                    GameFrame.blackpawn[m].ifDeleted = true;
                                                                                    GameFrame.blackpawn[m].field = -1;
                                                                                }
                                                                            }

                                                                            GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                            GameFrame.field[l].Color = Color.GRAY;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                            GameFrame.field[l].isOccupied = true;
                                                                            GameFrame.field[l].isOccupiedByWhite = 1;
                                                                            GameFrame.game.activatedField = -1;
                                                                            GameFrame.game.activatedPawn = -1;
                                                                            GameFrame.game.ifActivatedField = false;
                                                                        }
                                                                         
                                                                        try{
                                                                            for (int t=1; t<=6; t++){
                                                                                for (int y=0; y<64; y++){
                                                                                    if ((GameFrame.field[y].whichRow == GameFrame.field[l].whichRow+t) &&
                                                                                        (GameFrame.field[y].whichInRow == GameFrame.field[l].whichInRow+t) &&
                                                                                        (!GameFrame.field[y].isOccupied) && (y == fieldFound)){
                                                                                        
                                                                                            //Niszczenie pionka zbitego:
                                                                                            GameFrame.field[j].isOccupied = false;
                                                                                            GameFrame.field[j].isOccupiedByWhite = -1;

                                                                                            for (int m=0; m<12; m++){
                                                                                                if (GameFrame.blackpawn[m].field == j){
                                                                                                    GameFrame.blackpawn[m].ifDeleted = true;
                                                                                                    GameFrame.blackpawn[m].field = -1;
                                                                                                }
                                                                                            }

                                                                                            GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                                            GameFrame.field[y].Color = Color.GRAY;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                                            GameFrame.field[y].isOccupied = true;
                                                                                            GameFrame.field[y].isOccupiedByWhite = 1;
                                                                                            GameFrame.game.activatedField = -1;
                                                                                            GameFrame.game.activatedPawn = -1;
                                                                                            GameFrame.game.ifActivatedField = false;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch(Exception e){}
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}  
                                                    pauseSearching = false;
                                            }
                                    }
                                    
                                    checkIfBeatingByWhite();
                                    if (!GameFrame.game.ifBeatingByWhite){
                                        GameFrame.game.whiteTurn = false;
                                        checkIfBeatingByBlack();
                                    }
                                    
                                }else{
                                    for (int j=0; j<64; j++){
                                        if (GameFrame.field[j].isOccupiedByWhite != 1){
                                            //1. bicie: lewo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow-1) &&
                                                        (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichInRow-1) &&
                                                        (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                    for (int l=0; l<64; l++){
                                                        try{
                                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                (!GameFrame.field[l].isOccupied)){
                                                                
                                                                if (l == fieldFound){
                                                                    //Niszczenie pionka zbitego:
                                                                    GameFrame.field[j].isOccupied = false;
                                                                    GameFrame.field[j].isOccupiedByWhite = -1;
                                                                    for (int m=0; m<12; m++){
                                                                        if (GameFrame.blackpawn[m].field == j){
                                                                            GameFrame.blackpawn[m].ifDeleted = true;
                                                                            GameFrame.blackpawn[m].field = -1;
                                                                        }
                                                                    }

                                                                    GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.field[l].Color = Color.GRAY;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                    GameFrame.field[l].isOccupied = true;
                                                                    GameFrame.field[l].isOccupiedByWhite = 1;
                                                                    
                                                                    //Check if the pawn will be leveled up:
                                                                    if (GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow == 0){
                                                                        GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp = true;
                                                                    }
                                                                    
                                                                    GameFrame.game.activatedField = -1;
                                                                    GameFrame.game.activatedPawn = -1;
                                                                    GameFrame.game.ifActivatedField = false;
                                                             
                                                                }
                                                            }
                                                        } catch(Exception e){}
                                                    }
                                                }
                                            } catch(Exception e){}
                                                
                                            //2. bicie: lewo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow+1) &&
                                                        (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichInRow-1) &&
                                                        (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                    for (int l=0; l<64; l++){
                                                        try{
                                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                (!GameFrame.field[l].isOccupied)){

                                                                if (l == fieldFound){
                                                                    //Niszczenie pionka zbitego:
                                                                    GameFrame.field[j].isOccupied = false;
                                                                    GameFrame.field[j].isOccupiedByWhite = -1;
                                                                    for (int m=0; m<12; m++){
                                                                        if (GameFrame.blackpawn[m].field == j){
                                                                            GameFrame.blackpawn[m].ifDeleted = true;
                                                                            GameFrame.blackpawn[m].field = -1;
                                                                        }
                                                                    }

                                                                    GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.field[l].Color = Color.GRAY;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                    GameFrame.field[l].isOccupied = true;
                                                                    GameFrame.field[l].isOccupiedByWhite = 1;
                                                                    
                                                                    //Check if the pawn will be leveled up:
                                                                    if (GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow == 0){
                                                                        GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp = true;
                                                                    }
                                                                    
                                                                    GameFrame.game.activatedField = -1;
                                                                    GameFrame.game.activatedPawn = -1;
                                                                    GameFrame.game.ifActivatedField = false;
                                                                }
                                                            }
                                                        } catch(Exception e){}
                                                    }
                                                }
                                            } catch(Exception e){}
                                                
                                            //3. bicie: prawo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow-1) &&
                                                        (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichInRow+1) &&
                                                        (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                    for (int l=0; l<64; l++){
                                                        try{
                                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                (!GameFrame.field[l].isOccupied)){

                                                                if (l == fieldFound){
                                                                    //Niszczenie pionka zbitego:
                                                                    GameFrame.field[j].isOccupied = false;
                                                                    GameFrame.field[j].isOccupiedByWhite = -1;
                                                                    for (int m=0; m<12; m++){
                                                                        if (GameFrame.blackpawn[m].field == j){
                                                                            GameFrame.blackpawn[m].ifDeleted = true;
                                                                            GameFrame.blackpawn[m].field = -1;
                                                                        }
                                                                    }

                                                                    GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.field[l].Color = Color.GRAY;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                    GameFrame.field[l].isOccupied = true;
                                                                    GameFrame.field[l].isOccupiedByWhite = 1;
                                                                    
                                                                    //Check if the pawn will be leveled up:
                                                                    if (GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow == 0){
                                                                        GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp = true;
                                                                    }
                                                                    
                                                                    GameFrame.game.activatedField = -1;
                                                                    GameFrame.game.activatedPawn = -1;
                                                                    GameFrame.game.ifActivatedField = false;
                                                                }
                                                            }
                                                        } catch(Exception e){}
                                                    }
                                                }
                                            } catch(Exception e){}
                                                
                                            //4. bicie: prawo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow+1) &&
                                                        (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichInRow+1) &&
                                                        (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                    for (int l=0; l<64; l++){
                                                        try{
                                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                (!GameFrame.field[l].isOccupied)){

                                                                if (l == fieldFound){
                                                                    //Niszczenie pionka zbitego:
                                                                    GameFrame.field[j].isOccupied = false;
                                                                    GameFrame.field[j].isOccupiedByWhite = -1;
                                                                    for (int m=0; m<12; m++){
                                                                        if (GameFrame.blackpawn[m].field == j){
                                                                            GameFrame.blackpawn[m].ifDeleted = true;
                                                                            GameFrame.blackpawn[m].field = -1;
                                                                        }
                                                                    }

                                                                    GameFrame.whitepawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.field[l].Color = Color.GRAY;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                    GameFrame.field[l].isOccupied = true;
                                                                    GameFrame.field[l].isOccupiedByWhite = 1;
                                                                    
                                                                    //Check if the pawn will be leveled up:
                                                                    if (GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow == 0){
                                                                        GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp = true;
                                                                    }
                                                                    
                                                                    GameFrame.game.activatedField = -1;
                                                                    GameFrame.game.activatedPawn = -1;
                                                                    GameFrame.game.ifActivatedField = false;
                                                                }
                                                            }
                                                        } catch(Exception e){}
                                                    }
                                                }
                                            } catch(Exception e){}
                                        }
                                    }
                                    checkIfBeatingByWhite();
                                    if (!GameFrame.game.ifBeatingByWhite){
                                        GameFrame.game.whiteTurn = false;
                                        checkIfBeatingByBlack();
                                    }
                                }     
                                
                                    checkIfBeatingByWhite();
                                    if (!GameFrame.game.ifBeatingByWhite){
                                        GameFrame.game.whiteTurn = false;
                                        checkIfBeatingByBlack();
                                    }
                            }
                            
                        }else{
                            for (int i=0; i<12; i++){
                                if (GameFrame.whitepawn[i].field == fieldFound){
                                    if (GameFrame.whitepawn[i].leveledUp){ //dla bicia damkami
                                        for (int j=0; j<64; j++){
                                            for (int k=1; k<9; k++){
                                                if (GameFrame.field[j].isOccupiedByWhite != 1){
                                                    //1. zaznaczenie: lewo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }
                                                                        
                                                                        if (pauseSearching == false){
                                                                        if (GameFrame.whitepawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}
                                                    
                                                    pauseSearching = false;
                                                    
                                                    //2. zaznaczenie: lewo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (GameFrame.whitepawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}

                                                    pauseSearching = false;
                                                    
                                                    //3. zaznaczenie: prawo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (GameFrame.whitepawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}  

                                                    pauseSearching = false;
                                                        
                                                    //4. zaznaczenie: prawo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (GameFrame.whitepawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){} 
                                                    pauseSearching = false;
                                                }
                                            }
                                        }
                                    }else{
                                        for (int j=0; j<64; j++){
                                            if (GameFrame.field[j].isOccupiedByWhite != 1){
                                                //1. zaznaczenie: lewo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                        if (GameFrame.whitepawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //2. zaznaczenie: lewo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                        if (GameFrame.whitepawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //3. zaznaczenie: prawo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                        if (GameFrame.whitepawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //4. zaznaczenie: prawo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 0)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                        if (GameFrame.whitepawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.whitepawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                }else{ //Black side
                    if (GameFrame.whiteOne == false){
                    if (!GameFrame.game.ifBeatingByBlack){
                        if (GameFrame.game.ifActivatedField){
                            for (int i = 0; i<12; i++){
                                if (GameFrame.blackpawn[i].field == fieldFound){
                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                    GameFrame.field[fieldFound].Color = Color.BLUE;
                                    GameFrame.game.activatedField = fieldFound;
                                    GameFrame.game.activatedPawn = i;
                                    for (int j=0; j<64; j++){
                                            if(GameFrame.field[j].Color == Color.PINK){
                                                GameFrame.field[j].Color = Color.GRAY;
                                            }
                                    }

                                    if (GameFrame.blackpawn[GameFrame.game.activatedPawn].leveledUp){
                                        boolean przerwij = false;
                                        //1.lewo-gora
                                        for (int k=1; k<8; k++){
                                            if (przerwij == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        przerwij = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        przerwij = false;
                                        //2.lewo-dol
                                        for (int k=1; k<8; k++){
                                            if (przerwij == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        przerwij = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        przerwij = false;
                                        //3.prawo-gora
                                        for (int k=1; k<8; k++){
                                            if (przerwij == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        przerwij = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        przerwij = false;
                                        //4.prawo-dol
                                        for (int k=1; k<8; k++){
                                            if (przerwij == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        przerwij = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                    }else{
                                        for (int j=0;j<64;j++){
                                            if ((GameFrame.field[j].whichRow == (GameFrame.field[GameFrame.game.activatedField].whichRow+1)) && 
                                               ((GameFrame.field[j].whichInRow == (GameFrame.field[GameFrame.game.activatedField].whichInRow-1)) || 
                                               (GameFrame.field[j].whichInRow == (GameFrame.field[GameFrame.game.activatedField].whichInRow+1))) && !GameFrame.field[j].isOccupied){
                                                GameFrame.field[j].Color = Color.PINK;
                                            }
                                        }
                                    }
                                }
                            }
                            
                            if (!GameFrame.field[fieldFound].isOccupied){
                                if (GameFrame.blackpawn[GameFrame.game.activatedPawn].leveledUp){
                                    GameFrame.game.stopSearchingFields = false;
                                    //searching...
                                        //1.lewo-gora
                                        if (GameFrame.game.stopSearchingFields == false){
                                            for (int k=1; k<8; k++){
                                                if (GameFrame.game.stopSearchingFields == true) break;
                                                if ((GameFrame.field[fieldFound].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[fieldFound].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k) &&
                                                   (GameFrame.field[fieldFound].Color == Color.PINK)){
                                                    GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                    GameFrame.field[fieldFound].isOccupied = true;
                                                    GameFrame.field[fieldFound].isOccupiedByWhite = 0;
                                                    GameFrame.game.activatedField = -1;
                                                    GameFrame.game.ifActivatedField = false;
                                                    for (int i=0; i<64; i++){
                                                        if(GameFrame.field[i].Color == Color.PINK){
                                                            GameFrame.field[i].Color = Color.GRAY;
                                                        }
                                                    } 
                                                    GameFrame.game.stopSearchingFields = true;
                                                }
                                            }
                                        }

                                        //2.lewo-dol
                                        if (GameFrame.game.stopSearchingFields == false){
                                            for (int k=1; k<8; k++){
                                                if (GameFrame.game.stopSearchingFields == true) break;
                                                if ((GameFrame.field[fieldFound].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[fieldFound].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k) &&
                                                   (GameFrame.field[fieldFound].Color == Color.PINK)){
                                                    GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                    GameFrame.field[fieldFound].isOccupied = true;
                                                    GameFrame.field[fieldFound].isOccupiedByWhite = 0;
                                                    GameFrame.game.activatedField = -1;
                                                    GameFrame.game.ifActivatedField = false;
                                                    for (int i=0; i<64; i++){
                                                        if(GameFrame.field[i].Color == Color.PINK){
                                                            GameFrame.field[i].Color = Color.GRAY;
                                                        }
                                                    }
                                                    GameFrame.game.stopSearchingFields = true;
                                                }
                                            }
                                        }

                                        //3.prawo-gora
                                        if (GameFrame.game.stopSearchingFields == false){
                                            for (int k=1; k<8; k++){
                                                if (GameFrame.game.stopSearchingFields == true) break;
                                                if ((GameFrame.field[fieldFound].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[fieldFound].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k) &&
                                                   (GameFrame.field[fieldFound].Color == Color.PINK)){
                                                    GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                    GameFrame.field[fieldFound].isOccupied = true;
                                                    GameFrame.field[fieldFound].isOccupiedByWhite = 0;
                                                    GameFrame.game.activatedField = -1;
                                                    GameFrame.game.ifActivatedField = false;
                                                    for (int i=0; i<64; i++){
                                                        if(GameFrame.field[i].Color == Color.PINK){
                                                            GameFrame.field[i].Color = Color.GRAY;
                                                        }
                                                    }
                                                    GameFrame.game.stopSearchingFields = true;
                                                }
                                            }
                                        }

                                        //4.prawo-dol
                                        if (GameFrame.game.stopSearchingFields == false){
                                            for (int k=1; k<8; k++){
                                                if (GameFrame.game.stopSearchingFields == true) break;
                                                if ((GameFrame.field[fieldFound].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[fieldFound].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k) &&
                                                   (GameFrame.field[fieldFound].Color == Color.PINK)){
                                                    GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;                       
                                                    GameFrame.field[fieldFound].isOccupied = true;
                                                    GameFrame.field[fieldFound].isOccupiedByWhite = 0;
                                                    GameFrame.game.activatedField = -1;
                                                    GameFrame.game.ifActivatedField = false;
                                                    for (int i=0; i<64; i++){
                                                        if(GameFrame.field[i].Color == Color.PINK){
                                                            GameFrame.field[i].Color = Color.GRAY;
                                                        }
                                                    }
                                                    GameFrame.game.stopSearchingFields = true;
                                                }
                                            }
                                        }
                                }else{
                                    if (GameFrame.field[fieldFound].Color == Color.PINK){
                                        GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                        GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                        GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                        GameFrame.field[fieldFound].isOccupied = true;
                                        GameFrame.field[fieldFound].isOccupiedByWhite = 0;
                                        GameFrame.game.activatedField = -1;
                                        GameFrame.game.ifActivatedField = false;
                                        for (int i=0; i<64; i++){
                                            if(GameFrame.field[i].Color == Color.PINK){
                                                GameFrame.field[i].Color = Color.GRAY;
                                            }
                                        }
                                        //Check if the pawn will be leveled up:
                                        if (GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow == 7){
                                            GameFrame.blackpawn[GameFrame.game.activatedPawn].leveledUp = true;
                                        }
                                        GameFrame.game.activatedPawn = -1;
                                    }
                                }
                                
                                checkIfBeatingByWhite();
                                GameFrame.game.whiteTurn = true;
                            }
                        }else{
                            for (int i = 0; i<12; i++){
                                if (GameFrame.blackpawn[i].field == fieldFound){
                                    GameFrame.field[fieldFound].Color = Color.BLUE;
                                    GameFrame.game.ifActivatedField = true;
                                    GameFrame.game.activatedField = fieldFound;
                                    GameFrame.game.activatedPawn = i;
                                    
                                    if (GameFrame.blackpawn[GameFrame.game.activatedPawn].leveledUp){
                                        GameFrame.game.stopSearchingFields = false;
                                        //1.lewo-gora
                                        for (int k=1; k<8; k++){
                                            if (GameFrame.game.stopSearchingFields == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        GameFrame.game.stopSearchingFields = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        GameFrame.game.stopSearchingFields = false;
                                        //2.lewo-dol
                                        for (int k=1; k<8; k++){
                                            if (GameFrame.game.stopSearchingFields == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow-k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        GameFrame.game.stopSearchingFields = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        GameFrame.game.stopSearchingFields = false;
                                        //3.prawo-gora
                                        for (int k=1; k<8; k++){
                                            if (GameFrame.game.stopSearchingFields == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow-k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        GameFrame.game.stopSearchingFields = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                        GameFrame.game.stopSearchingFields = false;
                                        //4.prawo-dol
                                        for (int k=1; k<8; k++){
                                            if (GameFrame.game.stopSearchingFields == true) break;
                                            for (int j=0; j<64; j++){
                                                try{
                                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.game.activatedField].whichRow+k) && (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.game.activatedField].whichInRow+k)){
                                                    if (!GameFrame.field[j].isOccupied){
                                                            GameFrame.field[j].Color = Color.PINK;
                                                    } else{
                                                        GameFrame.game.stopSearchingFields = true;
                                                    }
                                                }
                                                } catch(Exception e){
                                                }
                                            }
                                        }

                                    }else{
                                        for (int j=0;j<64;j++){
                                            if ((GameFrame.field[j].whichRow == (GameFrame.field[GameFrame.game.activatedField].whichRow+1)) && 
                                               ((GameFrame.field[j].whichInRow == (GameFrame.field[GameFrame.game.activatedField].whichInRow-1)) || 
                                               (GameFrame.field[j].whichInRow == (GameFrame.field[GameFrame.game.activatedField].whichInRow+1))) && !GameFrame.field[j].isOccupied){
                                                GameFrame.field[j].Color = Color.PINK;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if (GameFrame.game.ifActivatedField){
                            for (int i=0; i<12; i++){
                                if (GameFrame.blackpawn[i].field == fieldFound){
                                    if (GameFrame.blackpawn[i].leveledUp){ //dla bicia damkami
                                        for (int j=0; j<64; j++){
                                            for (int k=1; k<9; k++){
                                                if (GameFrame.field[j].isOccupiedByWhite != 0){
                                                    
                                                    //1. zaznaczenie: lewo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                        GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                        GameFrame.game.activatedPawn = i;
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}

                                                    pauseSearching = false;
                                                        
                                                    //2. zaznaczenie: lewo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                        GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                        GameFrame.game.activatedPawn = i;
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}

                                                    
                                                    pauseSearching = false;
                                                    
                                                    //3. zaznaczenie: prawo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching){
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                        GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                        GameFrame.game.activatedPawn = i;
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}  

                                                    pauseSearching = false;
                                                    //4. zaznaczenie: prawo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }
                                                                        
                                                                        if (pauseSearching){
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                        GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                        GameFrame.game.activatedPawn = i;
                                                                        GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){} 
                                                    pauseSearching = false;
                                                }
                                            }
                                        }
                                    }else{
                                        for (int j=0; j<64; j++){
                                            if (GameFrame.field[j].isOccupiedByWhite != 0){
                                                //1. zaznaczenie: lewo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                    GameFrame.game.activatedPawn = i;
                                                                    GameFrame.game.ifActivatedField = true;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //2. zaznaczenie: lewo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                    GameFrame.game.activatedPawn = i;
                                                                    GameFrame.game.ifActivatedField = true;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //3. zaznaczenie: prawo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                    GameFrame.game.activatedPawn = i;
                                                                    GameFrame.game.ifActivatedField = true;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //4. zaznaczenie: prawo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                    GameFrame.game.activatedPawn = i;
                                                                    GameFrame.game.ifActivatedField = true;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}
                                            }
                                        }
                                    }
                                }
                            }
                            
                            //Pole zaktywowane i bedzie wykonywane bicie pionka:
                            if (!GameFrame.field[fieldFound].isOccupied){
                                if (GameFrame.blackpawn[GameFrame.game.activatedPawn].leveledUp){
                                    for (int j=0; j<64; j++){
                                            for (int k=1; k<9; k++){
                                                    //1. bicie: lewo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (l == fieldFound){
                                                                            //Niszczenie pionka zbitego:
                                                                            GameFrame.field[j].isOccupied = false;
                                                                            GameFrame.field[j].isOccupiedByWhite = -1;
                                                                            
                                                                            for (int m=0; m<12; m++){
                                                                                if (GameFrame.whitepawn[m].field == j){
                                                                                    GameFrame.whitepawn[m].ifDeleted = true;
                                                                                    GameFrame.whitepawn[m].field = -1;
                                                                                }
                                                                            }

                                                                            GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                            GameFrame.field[l].Color = Color.GRAY;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                            GameFrame.field[l].isOccupied = true;
                                                                            GameFrame.field[l].isOccupiedByWhite = 0;
                                                                            GameFrame.game.activatedField = -1;
                                                                            GameFrame.game.activatedPawn = -1;
                                                                            GameFrame.game.ifActivatedField = false;
                                                                        }
                                                                        
                                                                        try{
                                                                            for (int t=1; t<=6; t++){
                                                                                for (int y=0; y<64; y++){
                                                                                    if ((GameFrame.field[y].whichRow == GameFrame.field[l].whichRow-t) &&
                                                                                        (GameFrame.field[y].whichInRow == GameFrame.field[l].whichInRow-t) &&
                                                                                        (!GameFrame.field[y].isOccupied) && (y == fieldFound)){
                                                                                        
                                                                                            //Niszczenie pionka zbitego:
                                                                                            GameFrame.field[j].isOccupied = false;
                                                                                            GameFrame.field[j].isOccupiedByWhite = -1;

                                                                                            for (int m=0; m<12; m++){
                                                                                                if (GameFrame.whitepawn[m].field == j){
                                                                                                    GameFrame.whitepawn[m].ifDeleted = true;
                                                                                                    GameFrame.whitepawn[m].field = -1;
                                                                                                }
                                                                                            }

                                                                                            GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                                            GameFrame.field[y].Color = Color.GRAY;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                                            GameFrame.field[y].isOccupied = true;
                                                                                            GameFrame.field[y].isOccupiedByWhite = 0;
                                                                                            GameFrame.game.activatedField = -1;
                                                                                            GameFrame.game.activatedPawn = -1;
                                                                                            GameFrame.game.ifActivatedField = false;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch(Exception e){}
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}
                                                    
                                                    pauseSearching = false;
                                                    //2. bicie: lewo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching){
                                                                        if (l == fieldFound){
                                                                            //Niszczenie pionka zbitego:
                                                                            GameFrame.field[j].isOccupied = false;
                                                                            GameFrame.field[j].isOccupiedByWhite = -1;
                                                                            
                                                                            for (int m=0; m<12; m++){
                                                                                if (GameFrame.whitepawn[m].field == j){
                                                                                    GameFrame.whitepawn[m].ifDeleted = true;
                                                                                    GameFrame.whitepawn[m].field = -1;
                                                                                }
                                                                            }

                                                                            GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                            GameFrame.field[l].Color = Color.GRAY;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                            GameFrame.field[l].isOccupied = true;
                                                                            GameFrame.field[l].isOccupiedByWhite = 0;
                                                                            GameFrame.game.activatedField = -1;
                                                                            GameFrame.game.activatedPawn = -1;
                                                                            GameFrame.game.ifActivatedField = false;
                                                                        }
                                                                        
                                                                        try{
                                                                            for (int t=1; t<=6; t++){
                                                                                for (int y=0; y<64; y++){
                                                                                    if ((GameFrame.field[y].whichRow == GameFrame.field[l].whichRow+t) &&
                                                                                        (GameFrame.field[y].whichInRow == GameFrame.field[l].whichInRow-t) &&
                                                                                        (!GameFrame.field[y].isOccupied) && (y == fieldFound)){
                                                                                        
                                                                                            //Niszczenie pionka zbitego:
                                                                                            GameFrame.field[j].isOccupied = false;
                                                                                            GameFrame.field[j].isOccupiedByWhite = -1;

                                                                                            for (int m=0; m<12; m++){
                                                                                                if (GameFrame.whitepawn[m].field == j){
                                                                                                    GameFrame.whitepawn[m].ifDeleted = true;
                                                                                                    GameFrame.whitepawn[m].field = -1;
                                                                                                }
                                                                                            }

                                                                                            GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                                            GameFrame.field[y].Color = Color.GRAY;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                                            GameFrame.field[y].isOccupied = true;
                                                                                            GameFrame.field[y].isOccupiedByWhite = 0;
                                                                                            GameFrame.game.activatedField = -1;
                                                                                            GameFrame.game.activatedPawn = -1;
                                                                                            GameFrame.game.ifActivatedField = false;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch(Exception e){}
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}
                                                    
                                                    pauseSearching = false;
                                                    //3. bicie: prawo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (l == fieldFound){
                                                                            //Niszczenie pionka zbitego:
                                                                            GameFrame.field[j].isOccupied = false;
                                                                            GameFrame.field[j].isOccupiedByWhite = -1;
                                                                            
                                                                            for (int m=0; m<12; m++){
                                                                                if (GameFrame.whitepawn[m].field == j){
                                                                                    GameFrame.whitepawn[m].ifDeleted = true;
                                                                                    GameFrame.whitepawn[m].field = -1;
                                                                                }
                                                                            }

                                                                            GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                            GameFrame.field[l].Color = Color.GRAY;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                            GameFrame.field[l].isOccupied = true;
                                                                            GameFrame.field[l].isOccupiedByWhite = 0;
                                                                            GameFrame.game.activatedField = -1;
                                                                            GameFrame.game.activatedPawn = -1;
                                                                            GameFrame.game.ifActivatedField = false;
                                                                        }
                                                                        
                                                                        try{
                                                                            for (int t=1; t<=6; t++){
                                                                                for (int y=0; y<64; y++){
                                                                                    if ((GameFrame.field[y].whichRow == GameFrame.field[l].whichRow-t) &&
                                                                                        (GameFrame.field[y].whichInRow == GameFrame.field[l].whichInRow+t) &&
                                                                                        (!GameFrame.field[y].isOccupied) && (y == fieldFound)){
                                                                                        
                                                                                            //Niszczenie pionka zbitego:
                                                                                            GameFrame.field[j].isOccupied = false;
                                                                                            GameFrame.field[j].isOccupiedByWhite = -1;

                                                                                            for (int m=0; m<12; m++){
                                                                                                if (GameFrame.whitepawn[m].field == j){
                                                                                                    GameFrame.whitepawn[m].ifDeleted = true;
                                                                                                    GameFrame.whitepawn[m].field = -1;
                                                                                                }
                                                                                            }

                                                                                            GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                                            GameFrame.field[y].Color = Color.GRAY;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                                            GameFrame.field[y].isOccupied = true;
                                                                                            GameFrame.field[y].isOccupiedByWhite = 0;
                                                                                            GameFrame.game.activatedField = -1;
                                                                                            GameFrame.game.activatedPawn = -1;
                                                                                            GameFrame.game.ifActivatedField = false;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch(Exception e){}
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}  

                                                    pauseSearching = false;
                                                    //4. bicie: prawo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                         if (l == fieldFound){
                                                                            //Niszczenie pionka zbitego:
                                                                            GameFrame.field[j].isOccupied = false;
                                                                            GameFrame.field[j].isOccupiedByWhite = -1;
                                                                            
                                                                            for (int m=0; m<12; m++){
                                                                                if (GameFrame.whitepawn[m].field == j){
                                                                                    GameFrame.whitepawn[m].ifDeleted = true;
                                                                                    GameFrame.whitepawn[m].field = -1;
                                                                                }
                                                                            }

                                                                            GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                            GameFrame.field[l].Color = Color.GRAY;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                            GameFrame.field[l].isOccupied = true;
                                                                            GameFrame.field[l].isOccupiedByWhite = 0;
                                                                            
                                                                            //Check if the pawn will be leveled up:
                                                                            if (GameFrame.field[GameFrame.whitepawn[GameFrame.game.activatedPawn].field].whichRow == 7){
                                                                                GameFrame.whitepawn[GameFrame.game.activatedPawn].leveledUp = true;
                                                                            }
                                                                            
                                                                            GameFrame.game.activatedField = -1;
                                                                            GameFrame.game.activatedPawn = -1;
                                                                            GameFrame.game.ifActivatedField = false;
                                                                        }
                                                                         
                                                                        try{
                                                                            for (int t=1; t<=6; t++){
                                                                                for (int y=0; y<64; y++){
                                                                                    if ((GameFrame.field[y].whichRow == GameFrame.field[l].whichRow+t) &&
                                                                                        (GameFrame.field[y].whichInRow == GameFrame.field[l].whichInRow+t) &&
                                                                                        (!GameFrame.field[y].isOccupied) && (y == fieldFound)){
                                                                                        
                                                                                            //Niszczenie pionka zbitego:
                                                                                            GameFrame.field[j].isOccupied = false;
                                                                                            GameFrame.field[j].isOccupiedByWhite = -1;

                                                                                            for (int m=0; m<12; m++){
                                                                                                if (GameFrame.whitepawn[m].field == j){
                                                                                                    GameFrame.whitepawn[m].ifDeleted = true;
                                                                                                    GameFrame.whitepawn[m].field = -1;
                                                                                                }
                                                                                            }

                                                                                            GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                                            GameFrame.field[y].Color = Color.GRAY;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                                            GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                                            GameFrame.field[y].isOccupied = true;
                                                                                            GameFrame.field[y].isOccupiedByWhite = 0;
                                                                                            GameFrame.game.activatedField = -1;
                                                                                            GameFrame.game.activatedPawn = -1;
                                                                                            GameFrame.game.ifActivatedField = false;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch(Exception e){}
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}
                                                    pauseSearching = false;
                                            }
                                    }
                                    
                                    checkIfBeatingByWhite();
                                    if (!GameFrame.game.ifBeatingByWhite){
                                        GameFrame.game.whiteTurn = false;
                                        checkIfBeatingByBlack();
                                    }
                                    
                                }else{
                                    for (int j=0; j<64; j++){
                                        if (GameFrame.field[j].isOccupiedByWhite != 0){
                                            //1. bicie: lewo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow-1) &&
                                                        (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichInRow-1) &&
                                                        (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                    for (int l=0; l<64; l++){
                                                        try{
                                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                (!GameFrame.field[l].isOccupied)){
                                                                
                                                                if (l == fieldFound){
                                                                    //Niszczenie pionka zbitego:
                                                                    GameFrame.field[j].isOccupied = false;
                                                                    GameFrame.field[j].isOccupiedByWhite = -1;
                                                                    for (int m=0; m<12; m++){
                                                                        if (GameFrame.whitepawn[m].field == j){
                                                                            GameFrame.whitepawn[m].ifDeleted = true;
                                                                            GameFrame.whitepawn[m].field = -1;
                                                                        }
                                                                    }

                                                                    GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.field[l].Color = Color.GRAY;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                    GameFrame.field[l].isOccupied = true;
                                                                    GameFrame.field[l].isOccupiedByWhite = 0;
                                                                    
                                                                    //Check if the pawn will be leveled up:
                                                                    if (GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow == 7){
                                                                        GameFrame.blackpawn[GameFrame.game.activatedPawn].leveledUp = true;
                                                                    }
                                                                    
                                                                    GameFrame.game.activatedField = -1;
                                                                    GameFrame.game.activatedPawn = -1;
                                                                    GameFrame.game.ifActivatedField = false;
                                                                }
                                                            }
                                                        } catch(Exception e){}
                                                    }
                                                }
                                            } catch(Exception e){}
                                                
                                            //2. bicie: lewo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow+1) &&
                                                        (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichInRow-1) &&
                                                        (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                    for (int l=0; l<64; l++){
                                                        try{
                                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                (!GameFrame.field[l].isOccupied)){

                                                                if (l == fieldFound){
                                                                    //Niszczenie pionka zbitego:
                                                                    GameFrame.field[j].isOccupied = false;
                                                                    GameFrame.field[j].isOccupiedByWhite = -1;
                                                                    for (int m=0; m<12; m++){
                                                                        if (GameFrame.whitepawn[m].field == j){
                                                                            GameFrame.whitepawn[m].ifDeleted = true;
                                                                            GameFrame.whitepawn[m].field = -1;
                                                                        }
                                                                    }

                                                                    GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.field[l].Color = Color.GRAY;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                    GameFrame.field[l].isOccupied = true;
                                                                    GameFrame.field[l].isOccupiedByWhite = 0;
                                                                    
                                                                    //Check if the pawn will be leveled up:
                                                                    if (GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow == 7){
                                                                        GameFrame.blackpawn[GameFrame.game.activatedPawn].leveledUp = true;
                                                                    }
                                                                    GameFrame.game.activatedField = -1;
                                                                    GameFrame.game.activatedPawn = -1;
                                                                    GameFrame.game.ifActivatedField = false;
                                                                }
                                                            }
                                                        } catch(Exception e){}
                                                    }
                                                }
                                            } catch(Exception e){}
                                                
                                            //3. bicie: prawo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow-1) &&
                                                        (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichInRow+1) &&
                                                        (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                    for (int l=0; l<64; l++){
                                                        try{
                                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                (!GameFrame.field[l].isOccupied)){

                                                                if (l == fieldFound){
                                                                    //Niszczenie pionka zbitego:
                                                                    GameFrame.field[j].isOccupied = false;
                                                                    GameFrame.field[j].isOccupiedByWhite = -1;
                                                                    for (int m=0; m<12; m++){
                                                                        if (GameFrame.whitepawn[m].field == j){
                                                                            GameFrame.whitepawn[m].ifDeleted = true;
                                                                            GameFrame.whitepawn[m].field = -1;
                                                                        }
                                                                    }

                                                                    GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.field[l].Color = Color.GRAY;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                    GameFrame.field[l].isOccupied = true;
                                                                    GameFrame.field[l].isOccupiedByWhite = 0;
                                                                    
                                                                    //Check if the pawn will be leveled up:
                                                                    if (GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow == 7){
                                                                        GameFrame.blackpawn[GameFrame.game.activatedPawn].leveledUp = true;
                                                                    }
                                                                    
                                                                    GameFrame.game.activatedField = -1;
                                                                    GameFrame.game.activatedPawn = -1;
                                                                    GameFrame.game.ifActivatedField = false;
                                                                }
                                                            }
                                                        } catch(Exception e){}
                                                    }
                                                }
                                            } catch(Exception e){}
                                                
                                            //4. bicie: prawo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow+1) &&
                                                        (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichInRow+1) &&
                                                        (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                    for (int l=0; l<64; l++){
                                                        try{
                                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                (!GameFrame.field[l].isOccupied)){

                                                                if (l == fieldFound){
                                                                    //Niszczenie pionka zbitego:
                                                                    GameFrame.field[j].isOccupied = false;
                                                                    GameFrame.field[j].isOccupiedByWhite = -1;
                                                                    for (int m=0; m<12; m++){
                                                                        if (GameFrame.whitepawn[m].field == j){
                                                                            GameFrame.whitepawn[m].ifDeleted = true;
                                                                            GameFrame.whitepawn[m].field = -1;
                                                                        }
                                                                    }

                                                                    GameFrame.blackpawn[GameFrame.game.activatedPawn].field = fieldFound;
                                                                    GameFrame.field[GameFrame.game.activatedField].Color = Color.GRAY;
                                                                    GameFrame.field[l].Color = Color.GRAY;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupied = false;
                                                                    GameFrame.field[GameFrame.game.activatedField].isOccupiedByWhite = -1;
                                                                    GameFrame.field[l].isOccupied = true;
                                                                    GameFrame.field[l].isOccupiedByWhite = 0;
                                                                    
                                                                    //Check if the pawn will be leveled up:
                                                                    if (GameFrame.field[GameFrame.blackpawn[GameFrame.game.activatedPawn].field].whichRow == 7){
                                                                        GameFrame.blackpawn[GameFrame.game.activatedPawn].leveledUp = true;
                                                                    }
                                                                    
                                                                    GameFrame.game.activatedField = -1;
                                                                    GameFrame.game.activatedPawn = -1;
                                                                    GameFrame.game.ifActivatedField = false;
                                                                }
                                                            }
                                                        } catch(Exception e){}
                                                    }
                                                }
                                            } catch(Exception e){}
                                        }
                                    }
                                    checkIfBeatingByBlack();
                                    if (!GameFrame.game.ifBeatingByBlack){
                                        GameFrame.game.whiteTurn = true;
                                        checkIfBeatingByWhite();
                                    }
                                }
                                
                                    checkIfBeatingByBlack();
                                    if (!GameFrame.game.ifBeatingByBlack){
                                        GameFrame.game.whiteTurn = true;
                                        checkIfBeatingByWhite();
                                    }
                            }
                            
                        }else{
                            for (int i=0; i<12; i++){
                                if (GameFrame.blackpawn[i].field == fieldFound){
                                    if (GameFrame.blackpawn[i].leveledUp){ //dla bicia damkami
                                        for (int j=0; j<64; j++){
                                            for (int k=1; k<9; k++){
                                                if (GameFrame.field[j].isOccupiedByWhite != 0){
                                                    //1. zaznaczenie: lewo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }
                                                                        
                                                                        if (pauseSearching == false){
                                                                        if (GameFrame.blackpawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}

                                                    pauseSearching = false;
                                                    //2. zaznaczenie: lewo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (GameFrame.blackpawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}

                                                    pauseSearching = false;
                                                    //3. zaznaczenie: prawo-gora
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (GameFrame.blackpawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){}  

                                                    pauseSearching = false;
                                                    //4. zaznaczenie: prawo-dol
                                                    try{
                                                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+k) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+k) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                                                            for (int l=0; l<64; l++){
                                                                try{
                                                                    if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                        (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                        (!GameFrame.field[l].isOccupied)){
                                                                        
                                                                        for (int g=1; g<=(k-1); g++){
                                                                            for (int h=0; h<64; h++){
                                                                                if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                                                    (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                                                    (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                                            }
                                                                        }

                                                                        if (pauseSearching == false){
                                                                        if (GameFrame.blackpawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                        }
                                                                    }
                                                                } catch(Exception e){}
                                                            }
                                                        }
                                                    } catch(Exception e){} 
                                                    pauseSearching = false;
                                                }
                                            }
                                        }
                                    }else{
                                        for (int j=0; j<64; j++){
                                            if (GameFrame.field[j].isOccupiedByWhite != 0){
                                                //1. zaznaczenie: lewo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                        if (GameFrame.blackpawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //2. zaznaczenie: lewo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                        if (GameFrame.blackpawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //3. zaznaczenie: prawo-gora
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                        if (GameFrame.blackpawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}

                                                //4. zaznaczenie: prawo-dol
                                                try{
                                                    if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+1) &&
                                                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+1) &&
                                                            (GameFrame.field[j].isOccupiedByWhite == 1)){
                                                        for (int l=0; l<64; l++){
                                                            try{
                                                                if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                                    (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                                    (!GameFrame.field[l].isOccupied)){

                                                                        if (GameFrame.blackpawn[i].field == fieldFound){
                                                                            GameFrame.game.activatedField = GameFrame.blackpawn[i].field;
                                                                            GameFrame.game.activatedPawn = i;
                                                                            GameFrame.game.ifActivatedField = true;
                                                                            GameFrame.field[GameFrame.game.activatedField].Color = Color.BLUE;
                                                                        }
                                                                }
                                                            } catch(Exception e){}
                                                        }
                                                    }
                                                } catch(Exception e){}
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                }
            }
        }
        GameFrame.readyToSend = true;
    }//GEN-LAST:event_formMouseClicked
    
    public int checkFieldAtClick(int xPointed, int yPointed){  
        int fieldFound = -1;
        for (int i=0; i<64; i++){
            if (((xPointed >= GameFrame.field[i].x) && (xPointed <= (GameFrame.field[i].x+scale-1)))
               && ((yPointed >= GameFrame.field[i].y) && (yPointed <= GameFrame.field[i].y+scale-1))){
                fieldFound = i;
                return fieldFound;
            }
        }      
        return fieldFound;
    }
    
    public void clearBeatingColor(){
        for (int i=0; i<64; i++){
            if (GameFrame.field[i].Color == Color.RED) GameFrame.field[i].Color = Color.GRAY;
        }
    }
    
    public void checkIfBeatingByWhite(){
        pauseSearching = false;
        ifBreakLoops = false;
        clearBeatingColor();
        GameFrame.game.ifBeatingByWhite = false;
        for(int i=0; i<12; i++){
            if (GameFrame.whitepawn[i].leveledUp){
                //1 - Znalezienie bicia: lewo-gora
                for (int j=0; j<64; j++){
                    if (ifBreakLoops) break;
                    for (int k=1; k<9; k++){
                        if (ifBreakLoops) break;
                        if (GameFrame.field[j].isOccupiedByWhite != 1){
                            try{
                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-k) &&
                                    (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-k) &&
                                    (GameFrame.field[j].isOccupiedByWhite == 0)){

                                    for (int l=0; l<64; l++){
                                        if (ifBreakLoops) break;
                                        try{
                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                (!GameFrame.field[l].isOccupied)){
                                                
                                                for (int g=1; g<=(k-1); g++){
                                                    for (int h=0; h<64; h++){
                                                        if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                            (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                            (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                    }
                                                }
                                                
                                                if (pauseSearching == false){
                                                GameFrame.field[l].Color = Color.RED;
                                                GameFrame.game.ifBeatingByWhite = true;
                                                
                                                    try{
                                                        for (int n=1; n<=6; n++){
                                                            if (ifBreakLoops) break;
                                                            for (int p=0; p<64; p++){
                                                                if ((GameFrame.field[p].whichRow == GameFrame.field[l].whichRow-n) &&
                                                                   (GameFrame.field[p].whichInRow == GameFrame.field[l].whichInRow-n) &&
                                                                    (!GameFrame.field[p].isOccupied)){
                                                                    GameFrame.field[p].Color = Color.RED;
                                                                    GameFrame.game.ifBeatingByWhite = true;
                                                                }else{
                                                                    ifBreakLoops = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }catch(Exception e){}
                                                }
                                            }
                                        } catch(Exception e){}
                                    }
                                }
                            } catch(Exception e){}
                        }
                    }
                }
                ifBreakLoops = false;
                pauseSearching = false;
                //2 - Znalezienie bicia: lewo-dol
                for (int j=0; j<64; j++){
                    if (ifBreakLoops) break;
                    for (int k=1; k<9; k++){
                        if (ifBreakLoops) break;
                        if (GameFrame.field[j].isOccupiedByWhite != 1){
                            try{
                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+k) &&
                                    (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-k) &&
                                    (GameFrame.field[j].isOccupiedByWhite == 0)){

                                    for (int l=0; l<64; l++){
                                        if (ifBreakLoops) break;
                                        try{
                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                (!GameFrame.field[l].isOccupied)){
                                                
                                                for (int g=1; g<=(k-1); g++){
                                                    for (int h=0; h<64; h++){
                                                        if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                            (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                            (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                    }
                                                }
                                                
                                                if (pauseSearching == false){
                                                GameFrame.field[l].Color = Color.RED;
                                                GameFrame.game.ifBeatingByWhite = true;
                                                
                                                    try{
                                                        for (int n=1; n<=6; n++){
                                                            if (ifBreakLoops) break;
                                                            for (int p=0; p<64; p++){
                                                                if (ifBreakLoops) break;
                                                                if ((GameFrame.field[p].whichRow == GameFrame.field[l].whichRow+n) &&
                                                                   (GameFrame.field[p].whichInRow == GameFrame.field[l].whichInRow-n) &&
                                                                    (!GameFrame.field[p].isOccupied)){
                                                                    GameFrame.field[p].Color = Color.RED;
                                                                    GameFrame.game.ifBeatingByWhite = true;
                                                                }else{
                                                                    ifBreakLoops = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }catch(Exception e){}
                                                }
                                            }
                                        } catch(Exception e){}
                                    }
                                }
                            } catch(Exception e){}
                        }
                    }
                }
                ifBreakLoops = false;
                pauseSearching = false;
                //3 - Znalezienie bicia: prawo-gora
                for (int j=0; j<64; j++){
                    if (ifBreakLoops) break;
                    for (int k=1; k<9; k++){
                        if (ifBreakLoops) break;
                        if (GameFrame.field[j].isOccupiedByWhite != 1){
                            try{
                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-k) &&
                                    (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+k) &&
                                    (GameFrame.field[j].isOccupiedByWhite == 0)){

                                    for (int l=0; l<64; l++){
                                        if (ifBreakLoops) break;
                                        try{
                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                (!GameFrame.field[l].isOccupied)){
                                                
                                                for (int g=1; g<=(k-1); g++){
                                                    for (int h=0; h<64; h++){
                                                        if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                            (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                            (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                    }
                                                }
                                                       
                                                if (pauseSearching == false){
                                                GameFrame.field[l].Color = Color.RED;
                                                GameFrame.game.ifBeatingByWhite = true;
                                                
                                                    try{
                                                        for (int n=1; n<=6; n++){
                                                            if (ifBreakLoops) break;
                                                            for (int p=0; p<64; p++){
                                                                if (ifBreakLoops) break;
                                                                if ((GameFrame.field[p].whichRow == GameFrame.field[l].whichRow-n) &&
                                                                   (GameFrame.field[p].whichInRow == GameFrame.field[l].whichInRow+n) &&
                                                                    (!GameFrame.field[p].isOccupied)){
                                                                    GameFrame.field[p].Color = Color.RED;
                                                                    GameFrame.game.ifBeatingByWhite = true;
                                                                }else{
                                                                    ifBreakLoops = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }catch(Exception e){}
                                                }
                                            }
                                        } catch(Exception e){}
                                    }
                                }
                            } catch(Exception e){}
                        }
                    }
                }
                ifBreakLoops = false;
                pauseSearching = false;
                //4 - Znalezienie bicia: prawo-dol
                for (int j=0; j<64; j++){
                    if (ifBreakLoops) break;
                    for (int k=1; k<9; k++){
                        if (ifBreakLoops) break;
                        if (GameFrame.field[j].isOccupiedByWhite != 1){
                            try{
                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+k) &&
                                    (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+k) &&
                                    (GameFrame.field[j].isOccupiedByWhite == 0)){

                                    for (int l=0; l<64; l++){
                                        if (ifBreakLoops) break;
                                        try{
                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                (!GameFrame.field[l].isOccupied)){
                                                
                                                for (int g=1; g<=(k-1); g++){
                                                    for (int h=0; h<64; h++){
                                                        if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                            (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                            (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                    }
                                                }
                                                
                                                if (pauseSearching == false){
                                                GameFrame.field[l].Color = Color.RED;
                                                GameFrame.game.ifBeatingByWhite = true;
                                                
                                                    try{
                                                        for (int n=1; n<=6; n++){
                                                            if (ifBreakLoops) break;
                                                            for (int p=0; p<64; p++){
                                                                if (ifBreakLoops) break;
                                                                if ((GameFrame.field[p].whichRow == GameFrame.field[l].whichRow+n) &&
                                                                   (GameFrame.field[p].whichInRow == GameFrame.field[l].whichInRow+n) &&
                                                                    (!GameFrame.field[p].isOccupied)){
                                                                    GameFrame.field[p].Color = Color.RED;
                                                                    GameFrame.game.ifBeatingByWhite = true;
                                                                }else{
                                                                    ifBreakLoops = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }catch(Exception e){}
                                                }
                                            }
                                        } catch(Exception e){}
                                    }
                                }
                            } catch(Exception e){}
                            pauseSearching = false;
                            ifBreakLoops = false;
                        }
                    }
                }
                
            }else{
                
                //1 - Znalezienie bicia: lewo-gora
                for (int j=0; j<64; j++){
                    try{
                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-1) &&
                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-1) &&
                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                            for (int k=0; k<64; k++){
                                try{
                                if ((GameFrame.field[k].whichRow == GameFrame.field[j].whichRow-1) &&
                                   (GameFrame.field[k].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                   (!GameFrame.field[k].isOccupied)){
                                   GameFrame.field[k].Color = Color.RED;
                                   GameFrame.game.ifBeatingByWhite = true;
                                }
                                } catch(Exception e){}
                            }
                        }
                    } catch(Exception e){}
                } 
                
                //2 - Znalezienie bicia: lewo-dol
                for (int j=0; j<64; j++){
                    try{
                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+1) &&
                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow-1) &&
                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                            for (int k=0; k<64; k++){
                                try{
                                if ((GameFrame.field[k].whichRow == GameFrame.field[j].whichRow+1) &&
                                   (GameFrame.field[k].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                   (!GameFrame.field[k].isOccupied)){
                                   GameFrame.field[k].Color = Color.RED;
                                   GameFrame.game.ifBeatingByWhite = true;
                                }
                                } catch(Exception e){}
                            }
                        }
                    } catch(Exception e){}
                } 
                   
                //3 - Znalezienie bicia: prawo-gora
                for (int j=0; j<64; j++){
                    try{
                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow-1) &&
                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+1) &&
                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                            for (int k=0; k<64; k++){
                                try{
                                if ((GameFrame.field[k].whichRow == GameFrame.field[j].whichRow-1) &&
                                   (GameFrame.field[k].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                   (!GameFrame.field[k].isOccupied)){
                                   GameFrame.field[k].Color = Color.RED;
                                   GameFrame.game.ifBeatingByWhite = true;
                                }
                                } catch(Exception e){}
                            }
                        }
                    } catch(Exception e){}
                } 
                              
                //4 - Znalezienie bicia: prawo-dol
                for (int j=0; j<64; j++){
                    try{
                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.whitepawn[i].field].whichRow+1) &&
                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.whitepawn[i].field].whichInRow+1) &&
                            (GameFrame.field[j].isOccupiedByWhite == 0)){

                            for (int k=0; k<64; k++){
                                try{
                                if ((GameFrame.field[k].whichRow == GameFrame.field[j].whichRow+1) &&
                                   (GameFrame.field[k].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                   (!GameFrame.field[k].isOccupied)){
                                   GameFrame.field[k].Color = Color.RED;
                                   GameFrame.game.ifBeatingByWhite = true;
                                }
                                } catch(Exception e){}
                            }
                        }
                    } catch(Exception e){}
                } 
            }
        }
    }   
    
    public void checkIfBeatingByBlack(){
        pauseSearching = false;
        ifBreakLoops = false;
        clearBeatingColor();
        GameFrame.game.ifBeatingByBlack = false;
        for(int i=0; i<12; i++){
            if (GameFrame.blackpawn[i].leveledUp){
                
                //1 - Znalezienie bicia: lewo-gora
                for (int j=0; j<64; j++){
                    if (ifBreakLoops) break;
                    for (int k=1; k<9; k++){
                        if (ifBreakLoops) break;
                        if (GameFrame.field[j].isOccupiedByWhite != 0){
                            try{
                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-k) &&
                                    (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-k) &&
                                    (GameFrame.field[j].isOccupiedByWhite == 1)){

                                    for (int l=0; l<64; l++){
                                        if (ifBreakLoops) break;
                                        try{
                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                (!GameFrame.field[l].isOccupied)){
                                                
                                                for (int g=1; g<=(k-1); g++){
                                                    for (int h=0; h<64; h++){
                                                        if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                            (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                            (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                    }
                                                }
                                                       
                                                if (pauseSearching == false){
                                                GameFrame.field[l].Color = Color.RED;
                                                GameFrame.game.ifBeatingByBlack = true;
                                                
                                                    try{
                                                        for (int n=1; n<=6; n++){
                                                            if (ifBreakLoops) break;
                                                            for (int p=0; p<64; p++){
                                                                if (ifBreakLoops) break;
                                                                if ((GameFrame.field[p].whichRow == GameFrame.field[l].whichRow-n) &&
                                                                   (GameFrame.field[p].whichInRow == GameFrame.field[l].whichInRow-n) &&
                                                                    (!GameFrame.field[p].isOccupied)){
                                                                    GameFrame.field[p].Color = Color.RED;
                                                                    GameFrame.game.ifBeatingByWhite = true;
                                                                }else{
                                                                    ifBreakLoops = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }catch(Exception e){}
                                                }
                                            }
                                        } catch(Exception e){}
                                    }
                                }
                            } catch(Exception e){}
                        }
                    }
                }
                pauseSearching = false;
                ifBreakLoops = false;
                //2 - Znalezienie bicia: lewo-dol
                for (int j=0; j<64; j++){
                    if (ifBreakLoops) break;
                    for (int k=1; k<9; k++){
                        if (ifBreakLoops) break;
                        if (GameFrame.field[j].isOccupiedByWhite != 0){
                            try{
                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+k) &&
                                    (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-k) &&
                                    (GameFrame.field[j].isOccupiedByWhite == 1)){

                                    for (int l=0; l<64; l++){
                                        if (ifBreakLoops) break; 
                                        try{
                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                                (!GameFrame.field[l].isOccupied)){
                                                
                                                for (int g=1; g<=(k-1); g++){
                                                    for (int h=0; h<64; h++){
                                                        if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                            (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow+g) &&
                                                            (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                    }
                                                }
                                                       
                                                if (pauseSearching == false){
                                                GameFrame.field[l].Color = Color.RED;
                                                GameFrame.game.ifBeatingByBlack = true;
                                                
                                                    try{
                                                        for (int n=1; n<=6; n++){
                                                            if (ifBreakLoops) break;
                                                            for (int p=0; p<64; p++){
                                                                if (ifBreakLoops) break;
                                                                if ((GameFrame.field[p].whichRow == GameFrame.field[l].whichRow+n) &&
                                                                   (GameFrame.field[p].whichInRow == GameFrame.field[l].whichInRow-n) &&
                                                                    (!GameFrame.field[p].isOccupied)){
                                                                    GameFrame.field[p].Color = Color.RED;
                                                                    GameFrame.game.ifBeatingByWhite = true;
                                                                }else{
                                                                    ifBreakLoops = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }catch(Exception e){}
                                                }
                                            }
                                        } catch(Exception e){}
                                    }
                                }
                            } catch(Exception e){}
                        }
                    }
                }
                pauseSearching = false;
                ifBreakLoops = false;
                //3 - Znalezienie bicia: prawo-gora
                for (int j=0; j<64; j++){
                    if (ifBreakLoops) break;
                    for (int k=1; k<9; k++){
                        if (ifBreakLoops) break;
                        if (GameFrame.field[j].isOccupiedByWhite != 0){
                            try{
                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-k) &&
                                    (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+k) &&
                                    (GameFrame.field[j].isOccupiedByWhite == 1)){

                                    for (int l=0; l<64; l++){
                                        if (ifBreakLoops) break;
                                        try{
                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow-1) &&
                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                (!GameFrame.field[l].isOccupied)){
                                                
                                                for (int g=1; g<=(k-1); g++){
                                                    for (int h=0; h<64; h++){
                                                        if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow+g) &&
                                                            (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                            (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                    }
                                                }
                                                
                                                if (pauseSearching == false){
                                                GameFrame.field[l].Color = Color.RED;
                                                GameFrame.game.ifBeatingByBlack = true;
                                                
                                                    try{
                                                        for (int n=1; n<=6; n++){
                                                            if (ifBreakLoops) break;
                                                            for (int p=0; p<64; p++){
                                                                if (ifBreakLoops) break;
                                                                if ((GameFrame.field[p].whichRow == GameFrame.field[l].whichRow-n) &&
                                                                   (GameFrame.field[p].whichInRow == GameFrame.field[l].whichInRow+n) &&
                                                                    (!GameFrame.field[p].isOccupied)){
                                                                    GameFrame.field[p].Color = Color.RED;
                                                                    GameFrame.game.ifBeatingByWhite = true;
                                                                }else{
                                                                    ifBreakLoops = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }catch(Exception e){}
                                                }
                                            }
                                        } catch(Exception e){}
                                    }
                                }
                            } catch(Exception e){}
                        }
                    }
                }
                pauseSearching = false;
                ifBreakLoops = false;
                //4 - Znalezienie bicia: prawo-dol
                for (int j=0; j<64; j++){
                    if (ifBreakLoops) break;
                    for (int k=1; k<9; k++){
                        if (ifBreakLoops) break;
                        if (GameFrame.field[j].isOccupiedByWhite != 0){
                            try{
                                if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+k) &&
                                    (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+k) &&
                                    (GameFrame.field[j].isOccupiedByWhite == 1)){

                                    for (int l=0; l<64; l++){
                                        if (ifBreakLoops) break;
                                        try{
                                            if ((GameFrame.field[l].whichRow == GameFrame.field[j].whichRow+1) &&
                                                (GameFrame.field[l].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                                (!GameFrame.field[l].isOccupied)){
                                                
                                                for (int g=1; g<=(k-1); g++){
                                                    for (int h=0; h<64; h++){
                                                        if ((GameFrame.field[h].whichRow == GameFrame.field[j].whichRow-g) &&
                                                            (GameFrame.field[h].whichInRow == GameFrame.field[j].whichInRow-g) &&
                                                            (GameFrame.field[h].isOccupiedByWhite != -1)) pauseSearching = true;
                                                    }
                                                }
                                                        
                                                if (pauseSearching == false){
                                                GameFrame.field[l].Color = Color.RED;
                                                GameFrame.game.ifBeatingByBlack = true;
                                                
                                                    try{
                                                        for (int n=1; n<=6; n++){
                                                            if (ifBreakLoops) break;
                                                            for (int p=0; p<64; p++){
                                                                if (ifBreakLoops) break;
                                                                if ((GameFrame.field[p].whichRow == GameFrame.field[l].whichRow+n) &&
                                                                   (GameFrame.field[p].whichInRow == GameFrame.field[l].whichInRow+n) &&
                                                                    (!GameFrame.field[p].isOccupied)){
                                                                    GameFrame.field[p].Color = Color.RED;
                                                                    GameFrame.game.ifBeatingByWhite = true;
                                                                }else{
                                                                    ifBreakLoops = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }catch(Exception e){}
                                                }
                                            }
                                        } catch(Exception e){}
                                    }
                                }
                            } catch(Exception e){}
                            pauseSearching = false;
                            ifBreakLoops = false;
                        }
                    }
                }
                
            }else{
                
                //1 - Znalezienie bicia: lewo-gora
                for (int j=0; j<64; j++){
                    try{
                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-1) &&
                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-1) &&
                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                            for (int k=0; k<64; k++){
                                try{
                                if ((GameFrame.field[k].whichRow == GameFrame.field[j].whichRow-1) &&
                                   (GameFrame.field[k].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                   (!GameFrame.field[k].isOccupied)){
                                   GameFrame.field[k].Color = Color.RED;
                                   GameFrame.game.ifBeatingByBlack = true;
                                }
                                } catch(Exception e){}
                            }
                        }
                    } catch(Exception e){}
                } 
                
                //2 - Znalezienie bicia: lewo-dol
                for (int j=0; j<64; j++){
                    try{
                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+1) &&
                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow-1) &&
                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                            for (int k=0; k<64; k++){
                                try{
                                if ((GameFrame.field[k].whichRow == GameFrame.field[j].whichRow+1) &&
                                   (GameFrame.field[k].whichInRow == GameFrame.field[j].whichInRow-1) &&
                                   (!GameFrame.field[k].isOccupied)){
                                   GameFrame.field[k].Color = Color.RED;
                                   GameFrame.game.ifBeatingByBlack = true;
                                }
                                } catch(Exception e){}
                            }
                        }
                    } catch(Exception e){}
                } 
                   
                //3 - Znalezienie bicia: prawo-gora
                for (int j=0; j<64; j++){
                    try{
                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow-1) &&
                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+1) &&
                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                            for (int k=0; k<64; k++){
                                try{
                                if ((GameFrame.field[k].whichRow == GameFrame.field[j].whichRow-1) &&
                                   (GameFrame.field[k].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                   (!GameFrame.field[k].isOccupied)){
                                   GameFrame.field[k].Color = Color.RED;
                                   GameFrame.game.ifBeatingByBlack = true;
                                }
                                } catch(Exception e){}
                            }
                        }
                    } catch(Exception e){}
                } 
                              
                //4 - Znalezienie bicia: prawo-dol
                for (int j=0; j<64; j++){
                    try{
                        if ((GameFrame.field[j].whichRow == GameFrame.field[GameFrame.blackpawn[i].field].whichRow+1) &&
                            (GameFrame.field[j].whichInRow == GameFrame.field[GameFrame.blackpawn[i].field].whichInRow+1) &&
                            (GameFrame.field[j].isOccupiedByWhite == 1)){

                            for (int k=0; k<64; k++){
                                try{
                                if ((GameFrame.field[k].whichRow == GameFrame.field[j].whichRow+1) &&
                                   (GameFrame.field[k].whichInRow == GameFrame.field[j].whichInRow+1) &&
                                   (!GameFrame.field[k].isOccupied)){
                                   GameFrame.field[k].Color = Color.RED;
                                   GameFrame.game.ifBeatingByBlack = true;
                                }
                                } catch(Exception e){}
                            }
                        }
                    } catch(Exception e){}
                } 
            }
        }
    }                                 
    
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource() == timer){
          repaint(); // this will call at every 0.5 second
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){  
    super.paintComponent(g);
    doDrawing(g, GameFrame.field, GameFrame.whitepawn, GameFrame.blackpawn);
    }
    
    private void doDrawing(Graphics g, Field[] field, Pawn[] whitepawn, Pawn[] blackpawn) {     
        
        actWidth = getSize().width;
        actHeight = getSize().height;
        
        //obliczanie skalatora
        scale=min(actWidth, actHeight)/8;
        
        //dostosowanie planszy do najmniejszej: albo wysokosci albo szerokosci
        toCenter=max(actWidth, actHeight)/2-4*scale;

        //rysowanie pól i pobieranie danych o nich...
        for (int i=0; i<64; i++){
            g.setColor(field[i].Color);
            
            if (actWidth<actHeight){
                    g.fillRect(field[i].whichInRow*scale, toCenter+field[i].whichRow*scale,  scale, scale);
                    //pobieranie danych do ustawiania poźniej pionków
                    field[i].x = field[i].whichInRow*scale;
                    field[i].y = toCenter+field[i].whichRow*scale;
            } else{
                    g.fillRect(toCenter+field[i].whichInRow*scale, field[i].whichRow*scale,  scale, scale);
                    field[i].x = toCenter+field[i].whichInRow*scale;
                    field[i].y = field[i].whichRow*scale;
            }
        } 
        
        GameFrame.counter = 0;
        for (int o=0; o<12; o++)
        {
            if (GameFrame.whitepawn[o].ifDeleted) GameFrame.counter++;
        }
        if (GameFrame.counter == 12) GameFrame.blackWon = true;//tutaj
        
        GameFrame.counter = 0;
        for (int o=0; o<12; o++)
        {
            if (GameFrame.blackpawn[o].ifDeleted) GameFrame.counter++;
        }
        if (GameFrame.counter == 12) GameFrame.whiteWon = true;//tutaj

        //rysowanie pionków na podstawie danych z klas
        if (image1 != null){
            for(int i=0; i<12; i++){
                if (blackpawn[i].ifDeleted == false){
                    if (blackpawn[i].leveledUp && image3 != null){
                        g.drawImage(image3, field[blackpawn[i].field].x+2, field[blackpawn[i].field].y+2, scale-4, scale-4, this);
                    }else g.drawImage(image1, field[blackpawn[i].field].x+2, field[blackpawn[i].field].y+2, scale-4, scale-4, this);
                }
            }
        }   
        
        if (image2 != null){
            for(int i=0; i<12; i++){
                if (whitepawn[i].ifDeleted == false){
                    if (whitepawn[i].leveledUp && image4 != null){
                        g.drawImage(image4, field[whitepawn[i].field].x+2, field[whitepawn[i].field].y+2, scale-4, scale-4, this);
                    }else g.drawImage(image2, field[whitepawn[i].field].x+2, field[whitepawn[i].field].y+2, scale-4, scale-4, this);
                }
            }   
        }
        
        //rysowanie zwyciescy/przegranego
        if (GameFrame.whiteOne){
            if (GameFrame.whiteWon) {g.drawImage(winImage, 0, 0, 320, 100, this);}  //here
            if (GameFrame.blackWon) {g.drawImage(loseImage, 0, 0, 320, 100, this);}
        }else{
            if (GameFrame.whiteWon) {g.drawImage(loseImage, 0, 0, 320, 100, this);}  //here
            if (GameFrame.blackWon) {g.drawImage(winImage, 0, 0, 320, 100, this);}
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
