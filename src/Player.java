import java.util.ArrayList;

public class Player {   //player object

    private String name;
    private Piece piece;
    private int money ;  // kullanıcı konsoldan başlangıç miktarını belirleyecek
    private boolean inJail = false;
    private int failJailRolls = 0;
    private ArrayList<Square> ownerSquares=new ArrayList<>();

    public Player(String name, Piece piece) { //player constructor
        this.name = name;
        this.piece = piece;
    }

    public Square getLocation() {
        return piece.getLocation();
    }

    public void setLocation(Square square) {
        piece.setLocation(square);
    }

    public Square getOldLocation() {
        return piece.getOldLocation();
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

        money += valueToChange;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public boolean isInJail() {
        return inJail;
    }

    public int getFailJailRolls() {
        return failJailRolls;
    }

    public void setFailJailRolls(int failJailRolls) {
        this.failJailRolls = failJailRolls;
    }

    public boolean getBankruptcyStat() {

        return money <= 0;
    }

    public ArrayList<Square> getOwnerSquares(){
        return ownerSquares;
    }
    public void setOwnerSquares(Square location){
        ownerSquares.add(location);
    }
}
