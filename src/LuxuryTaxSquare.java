public class LuxuryTaxSquare extends Square {

    public LuxuryTaxSquare (String name, int index){

        super(name,index);
    }

    @Override
    public void Operation(Player player) {

        player.setMoney(-75);
        System.out.println("Paid 75$ to Bank.. ");
    }
}