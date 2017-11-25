public class Railroads extends Square {
    private int price = 200;
    private Player owner=null;
    private boolean isOwnable=true;

    public Railroads(String name, int index) {
        super(name, index);
    }

    public void Operation(Player player, Board board) {
        if ((getOwner()==null) || getIsOwnable()) {
            Die rolling = new Die();
            int roll = rolling.getFaceValue();
            if (roll > 4 && (player.getMoney() >= getPrice())) {
                System.out.println(roll);
                player.setMoney(-getPrice());
                setOwner(player);
                setOwnable(false);
                player.setOwnerSquares(board.getSquare(getIndex()));
                System.out.println("owner is "+getOwner().getName());
            }
        }else if (player==getOwner() ) {
            System.out.print(getOwner().getName() + "is owner do nothing");
        }else {
            Die rolling = new Die();
            int roll = rolling.getFaceValue();
            int rent = 5 * roll + 25;
            player.setMoney(-rent);
            getOwner().setMoney(rent);
            System.out.println(rent + " rent is paid.");
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
    private boolean getIsOwnable(){
        return isOwnable;
    }
    private void setOwnable(boolean x){
        isOwnable=x;
    }
}