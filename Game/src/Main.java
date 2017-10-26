import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner number;
        int numOfPlayer = 0; // num=player sayısı

        while (numOfPlayer < 2 || numOfPlayer > 8) {

            System.out.print("Enter number of Players betweeen 2 and 8: ");
            number = new Scanner(System.in);
            numOfPlayer = number.nextInt(); // num=player sayısı
        }
        new MonopolyGame(numOfPlayer);
    }
}
