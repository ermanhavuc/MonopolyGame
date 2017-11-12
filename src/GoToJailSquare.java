public class GoToJailSquare extends Square{

    public GoToJailSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) {

        player.setLocation(board.getSquare(30));
        player.setInJail(true);
    }
}