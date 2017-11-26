import java.io.IOException;

public class LotSquare extends Square {

    private int price;
    private int rent;
    private Player owner = null;

    public LotSquare(String name, int index, int price, int rent) { // create lots with name ,index,price,rent

        super(name, index);
        this.price = price;
        this.rent = rent;
    }

    @Override
    public void Operation(Player player, Board board) throws IOException {

        if (getOwner() == null) { // if Square is not Owned yet.
            Die rolling = new Die();
            int roll = rolling.getFaceValue();

            if (roll > 4 && (player.getMoney() >= getPrice())) { // Player can buy if dice facevalue>4 and player have enough money to Purchase Square
                Print.out(roll + "", true);
                player.setMoney(-getPrice());
                setOwner(player);
                Print.out(getName() + "'s Owner is " + getOwner().getName() + player.getMoney(), true);
            } else if (!(player.getMoney() >= getPrice()) || roll <= 4) {
                Print.out(roll + "", true);
                Print.out(player.getName() + " has no enough money for buying this lot.", false);
            }
        }else if (player == getOwner()) {                       //If player lands on square is owner of square ,Player will do nothing
            Print.out(getOwner().getName() + "is owner do nothing", false);
        } else if (player.getMoney() >= rent) {                // if player lands on is different from owner ,player must pay a rent
            player.setMoney(-rent);
            getOwner().setMoney(rent);
            Print.out(rent + " rent is paid.", false);
        } else {                                                // if player can't pay the rent ,Player must leave from the game
            player.setBankruptcyStat();
            Print.out(player.getName()+" is BANKCRUPTED!!!",false);

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

