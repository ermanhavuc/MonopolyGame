import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Board {

    private static final int SIZE = 40;
    private Square squares[] = new Square[SIZE];
    private Die dice[] = new Die[2];
    private int [] lotsArray = new int[22*3];

    public Board() throws IOException {

        buildSquares(); //Build squares
        buildDice(); //Build Dices
    }

    public Square calculateSquare(Square start, int distance) {

        int endIndex = (start.getIndex()+distance)%Board.SIZE;
        return squares[endIndex];
    }

    public Square getSquare(int index) {

        return squares[index];
    }

    private void buildSquares() throws IOException {

        Print.out("Please enter path of lots file: ",false);
        //readLotsFile(new Scanner(System.in).nextLine());
        readLotsFile("Monopoly-Lots.csv");

        int lotsFileCounter = 0;

        for(int i=0; i<SIZE ;i++) {

            switch (i) {

                case 0:
                    squares[i] = new GoSquare("Go Square",i);
                    break;

                case 5:
                    squares[i] = new IncomeTaxSquare("Income Tax Square",i);
                    break;

                case 6:
                    squares[i] = new Railroads("RailRoad1",i);
                    break;

                case 11:
                    squares[i] = new JailSquare("Jail Square",i);
                    break;

                case 16:
                    squares[i] = new Railroads("Railroad2",i);
                    break;

                case 13:
                    squares[i] = new Utility("Electric Utility Square",i);
                    break;

                case 20:
                    squares[i] = new FreeParkingSquare("Free Parking Square",i);
                    break;

                case 26:
                    squares[i] = new Railroads("Railroad3",i);
                    break;

                case 29:
                    squares[i] = new Utility("Water Utility",i);
                    break;

                case 31:
                    squares[i] = new GoToJailSquare("Go to Jail Square",i);
                    break;

                case 36:
                    squares[i] = new Railroads("Railroad4",i);
                    break;

                case 39:
                    squares[i] = new LuxuryTaxSquare("Luxury Tax Square",i);
                    break;

                default:
                    if(i == lotsArray[lotsFileCounter]){
                        squares[i] = new LotSquare("Square"+lotsArray[lotsFileCounter], lotsArray[lotsFileCounter++], lotsArray[lotsFileCounter++], lotsArray[lotsFileCounter++]);
                    }else{
                        squares[i] = new RegularSquare("Regular Square",i);
                    }

                    break;
            }
        }
    }

    private  void buildDice() {

        for (int i = 0; i < 2; i++) {
            dice[i] = new Die();
        }
    }

    public int[] rollDice() throws IOException {

        Print.out("Rolling dice...", true);

        int rollTotal=0;

        for(int j=0; j < dice.length; j++){

            dice[j].roll();
            rollTotal += dice[j].getFaceValue();
            int diceNumber = j + 1;
            Print.out("Dice " + diceNumber + ": " + dice[j].getFaceValue(),true);
        }

        Print.out("Total: " + rollTotal,true);

        int returnValues[] = new int[3];
        returnValues[0] = rollTotal;
        returnValues[1] = dice[0].getFaceValue();
        returnValues[2] = dice[1].getFaceValue();

        return returnValues;
    }

    private void readLotsFile(String path) throws FileNotFoundException {

        String[] tempStringArray;
        int i = 0;
        Scanner fileScanner = new Scanner(new File(path));
        String input = fileScanner.nextLine();

        while(fileScanner.hasNextLine()){
            input = fileScanner.nextLine();
            tempStringArray = input.split(";");

            for(int j = 0; j < 3; j++){
                lotsArray[i+j] = Integer.parseInt(tempStringArray[j]);
            }
            i += 3;
        }
    }
}