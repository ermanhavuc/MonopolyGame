import java.io.IOException;

public class IncomeTaxSquare extends Square {

    public IncomeTaxSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) throws IOException {

        int tax = player.getMoney()/10;
        player.setMoney(-tax);
        Print.out("Paid "+ tax +"$ to Bank",true);
    }
}