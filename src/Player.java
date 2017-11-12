@SuppressWarnings("WeakerAccess")
public class Player {   //player object

    private String name;
    private Piece piece;
    private int money = 200;
    private int oldMoney = 200;

    public Player(String name, Piece piece) { //player constructor

        this.name = name;
        this.piece = piece;
    }

    public Square getLocation() {

        return this.piece.getLocation();
    }

    public Square getOldLocation() {

        return this.piece.getOldLocation();
    }

    public Piece getPiece() {

        return piece;
    }

    public String getName() {

        return name;
    }

    public int getMoney(){

        return money;
    }

    public void setMoney(int valueToChange) {

        oldMoney = money;
        money += valueToChange;
    }

    public int getOldMoney() {

        return oldMoney;
    }
}
