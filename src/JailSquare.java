public class JailSquare extends Square{

    public JailSquare(String name, int index) {

        super(name, index);
    }

    @Override
    public void Operation(Player player, Board board) {

        if (player.isInJail()) {

            if (player.getFailJailRolls() < 3) {
                System.out.println(player.getFailJailRolls()+1 + ". turn in Jail\n");
                int[] rolledDice = board.rollDice();
                player.setFailJailRolls(player.getFailJailRolls()+1);

                if (rolledDice[1] == rolledDice[2]) {
                    System.out.println("\nPlayer doubled, time to leave Jail !\n");
                    player.setInJail(false);
                    player.setFailJailRolls(0);

                } else {
                    System.out.println("\nWaiting next turn...");
                }
            } else {
                System.out.println("Time to leave Jail !\nPaid 50$ to Bank\n");
                player.setMoney(-50);
                player.setInJail(false);
                player.setFailJailRolls(0);

            }

            if (!player.isInJail()) { // visit jail

                player.getPiece().setLocation(board.calculateSquare(player.getLocation(),board.rollDice()[0]));
                //roll dice and calculate new location then set

                System.out.println("\n" + player.getPiece().getName() + "'s new location is " +
                        player.getLocation().getIndex()+": " + player.getLocation().getName());
            }

        } else {
            System.out.println("Waiting a turn...");
        }
    }
}
