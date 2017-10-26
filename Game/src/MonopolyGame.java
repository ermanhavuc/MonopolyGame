import java.util.Scanner;


public class MonopolyGame {

        private static final int RoundsNumber = 5;  //number of rounds
        private static final int DiceNumber = 2;    //number of dices

        private Board board = new Board();  //create board object
        private Die[] dice = new Die[DiceNumber];   // create dice array


    public MonopolyGame(int numOfPlayer) {

        Player[] players = new Player[numOfPlayer]; //create player array

            for (int i = 0; i < DiceNumber; i++) {  //create dice objects
                dice[i] = new Die();
            }

             System.out.println("Enter names of Players: ");

            for (int i = 0; i < numOfPlayer; i++) { //player objects created with names
                Scanner names = new Scanner(System.in);
                String nameOfPlayer = names.nextLine();
                players[i] = new Player(nameOfPlayer, board, dice, new Piece(board.getStartSquare(),i));
            }
            System.out.println("\nGame Starting...\n\n");
            playGame(players);  //game starts
        }

    public void playGame(Player[] players) {    //for each round, every player has a turn

        for (int i = 0; i < RoundsNumber; i++) {
            System.out.println("----Round "+i+"----\n");

            for (Player player : players) { //take turns in the round

                System.out.println("- " + player.getName() + " is taking a turn: \n");
                System.out.println(player.getPieceName() + " is at " + player.getLocation().getIndex() + "\n");
                System.out.println("Rolling dice...");

                int rollTotal=0;

                for(int j=0; j<dice.length; j++){   //roll die

                    dice[j].roll();
                    rollTotal += dice[j].getFaceValue();
                    int diceNumber = j + 1;
                    System.out.println("Dice " + diceNumber + ": " + dice[j].getFaceValue());
                }

                Square newLocation = board.getSquare(player.getLocation(),rollTotal);   //calculate new location
                player.getPiece().setLocation(newLocation); //set new location

                System.out.println("\n" + player.getName() + "'s new location is " + player.getLocation().getIndex()+"\n\n\n");
            }
        }
        System.out.println("Game finished !");
    }
}
