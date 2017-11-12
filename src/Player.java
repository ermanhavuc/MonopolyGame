@SuppressWarnings("WeakerAccess")
public class Player {

    private String name;
    private Piece piece;
    private int money = 200;
    private int oldMoney = 200;
    private boolean inJail = false;

    public Player(String name, Piece piece) {

        this.name = name;
        this.piece = piece;
    }

    public Square getLocation() {

        return this.piece.getLocation();
    }

    public void setLocation(Square square) {

        this.piece.setLocation(square);
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

    public void setInJail(boolean inJail) {

        this.inJail = inJail;
    }

    public boolean getInJail() {

        return inJail;
    }
}