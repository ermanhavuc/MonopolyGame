@SuppressWarnings("WeakerAccess")
public class Board {    //board object

    private static final int SIZE = 40; //board has 40 squares
    private Square squares[] = new Square[SIZE];
    private Die dice[] = new Die[2];

    public Board() {    //board constructor

        buildSquares();
        buildDice();
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

    public  void buildDice() {

        for (int i = 0; i < 2; i++) {  //create dice objects
            dice[i] = new Die();
        }
    }

    int rollDice() {

        int rollTotal=0;

        for(int j=0; j<dice.length; j++){   //roll die

            dice[j].roll();
            rollTotal += dice[j].getFaceValue();
            int diceNumber = j + 1;
            System.out.println("Dice " + diceNumber + ": " + dice[j].getFaceValue());
        }

        return rollTotal;
    }
}
