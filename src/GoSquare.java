import java.io.IOException;

public class GoSquare extends Square {

    public GoSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) throws IOException {

        player.setMoney(200);
        Print.out("200$ received from Bank",true);
    }
}