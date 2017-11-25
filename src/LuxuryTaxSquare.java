import java.io.IOException;

public class LuxuryTaxSquare extends Square {

    public LuxuryTaxSquare (String name, int index){

        super(name,index);
    }

    @Override
    public void Operation(Player player, Board board) throws IOException {

        player.setMoney(-75);
        Print.out("Paid 75$ to Bank.. ",true);
    }
}