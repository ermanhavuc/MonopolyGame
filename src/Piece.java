@SuppressWarnings("WeakerAccess")
public class Piece {

    private Square location;
    private String name;

    public Piece(Square location,int nameNumber) {  //piece constructor

        this.location=location;

        String[] pieceNames = {"Dog", "Racecar", "Shoe", "Hat", "Boot", "BattleShip", "Iron", "Horse"};
        this.name= pieceNames[nameNumber];
    }

    public Square getLocation() {

        return location;
    }

    public void setLocation(Square location) {

        this.location=location;
    }

    public String getName() {

        return name;
    }
}
