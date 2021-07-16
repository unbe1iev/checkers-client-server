package Game;

public class Pawn {
    public boolean leveledUp; //czy pionek jest damką czy nie
    public int field; //dla odniesienia na jakim polu (0-63) stoi pionek   0  1  2  3  4  5  6  7  8  9 10 11 12 13 ...  -1 - jesli nie stoi na planszy (usuniety z gry - zbity)
    public boolean ifDeleted;
}
