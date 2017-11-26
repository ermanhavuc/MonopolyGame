public class Piece {
    // Piece object have location on the board,and name
    private Square location;
    private Square oldLocation;
    private String name;

    public Piece(Square location,int nameNumber) { // creation of Piece object with location and name
        this.location=location;

        String[] pieceNames = {"Dog", "RaceCar", "Shoe", "Hat", "Boot", "BattleShip", "Iron", "Horse"}; // Symbols of piece objects in game
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