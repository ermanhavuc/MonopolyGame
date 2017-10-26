public class Player {

    private String name;
    private Piece piece;
    private Board board;
    private Die[] dice;

    public Player(String name, Board board, Die[] dice,Piece piece) {
        this.name = name;
        this.board = board;
        this.dice = dice;
        this.piece = piece; //Player a piece objesi atıyor ----ama ismi yok !!
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
