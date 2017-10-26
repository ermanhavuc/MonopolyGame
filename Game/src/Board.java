public class Board {    //board object

    private static final int SIZE = 40; //board has 40 squares
    private Square squares[] = new Square[SIZE];

    public Board() {    //board constructor

        buildSquares();
    }

    public Square getSquare(Square start, int distance) {   //

        int endIndex= (start.getIndex()+distance)%Board.SIZE;   //board has 40 squares, so pieces can not be moved to 40 and more
        return squares[endIndex];
    }

    public Square getStartSquare() {    //starting square - zero square

        return squares[0];
    }

    public void buildSquares() {

        for(int i=0;i<SIZE;i++){
            Square square= new Square( "Square "+i,i);
            squares[i] = square;
        }
    }
}
