import java.util.Scanner;

public class MonopolyGame {

    private static final int RoundsNumber = 20;  //number of rounds

    private Board board = new Board();  //create board object

    public MonopolyGame() {

        System.out.println("Welcome to Monopoly Simulation !\n");
        playGame(buildPlayers());  //game starts
    }

    private void playGame(Player[] players) {    //for each round, every player has a turn

        for (int i = 0; i < RoundsNumber; i++) {
            System.out.println("----Round "+(i+1)+"----\n");

            for (Player player : players) { //take turns in the round
                System.out.println("- " + player.getName() + " (" + player.getMoney() + "$) is taking turn:\n");
                System.out.println(player.getPiece().getName() + " is at " + player.getLocation().getIndex() + ": " +
                        player.getLocation().getName() + "\n");

                if (!player.isInJail()) {

                    player.getPiece().setLocation(board.calculateSquare(player.getLocation(),diceRollControl(player)[0]));
                    //roll dice and calculate new location then set

                    controlGoSquare(player);

                    System.out.println("\n" + player.getPiece().getName() + "'s new location is " +
                            player.getLocation().getIndex()+": " + player.getLocation().getName());
                }

                player.getLocation().Operation(player, board);

                System.out.println("\n\n");
            }
        }

        System.out.println("Game finished !");
    }

    private Player[] buildPlayers() {   //build players

        int numOfPlayers = 0;

        while (numOfPlayers < 2 || numOfPlayers > 8) {

            System.out.print("Enter number of Players betweeen 2 and 8: ");
            numOfPlayers = new Scanner(System.in).nextInt();
        }

        Player[] players = new Player[numOfPlayers]; //create player array

        System.out.println("\nEnter names of Players: ");

        for (int i = 0; i < numOfPlayers; i++) { //player objects created with names

            String nameOfPlayer = new Scanner(System.in).nextLine();
            players[i] = new Player(nameOfPlayer, new Piece(board.getSquare(0),i));
        }

        System.out.println("\nGame Starting...\n\n");   //game starting message

        return players;
    }

    private void controlGoSquare(Player player) {

        if (player.getOldLocation().getIndex() - player.getLocation().getIndex() > 0 &&
                player.getLocation().getIndex() != 30) {

            player.setMoney(200);
            System.out.println("Player passed Go Square, 200$ received from Bank");
        }
    }

    public int[] diceRollControl(Player player) {

        int doubleCount = 0;
        int returnValues[] = {0};

        do {
            if (doubleCount == 3) {
                player.setLocation(board.getSquare(10));
                player.setInJail(true);
                System.out.println("Player " + player.getName() + " is now in jail !");
                System.out.println("\n" + player.getPiece().getName() + "'s new location is " +
                        player.getLocation().getIndex()+": " + player.getLocation().getName());
                break;
            }

            returnValues = board.rollDice();
            doubleCount++;
        } while (returnValues[1] == returnValues[2]);

        return returnValues;

    }

}
