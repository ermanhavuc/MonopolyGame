import java.io.IOException;

public class Utility extends Square {
    private int price = 150;
    private Player owner ;

    public Utility(String name, int index) {
        super(name, index);
    }

    public void Operation(Player player, Board board) throws IOException {
        if (getOwner() == null) { // if square is not owned ,player will roll a dice
            Die rolling = new Die();
            int roll = rolling.getFaceValue();
            if (roll > 4 && (player.getMoney() >= getPrice())) {  // if dice >4 and player have enough money to purchase the square
                Print.out(roll + "", true);
                setOwner(player);
                player.setMoney(-getPrice());
                Print.out(getName() + "'s Owner is " + getOwner().getName() + player.getMoney(), true);
            } else if (!(player.getMoney() >= getPrice()) || roll <= 4) {
                Print.out(roll + "", true);
                Print.out(player.getName() + " has no enough money for buying this lot.", true);
            }
        }else if ((player == getOwner())) { // if owner of square and player is  the same player
            Print.out(getOwner().getName() + "is owner do nothing", true);
            }else
                { // if owner of square and player is not  the same player ,player will roll a dice
            Die rolling = new Die();
            int roll = rolling.getFaceValue();
            int rent = 10 * roll;
            if (player.getMoney()>=rent) { // if player have enough money to pay a rent, will pay
                player.setMoney(-rent);
                getOwner().setMoney(rent);
                Print.out(rent + " rent is paid to " + getOwner().getPiece().getName(), true);
            }else{ // otherwise player must leave from the game
                player.setBankruptcyStat();
                Print.out(player.getName()+" is BANKRUPTED!!!",true);
            }
        }  //
    }
    private int getPrice() {
        return price;
    }

    private Player getOwner() {
        return owner;
    }

    private void setOwner(Player player) {

        owner = player;
    }


}


