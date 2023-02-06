import java.util.Scanner;

public class ReversiGame 
{
    public static void main(String[] args)
    {        
        System.out.println("Reversi by Daniel Nadj and Farouq Alsalih\n");
        replay();
    }

    public static void replay(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\n4. Small 4x4 Reversi (minimax)\n6. Standard 6x6 Reversi (alpha-beta pruning)\n8. Standard 8x8 Reversi (alpha-beta pruning and heuristic at depth 20)\n");
            System.out.print("Enter the number of your choice (4, 6, or 8): ");
            String gameChoice = scanner.nextLine();
            int gameChoiceInt;

            while(true){
                if(!gameChoice.equals("4") && !gameChoice.equals("6") && !gameChoice.equals("8")){
                    System.out.println("Please enter a valid choice");
                } else {
                    gameChoiceInt = Integer.parseInt(scanner.nextLine());
                    break;
                }
            }
            
            System.out.print("Enter your name: ");
            String playerName = scanner.nextLine();

            // Create the two players and the initial game state
            Player userPlayer = new Player(playerName);
            Player aiPlayer = new Player("Bot", 'O');
            State initialGameState = new State(userPlayer, gameChoiceInt);
            Game game = new Game(userPlayer, aiPlayer, initialGameState);
            game.playGame();

            System.out.println("Type 'quit' if you want to quit, else type anything/enter");
            if(scanner.nextLine().equals("quit")){
                break;
            }
        }
        
        scanner.close(); // Always close your scanners!
    }
}
