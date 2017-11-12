public class LuxuryTaxSquare extends Square {

    public LuxuryTaxSquare (String name, int index){

        super(name,index);
    }

    @Override
    public void Operation(Player player) {

        System.out.println("Paid 75$ to the Bank.. ");
        player.setMoney(-75);
    }
}