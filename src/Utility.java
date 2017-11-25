public class Utility extends Square {
    private int price = 150;
    private Player owner ;

    public Utility(String name, int index) {
        super(name, index);
    }

    public void Operation(Player player, Board board) {
        if (getOwner()==null) {
            Die rolling = new Die();
            int roll = rolling.getFaceValue();
            if (roll > 4 && ( player.getMoney() >= getPrice())) {
                System.out.println(roll);
                setOwner(player);
                player.setMoney(-getPrice());
                 System.out.println(getName()+"'s Owner is "+getOwner().getName()+ player.getMoney());
            }
        } else if ((player == getOwner())) { // Square sahibi ile landon player aynı kişi
                System.out.println(getOwner().getName() +"is owner do nothing");
            } else {
                Die rolling = new Die();
                int roll = rolling.getFaceValue();
                int rent = 10 * roll;
                player.setMoney(-rent);
                getOwner().setMoney(rent);
                System.out.println(rent + " rent is paid to " + getOwner().getPiece().getName());
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


