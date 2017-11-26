import java.io.IOException;

public class IncomeTaxSquare extends Square { // Income Tax square if player lands on ,player must pay money

    public IncomeTaxSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) throws IOException {
        if (player.getMoney()>0) {
         int tax = player.getMoney() / 10; // if player have enough money to pay tax ,player will pay
            player.setMoney(-tax);
            Print.out("Paid " + tax + "$ to Bank", true);
        }else{
            player.setBankruptcyStat(); // player doesn't have enough money ,player must leave from game
            Print.out(player.getName()+"is BANKRUPTED",true);
        }
    }
}