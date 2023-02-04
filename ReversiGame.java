import java.util.Scanner;

public class ReversiGame 
{
    


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Reversi by Daniel Nadj and Farouq Alsalih\n");
        System.out.println("\n4. Small 4x4 Reversi\n8. Standard 8x8 Reversi\n");
        System.out.print("Enter the number of your choice (4 or 8): ");
        int gameChoice =  Integer.parseInt(scanner.nextLine());
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        Player userPlayer = new Player(playerName);
        State initialGameState = new State(userPlayer, gameChoice);

        initialGameState.setBoardAtPos(userPlayer.getSymbol(), 3, 3);

        initialGameState.printBoard();



        scanner.close();
    }
}
