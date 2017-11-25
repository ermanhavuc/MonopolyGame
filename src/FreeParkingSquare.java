import java.io.IOException;

public class FreeParkingSquare extends Square {

    public FreeParkingSquare(String name, int index){
        super(name,index);
    }

    @Override
    public void Operation(Player player, Board board) throws IOException {

        Print.out("Waiting next turn...",true);
    }
}