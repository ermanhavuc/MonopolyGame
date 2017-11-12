public class FreeParkingSquare extends Square {

    public FreeParkingSquare(String name, int index){
        super(name,index);
    }

    @Override
    public void Operation(Player player) {

        System.out.println("Waiting next turn...");
    }
}