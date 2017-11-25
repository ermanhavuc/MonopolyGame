import java.util.ArrayList;
import java.util.Scanner;

public class MonopolyGame {

    //private static final int RoundsNumber = 15;  //number of rounds

    private Board board = new Board();

    public MonopolyGame() {

        System.out.println("Welcome to Monopoly Simulation !\n");
        playGame(buildPlayers());  //game starts
    }

    private void playGame(ArrayList<Player> players) {   // oyunda sadece 1 oyuncu kalana kadar oyun devam edecek iflas eden kirayı ya da vergiyi ödeyemeyen oyundan
        while (players.size() > 1) {
            for (int i=players.size()-1;i>=0;i--) { //take turns in the round
                if (!players.get(i).getBankruptcyStat()) {
                    playTurn(players.get(i));
                } else {
                    players.remove(players.get(i));
                    for(int i=0;i<players.get(i).getOwnerSquares().size();i++){
                        players.get(i).getOwnerSquares().get(i).setOwnable(true); // Arraylist üzerinde her bir squarein satınalınabilir yapıcam
                    }
                    //players.get(i)
                }

            }
        }
        System.out.println("Game finished !");
        System.out.println("Winner is" + "" + players.get(0).getName());
    }
    private  ArrayList<Player> buildPlayers() { //

        int numOfPlayers = 0;

        while (numOfPlayers < 2 || numOfPlayers > 8) {
            System.out.print("Enter number of Players betweeen 2 and 8: ");

            Scanner scanner = new Scanner(System.in);

            if(scanner.hasNextInt()){
                numOfPlayers = scanner.nextInt();
            }else {
                System.out.println("Please enter a number!");
            }
        }

       ArrayList<Player> players = new ArrayList<>();    // return de burda

        System.out.println("\nEnter initial money of Players: ");
        Scanner scanner = new Scanner(System.in);
        int money=scanner.nextInt();

        System.out.println("\nEnter names of Players: ");

        for (int i = 0; i < numOfPlayers; i++) {
            String nameOfPlayer = new Scanner(System.in).nextLine();
            players.add(new Player(nameOfPlayer, new Piece(board.getSquare(0),i))); //
            players.get(i).setMoney(money); //
        }

        System.out.println("\nGame Starting...\n\n");

        return players;
    }

    private void controlGoSquare(Player player) {

        if (player.getOldLocation().getIndex() - player.getLocation().getIndex() > 0 &&
                player.getLocation().getIndex() != 30) {
            player.setMoney(10);
            System.out.println("Player passed Go Square, 200$ received from Bank");
        }
    }

    private void playTurn(Player player) {

        System.out.println("- " + player.getName() + " (" + player.getMoney() + "$) is taking turn:\n");
        System.out.println(player.getPiece().getName() + " is at " + player.getLocation().getIndex() + ": " +
                player.getLocation().getName() + "\n");

        if (!player.isInJail()) {
            int[] dice;
            int doubleCount = 0;

            do {
                dice = board.rollDice();

                if(doubleCount < 3) {
                    player.setLocation(board.calculateSquare(player.getLocation(), dice[0]));
                    //roll dice and calculate new location then set

                    controlGoSquare(player);

                    System.out.println("\n" + player.getPiece().getName() + "'s new location is " +
                            player.getLocation().getIndex() + ": " + player.getLocation().getName());

                    player.getLocation().Operation(player, board);

                    if(dice[1] == dice[2]){
                        doubleCount++;
                        System.out.println("\n");
                    }

                }else {
                    player.setLocation(board.getSquare(10));
                    player.setInJail(true);
                    System.out.println("Player " + player.getName() + " is now in jail !");
                    System.out.println("\n" + player.getPiece().getName() + "'s new location is " +
                            player.getLocation().getIndex()+": " + player.getLocation().getName());
                    break;
                }
            } while (dice[1] == dice[2] && !player.isInJail());

        }else {
            player.getLocation().Operation(player, board);
        }

        System.out.println("\n\n");
    }
}
