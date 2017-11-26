import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MonopolyGame {

    private static int RoundsNumber = 0;  //number of rounds

    PrintWriter out = new PrintWriter(new FileWriter("output.txt", true), true);

    private Board board = new Board();

    public MonopolyGame() throws IOException {

        Print.out("Welcome to Monopoly Simulation !\n",true);
        playGame(buildPlayers());  //game starts
    }

    private void playGame(ArrayList<Player> players) throws IOException {   // oyunda sadece 1 oyuncu kalana kadar oyun devam edecek iflas eden kirayı ya da vergiyi ödeyemeyen oyundan
                                                //çıkar
        while (true){
            Print.out("----Round "+(RoundsNumber++)+"----\n",true);

            for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) { //take turns in the round
                Player player = iterator.next();
                playTurn(player);

                if (player.getBankruptcyStat()) {
                    Print.out(player.getName()+" WENT BANKRUPT!",true);
                    iterator.remove();
                }

                if (players.size() == 1){
                    Print.out("--- WINNER: " + players.get(0).getName() + " ---",true);
                    break;
                }
            }

            if (players.size() == 1){
                break;
            }
        }

        Print.out("Game finished !",true);
    }

    private ArrayList<Player> buildPlayers() throws IOException {

        int numOfPlayers = 0;

        while (numOfPlayers < 2 || numOfPlayers > 8) {
            Print.out("Enter number of Players betweeen 2 and 8: ",false);

            Scanner scanner = new Scanner(System.in);

            if(scanner.hasNextInt()){
                numOfPlayers = scanner.nextInt();
                out.println(numOfPlayers+"");
            }else {
                Print.out("Please enter a number!",true);
            }
        }

        ArrayList<Player> players = new ArrayList<>();

        Print.out("\nEnter initial money of Players: ",false);
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        out.println(money+"");

        Print.out("\nEnter names of Players: ",true);

        for (int i = 0; i < numOfPlayers; i++) {
            String nameOfPlayer = new Scanner(System.in).nextLine();
            out.println(nameOfPlayer);
            players.add(new Player(nameOfPlayer, new Piece(board.getSquare(0),i)));
            players.get(i).setMoney(money);
        }

        Print.out("\nGame Starting...\n\n",true);

        return players;
    }

    private void controlGoSquare(Player player) throws IOException {

        if (player.getOldLocation().getIndex() - player.getLocation().getIndex() > 0 &&
                player.getLocation().getIndex() != 30 && player.getLocation().getIndex() != 0) {
            player.setMoney(200);
            Print.out("Player passed Go Square, 200$ received from Bank",true);
        }
    }

    private void playTurn(Player player) throws IOException {

        Print.out("- " + player.getName() + " (" + player.getMoney() + "$) is taking turn:\n",true);
        Print.out(player.getPiece().getName() + " is at " + player.getLocation().getIndex() + ": " +
                player.getLocation().getName() + "\n",true);

        if (!player.isInJail()) {
            int[] dice;
            int doubleCount = 0;

            do {
                dice = board.rollDice();

                if(doubleCount < 3) {
                    player.setLocation(board.calculateSquare(player.getLocation(), dice[0]));
                    //roll dice and calculate new location then set

                    controlGoSquare(player);

                    Print.out("\n" + player.getPiece().getName() + "'s new location is " +
                            player.getLocation().getIndex() + ": " + player.getLocation().getName(),true);

                    player.getLocation().Operation(player, board);

                    if(dice[1] == dice[2]){
                        doubleCount++;
                        Print.out("\n",true);
                    }

                }else {
                    player.setLocation(board.getSquare(10));
                    player.setInJail(true);
                    Print.out("Player " + player.getName() + " is now in jail !",true);
                    Print.out("\n" + player.getPiece().getName() + "'s new location is " +
                            player.getLocation().getIndex()+": " + player.getLocation().getName(),true);
                    break;
                }
            } while (dice[1] == dice[2] && !player.isInJail());

        }else {
            player.getLocation().Operation(player, board);
        }

        Print.out("\n\n",true);
    }
}
