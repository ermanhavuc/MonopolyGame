public class IncomeTaxSquare extends Square {

    public IncomeTaxSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) {

        int tax = player.getMoney()/10;
        player.setMoney(-tax);
        System.out.println("Paid "+ tax +"$ to Bank");
    }
}