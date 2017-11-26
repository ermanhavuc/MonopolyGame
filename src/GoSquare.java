import java.io.IOException;

public class GoSquare extends Square { // Start square of monopoly game

    public GoSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) throws IOException { // Operation of this square

        player.setMoney(200);            // if player lands on GoSquare player will receive money from bank
        Print.out("200$ received from Bank",true);
    }
}