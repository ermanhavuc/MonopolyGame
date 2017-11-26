import java.io.IOException;

public class LotSquare extends Square {

    private int price;
    private int rent;
    private Player owner = null;

    public LotSquare(String name ,int index, int price, int rent){

        super(name, index);
        this.price = price;
        this.rent = rent;
    }

    @Override
    public void Operation(Player player, Board board) throws IOException {

        if (getOwner() == null) {
            Die rolling = new Die();
            int roll = rolling.getFaceValue();
            Print.out(roll+"",true);
            if (roll > 4 && (player.getMoney() >= getPrice())) {
                player.setMoney(-getPrice());
                setOwner(player);
                Print.out(getName()+"'s Owner is "+getOwner().getName()+ player.getMoney(),true);
            }
        }else if (player == getOwner()) {
            Print.out(getOwner().getName() + "is owner do nothing",false);
        }else {
            player.setMoney(-rent);
            getOwner().setMoney(rent);
            Print.out(rent + " rent is paid.",false);
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
