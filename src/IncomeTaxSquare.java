public class IncomeTaxSquare extends Square {

    public IncomeTaxSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player) {

        int tax = player.getMoney()/10;
        player.setMoney(-tax);
        System.out.println("Paid "+ tax +" $ to the Bank");
    }
}