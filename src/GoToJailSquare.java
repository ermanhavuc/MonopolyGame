import java.io.IOException;

public class GoToJailSquare extends Square{

    public GoToJailSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) throws IOException {

        player.setLocation(board.getSquare(10)); // if player lands on this Square ,player must go to Jail
        player.setInJail(true);
        Print.out("Player " + player.getName() + " is now in jail !",true);
        Print.out("\n" + player.getPiece().getName() + "'s new location is " +
                player.getLocation().getIndex()+": " + player.getLocation().getName(),true);
    }
}