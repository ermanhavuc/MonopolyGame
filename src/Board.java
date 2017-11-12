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

            switch (i) {

                case 0:
                    squares[i] = new GoSquare("Go Square",i);
                    break;

                case 4:
                    squares[i] = new IncomeTaxSquare("Income Tax Square",i);
                    break;

                case 20:
                    squares[i] = new FreeParkingSquare("Free Parking Square",i);
                    break;

                case 38:
                    squares[i] = new LuxuryTaxSquare("Luxury Tax Square",i);
                    break;

                default:
                    squares[i] = new RegularSquare("Regular Square", i);
                    break;
            }
        }
    }

    public  void buildDice() {

        for (int i = 0; i < 2; i++) {  //create dice objects
            dice[i] = new Die();
        }
    }

    int rollDice() {

        System.out.println("Rolling dice...");

        int rollTotal=0;

        for(int j=0; j<dice.length; j++){   //roll die

            dice[j].roll();
            rollTotal += dice[j].getFaceValue();
            int diceNumber = j + 1;
            System.out.println("Dice " + diceNumber + ": " + dice[j].getFaceValue());
        }

        System.out.println("Total: " + rollTotal);

        return rollTotal;
    }
}
