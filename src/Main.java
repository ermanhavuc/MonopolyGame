import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {    //main method

        PrintWriter writer = new PrintWriter("output.txt");
        writer.print("");
        new MonopolyGame();  //if number of player is acceptable value play game
    }

}