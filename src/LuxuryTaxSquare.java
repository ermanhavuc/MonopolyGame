import java.io.IOException;

public class LuxuryTaxSquare extends Square {

    public LuxuryTaxSquare (String name, int index){

        super(name,index);
    }

    @Override
    public void Operation(Player player, Board board) throws IOException { // if player lands on this square ,must pay tax
        int tax=75;
        if(player.getMoney()>=tax){ // Player can have enough money to pay a rent ,player will pay
            player.setMoney(-75);
            Print.out("Paid 75$ to Bank.. ",true);
        }else{
            player.setBankruptcyStat(); // if player can't have enough money to pay a rent ,player must leave from game
            Print.out(player.getName()+"is BANKRUPTED",true);
        }

    }
}