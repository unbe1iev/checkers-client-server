package Game;

public class Game {
    public boolean whiteTurn;
    public boolean ifActivatedField;
    public int activatedField;
    public int activatedPawn;
    public boolean ifBeatingByWhite;
    public boolean ifBeatingByBlack;
    public boolean stopSearchingFields;

    public Game(){
        whiteTurn = true;
        ifActivatedField = false;
        activatedField = -1;
        activatedPawn = -1;
        stopSearchingFields = false;
        ifBeatingByWhite = false;
        ifBeatingByBlack = false;
    }
}
