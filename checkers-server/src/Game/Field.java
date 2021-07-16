package Game;

import java.awt.Color;

public class Field {
    public Color Color; //białe pole lub czarne
    public int whichRow;
    public int whichInRow;
    public boolean isOccupied; //do sprawdzania czy pole jest zajete
    //chodzi o punkt w którym bedzie rysowany obiekt - wymiary od lewego górnego rogu NewJPanel
    public int isOccupiedByWhite; //1-white, 0-black, -1 (nie jest zajete)
    public int x;
    public int y;

    public Field(){
        isOccupiedByWhite = -1;
    }
}
