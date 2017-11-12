public class Board {

    private static final int SIZE = 40;
    private Square squares[] = new Square[SIZE];
    private Die dice[] = new Die[2];

    public Board() {

        buildSquares();
        buildDice();
    }

    public Square calculateSquare(Square start, int distance) {

        int endIndex= (start.getIndex()+distance)%Board.SIZE;
        return squares[endIndex];
    }

    public Square getSquare(int index) {

        return squares[index];
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

                case 10:
                    squares[i] = new JailSquare("Jail Square",i);
                    break;

                case 20:
                    squares[i] = new FreeParkingSquare("Free Parking Square",i);
                    break;

                case 30:
                    squares[i] = new GoToJailSquare("Go to Jail Square",i);
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

    private  void buildDice() {

        for (int i = 0; i < 2; i++) {
            dice[i] = new Die();
        }
    }

    public int[] rollDice() {

        System.out.println("Rolling dice...");

        int rollTotal=0;

        for(int j=0; j<dice.length; j++){

            dice[j].roll();
            rollTotal += dice[j].getFaceValue();
            int diceNumber = j + 1;
            System.out.println("Dice " + diceNumber + ": " + dice[j].getFaceValue());
        }

        System.out.println("Total: " + rollTotal);

        int returnValues[] = new int[3];
        returnValues[0] = rollTotal;
        returnValues[1] = dice[0].getFaceValue();
        returnValues[2] = dice[1].getFaceValue();

        return returnValues;
    }
}