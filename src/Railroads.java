import java.io.IOException;

public class Railroads extends Square {

    private int price = 200;
    private Player owner = null;

    public Railroads(String name, int index) {
        super(name, index);
    }

    public void Operation(Player player, Board board) throws IOException {
        if (getOwner() == null) {
            Die rolling = new Die();
            int roll = rolling.getFaceValue();
            if (roll > 4 && (player.getMoney() >= getPrice())) {
                Print.out(roll+"",true);
                player.setMoney(-getPrice());
                setOwner(player);
                Print.out(getName()+"'s Owner is "+getOwner().getName()+ player.getMoney(),true);
            }else if (!(player.getMoney() >= getPrice())){
                Print.out(player.getName()+" has no enough money for buying this lot.",true);
            }
        }else if (player == getOwner() ) {
            Print.out(getOwner().getName() + "is owner do nothing",true);
        }else {
            Die rolling = new Die();
            int roll = rolling.getFaceValue();
            int rent = 5 * roll + 25;
            player.setMoney(-rent);
            getOwner().setMoney(rent);
            Print.out(rent + " rent is paid to " + getOwner().getPiece().getName(),true);
        }
    }


    private int getPrice() {
        return price;
    }

    private Player getOwner() {
        return owner;
    }

    private void setOwner(Player p) {

        owner = p;
    }

}