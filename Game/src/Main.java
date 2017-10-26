import java.util.Scanner;

public class Main {
    public static void main(String[] args) {    //main method

        Scanner number;
        int numOfPlayer = 0;

        while (numOfPlayer < 2 || numOfPlayer > 8) {

            System.out.print("Enter number of Players betweeen 2 and 8: ");
            number = new Scanner(System.in);
            numOfPlayer = number.nextInt();
        }
        new MonopolyGame(numOfPlayer);  //if number of player is acceptable value play game
    }
}
