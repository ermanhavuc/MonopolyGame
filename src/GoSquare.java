public class GoSquare extends Square {

    public GoSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) {

        player.setMoney(200);
        System.out.println("200$ received from Bank");
    }
}
