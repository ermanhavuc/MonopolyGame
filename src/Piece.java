public class Piece {

    private Square location;
    private Square oldLocation;
    private String name;

    public Piece(Square location,int nameNumber) {  //piece constructor
        this.location=location;

        String[] pieceNames = {"Dog", "RaceCar", "Shoe", "Hat", "Boot", "BattleShip", "Iron", "Horse"};
        this.name= pieceNames[nameNumber];
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        oldLocation = this.location;
        this.location=location;
    }

    public Square getOldLocation() {
        return oldLocation;
    }

    public String getName() {
        return name;
    }
}
