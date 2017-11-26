import java.io.IOException;

public class Utility extends Square {
    private int price = 150;
    private Player owner ;

    public Utility(String name, int index) {
        super(name, index);
    }

    public void Operation(Player player, Board board) throws IOException {
        if (getOwner() == null) {
            Die rolling = new Die();
            int roll = rolling.getFaceValue();
            if (roll > 4 && ( player.getMoney() >= getPrice())) {
                Print.out(roll+"",true);
                setOwner(player);
                player.setMoney(-getPrice());
                Print.out(getName()+"'s Owner is "+getOwner().getName()+ player.getMoney(),true);
            }
        } else if ((player == getOwner())) { // Square sahibi ile landon player aynı kişi
                Print.out(getOwner().getName() +"is owner do nothing",true);
            } else {
                Die rolling = new Die();
                int roll = rolling.getFaceValue();
                int rent = 10 * roll;
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

    private void setOwner(Player player) {

        owner = player;
    }


}


