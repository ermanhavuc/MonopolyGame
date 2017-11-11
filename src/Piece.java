@SuppressWarnings("WeakerAccess")
public class Piece {

    private Square location;
    private String name;
    private String[] pieceNames = {"Dog","Racecar","Shoe","Hat","Boot","BattleShip","Iron","Horse"}; //piece names

    public Piece(Square location,int nameNumber) {  //piece constructor

        this.location=location;
        this.name=pieceNames[nameNumber];
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
