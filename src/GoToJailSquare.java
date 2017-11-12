public class GoToJailSquare extends Square{

    public GoToJailSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) {

        player.setLocation(board.getSquare(10));
        player.setInJail(true);
        System.out.println("Player " + player.getName() + " is now in jail !");
        System.out.println("\n" + player.getPiece().getName() + "'s new location is " +
                player.getLocation().getIndex()+": " + player.getLocation().getName());
    }
}