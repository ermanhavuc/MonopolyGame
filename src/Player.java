public class Player {   //player object

    private String name;
    private Piece piece;
    private Board board;
    private Die[] dice;

    public Player(String name, Board board, Die[] dice, Piece piece) { //player constructor

        this.name = name;
        this.board = board;
        this.dice = dice;
        this.piece = piece;
    }

    public Square getLocation() {

        return this.piece.getLocation();
    }

    public Piece getPiece() {

        return piece;
    }

    public String getName() {

        return name;
    }

    public String getPieceName() {

        return piece.getName();
    }
}
