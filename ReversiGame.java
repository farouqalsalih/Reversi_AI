import java.util.Scanner;

public class ReversiGame 
{
    


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Reversi by Daniel Nadj and Farouq Alsalih\n");
        System.out.println("\n4. Small 4x4 Reversi\n6. Standard 6x6 Reversi\n8. Standard 8x8 Reversi\n");
        System.out.print("Enter the number of your choice (4 or 8): ");
        int gameChoice =  Integer.parseInt(scanner.nextLine());
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Create the two players and the initial game state
        Player userPlayer = new Player(playerName);
        Player aiPlayer = new Player("Bot", 'O');
        State initialGameState = new State(userPlayer, gameChoice);

        Game game = new Game(userPlayer, aiPlayer, initialGameState);
        game.playGame();

        // game.currentState.printBoard();

        /*System.out.print("Enter your move in row-col format like 11 to represent b1");
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());*/
        
        //call playGame

        // System.out.println(game.move(row, col));
        // game.currentState.printBoard();

        /*char[][] board1 = {{' ', ' ', ' ', ' '}, 
                           {' ', 'O', 'X', ' '}, 
                           {' ', 'X', 'O', ' '}, 
                           {' ', ' ', ' ', ' '}};*/

        

    
        //initialGameState.printBoard(); // Print the board

        //player plays here


        scanner.close(); // Always close your scanners!
    }

    //playGame function
}
