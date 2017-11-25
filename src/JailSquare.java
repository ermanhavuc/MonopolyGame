import java.io.IOException;

public class JailSquare extends Square{

    public JailSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) throws IOException {

        if (player.isInJail()) {

            if (player.getFailJailRolls() < 3) {
                Print.out(player.getFailJailRolls()+1 + ". turn in Jail\n",true);
                int[] rolledDice = board.rollDice();
                player.setFailJailRolls(player.getFailJailRolls()+1);

                if (rolledDice[1] == rolledDice[2]) {
                    Print.out("\nPlayer doubled, time to leave Jail !\n",true);
                    player.setInJail(false);
                    player.setFailJailRolls(0);

                } else {
                    Print.out("\nWaiting next turn...",true);
                }
            } else {
                Print.out("Time to leave Jail !\nPaid 50$ to Bank\n",true);
                player.setMoney(-50);
                player.setInJail(false);
                player.setFailJailRolls(0);

            }

            if (!player.isInJail()) { // visit jail

                player.getPiece().setLocation(board.calculateSquare(player.getLocation(),board.rollDice()[0]));
                //roll dice and calculate new location then set

                Print.out("\n" + player.getPiece().getName() + "'s new location is " +
                        player.getLocation().getIndex()+": " + player.getLocation().getName(),true);
            }

        } else {
            Print.out("Waiting a turn...",true);
        }
    }
}
