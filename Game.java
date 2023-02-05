
public class Game {
    Player user;
    Player bot;
    State currentState;

    /*
     * param: 
     *     Player user: This is the user's player
     *     Player bot: This is the AI's player
     *     State currentState: This is the current state of the game (board, and player basically)
     * Creates a Game object with the given players and state
     */
    public Game(Player user, Player bot, State currentState){
        this.user = user;
        this.bot = bot;
        this.currentState = currentState;
    }

    public boolean check(int x, int y){
        int size = currentState.getBoardSize();
        boolean canPlace = false;
        
        //checks if number is valid
        if(x >= size || y >= size || x < 0 || y < 0){
            return false;
        }

        //checks if a piece has already been placed there
        if(currentState.getBoard()[x][y] != ' '){
            return false;
        }

        //checks if you can place, and if so, flips boolean canPlace to true
        char opponent = currentState.getPlayer().getSymbol() == 'X' ? 'O' : 'X';
        
        boolean isPossible = false;

        for(int i = x - 1; i >= 0; i--){
            if(currentState.getBoard()[i][y] == ' '){
                break;
            } else if(currentState.getBoard()[i][y] == opponent){
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        isPossible = false;
        //feels like boilerplatey code, perhaps we could simplify
        for(int i = x + 1; i < size; i++){
            if(currentState.getBoard()[i][y] == ' '){
                break;
            } else if(currentState.getBoard()[i][y] == opponent){
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        isPossible = false;

        for(int i = y - 1; i >= 0; i--){
            if(currentState.getBoard()[x][i] == ' '){
                break;
            } else if(currentState.getBoard()[x][i] == opponent){
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        isPossible = false;

        for(int i = y + 1; i < size; i++){
            if(currentState.getBoard()[x][i] == ' '){
                break;
            } else if(currentState.getBoard()[x][i] == opponent){
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        isPossible = false;

        for(int i = y + 1; i < size; i++){
            if(currentState.getBoard()[x][i] == ' '){
                break;
            } else if(currentState.getBoard()[x][i] == opponent){
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        return canPlace;
    }

    /*
        param: 
            int x: row
            int y: column
        First Checks if the move is possible
        Next, places the move
        Returns a boolean value if move is placed
    */
    public boolean move(int x, int y){
        if(check(x, y)){
            currentState.getBoard()[x][y] = currentState.getPlayer().getSymbol();
            currentState.setPlayer(bot);
            return true;
        }
        
        return false;
    }


    /*
     * param:
     *     none
     * Checks the current state and returns true if the game is over. Otherwise returns false
     */
    public boolean terminalTest()
    {
        // If we have a full board (total num of pieces = boardSize^2), return true
        if (this.currentState.getTotalPieces() == (this.currentState.getBoardSize() * this.currentState.getBoardSize()))
        {
            return true;
        }
        
        /* If the board isn't full, we have to check if there are any valid moves left
         * So, we iterate through the whole board and use the check(int x, int y) method
         * on each square 
         */
        for (int row = 0; row < this.currentState.getBoardSize(); row++)
        {
            for (int col = 0; col < this.currentState.getBoardSize(); col++)
            {
                if (check(row, col)) // If there is ever a valid move, return false
                {
                    return false;
                }
            }
        }
        
        // If we have iterated through the whole board and found 0 moves, 
        // the game is over, and return true
        return true; 
    }


    /*
     *******************************
     *            NOTE:            *
     *******************************
     * I think we should probably have the utility ALWAYS return 1 if human 
     * player wins, and -1 if ai player wins. As it is currently, it asks for
     * which player you check, and will actually return a positive value for
     * the ai player if they are the argument
     */


    /*
     * param:
     *     State terminalState: This is a terminal state of the game
     *     Player player: This is the player whose score we want to check
     * Calculates the "outcome" value of the terminal state for the player.
     * If the player wins, returns 1
     * If it's a draw, returns 0
     * If the player loses, return -1
     */
    public int utility(State terminalState, Player player)
    {
        int xCount = terminalState.getXPiecesCount();
        int oCount = terminalState.getOPiecesCount();

        // If the chosen player has more symbols than the other player, the chosen player wins
        if ((player.getSymbol() == 'X' && xCount > oCount) || (player.getSymbol() == 'O' && oCount > xCount))
        {
            return 1;
        }
        else if (xCount == oCount) // If they have the same number of symbols, it is a tie
        {
            return 0;
        }
        else // Otherwise, the chosen player has fewer symbols, and they lose
        {
            return -1;
        }
    }

    /*
     * param: 
     * Description
     */
    public 

}
