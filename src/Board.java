import java.io.*;
import java.util.Scanner;

public class Board {

    private static final int SIZE = 40;
    private Square squares[] = new Square[SIZE];
    private Die dice[] = new Die[2];
    private int [] lotsArray = new int[22*3];

    PrintWriter out = new PrintWriter(new FileWriter("output.txt", true), true);

    public Board() throws IOException {

        buildSquares(); //Build squares
        buildDice(); //Build Dices
    }

    public Square calculateSquare(Square start, int distance) { // calculate new place on board after rolling

        int endIndex = (start.getIndex()+distance)%Board.SIZE;
        return squares[endIndex];
    }

    public Square getSquare(int index) {

        return squares[index];
    }

    private void buildSquares() throws IOException {
        String file;
        file = "Monopoly-Lots.csv"; // file holds data about lots square position ,price,rent
        out.println(file);
        readLotsFile(file); // read from file

        int lotsFileCounter = 0;

        for(int i=0; i<SIZE ;i++) { // build squares with name and index

            switch (i) {

                case 0:
                    squares[i] = new GoSquare("Go Square",i);
                    break;

                case 4:
                    squares[i] = new IncomeTaxSquare("Income Tax Square",i);
                    break;

                case 5:
                    squares[i] = new Railroads("RailRoad1",i);
                    break;

                case 10:
                    squares[i] = new JailSquare("Jail Square",i);
                    break;

                case 15:
                    squares[i] = new Railroads("Railroad2",i);
                    break;

                case 12:
                    squares[i] = new Utility("Electric Utility Square",i);
                    break;

                case 20:
                    squares[i] = new FreeParkingSquare("Free Parking Square",i);
                    break;

                case 25:
                    squares[i] = new Railroads("Railroad3",i);
                    break;

                case 28:
                    squares[i] = new Utility("Water Utility",i);
                    break;

                case 30:
                    squares[i] = new GoToJailSquare("Go to Jail Square",i);
                    break;

                case 35:
                    squares[i] = new Railroads("Railroad4",i);
                    break;

                case 38:
                    squares[i] = new LuxuryTaxSquare("Luxury Tax Square",i);
                    break;

                default:
                    if(i == lotsArray[lotsFileCounter]){
                        squares[i] = new LotSquare("Square"+lotsArray[lotsFileCounter]+1, lotsArray[lotsFileCounter++], lotsArray[lotsFileCounter++], lotsArray[lotsFileCounter++]);
                    }else{
                        squares[i] = new RegularSquare("Regular Square",i);
                    }

                    break;
            }
        }
    }

    private  void buildDice() { // create two dice object

        for (int i = 0; i < 2; i++) {
            dice[i] = new Die();
        }
    }

    public int[] rollDice() throws IOException {  // rolling dice and get facevalues

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

    private void readLotsFile(String path) throws FileNotFoundException {  // read lots file and creation of lots Squares
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