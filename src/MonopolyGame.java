import java.util.Scanner;

public class MonopolyGame {

    private static final int RoundsNumber = 5;  //number of rounds

    private Board board = new Board();

    public MonopolyGame() {

        System.out.println("Welcome to Monopoly Simulation !\n");
        playGame(buildPlayers());  //game starts
    }

    private void playGame(Player[] players) {

        for (int i = 0; i < RoundsNumber; i++) {
            System.out.println("----Round "+(i+1)+"----\n");

            for (Player player : players) { //take turns in the round
                if (!player.getBankruptcyStat()) {
                    playTurn(player);
                }
            }
        }

        System.out.println("Game finished !");
    }

    private Player[] buildPlayers() {

        int numOfPlayers = 0;

        while (numOfPlayers < 2 || numOfPlayers > 8) {
            System.out.print("Enter number of Players betweeen 2 and 8: ");
            numOfPlayers = new Scanner(System.in).nextInt();
        }

        Player[] players = new Player[numOfPlayers];

        System.out.println("\nEnter names of Players: ");

        for (int i = 0; i < numOfPlayers; i++) {
            String nameOfPlayer = new Scanner(System.in).nextLine();
            players[i] = new Player(nameOfPlayer, new Piece(board.getSquare(0),i));
        }

        System.out.println("\nGame Starting...\n\n");

        return players;
    }

    private void controlGoSquare(Player player) {

        if (player.getOldLocation().getIndex() - player.getLocation().getIndex() > 0 &&
                player.getLocation().getIndex() != 30) {
            player.setMoney(200);
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
