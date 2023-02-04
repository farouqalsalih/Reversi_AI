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

        // Create the two players and the initial game state
        Player userPlayer = new Player(playerName);
        Player aiPlayer = new Player("Bot", 'O');
        State initialGameState = new State(userPlayer, gameChoice);

        

        initialGameState.printBoard(); // Print the board



        scanner.close(); // Always close your scanners!
    }
}
