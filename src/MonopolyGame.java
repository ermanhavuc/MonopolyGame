import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MonopolyGame {

    private static final int RoundsNumber = 15;  //number of rounds

    private Board board = new Board();

    public MonopolyGame() throws IOException {

        Print.out("Welcome to Monopoly Simulation !\n",true);
        playGame(buildPlayers());  //game starts
    }

    private void playGame(Player[] players) throws IOException {   // oyunda sadece 1 oyuncu kalana kadar oyun devam edecek iflas eden kirayı ya da vergiyi ödeyemeyen oyundan
                                                //çıkar
        for (int i = 0; i < RoundsNumber; i++) {
            Print.out("----Round "+(i+1)+"----\n",true);

            for (Player player : players) { //take turns in the round
                if (!player.getBankruptcyStat()) {
                    playTurn(player);
                }
            }
        }

        Print.out("Game finished !",true);
    }

    private Player[] buildPlayers() throws IOException {

        int numOfPlayers = 0;

        while (numOfPlayers < 2 || numOfPlayers > 8) {
            Print.out("Enter number of Players betweeen 2 and 8: ",false);

            Scanner scanner = new Scanner(System.in);

            if(scanner.hasNextInt()){
                numOfPlayers = scanner.nextInt();
            }else {
                Print.out("Please enter a number!",true);
            }
        }

        Player[] players = new Player[numOfPlayers];

        Print.out("\nEnter initial money of Players: ",true);
        Scanner scanner = new Scanner(System.in);
        int money=scanner.nextInt();

        Print.out("\nEnter names of Players: ",true);

        for (int i = 0; i < numOfPlayers; i++) {
            String nameOfPlayer = new Scanner(System.in).nextLine();
            players[i] = new Player(nameOfPlayer, new Piece(board.getSquare(0),i));
            players[i].setMoney(money);
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
