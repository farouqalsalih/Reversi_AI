import java.util.ArrayList;
import java.util.Scanner;

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

    /*
        Param:
            x: Row
            y: Col
            currentState: game state (store's board)
        Description:
            Checks if a move (row, col) is possible in the game state board 
    */
    public ArrayList<Integer> check(int x, int y, State currentState){
        ArrayList<Integer> functions = new ArrayList<Integer>();
        int size = currentState.getBoardSize();
  
        //checks if number is valid
        if(x >= size || y >= size || x < 0 || y < 0){
            return functions;
        }

        //checks if a piece has already been placed there
        if(currentState.getBoard()[x][y] != ' '){
            return functions;
        }

        //checks if you can place, and if so, flips boolean canPlace to true
        char opponent = currentState.getPlayer().getSymbol() == 'X' ? 'O' : 'X';

        /*
         * 0 = flipVerticalUp
         * 1 = flipVerticalDown
         * 2 = flipHorizontalLeft
         * 3 = flipHorizontalRight
         * 4 = flipDiagonalDownRight
         * 5 = flipDiagonalDownLeft
         * 6 = flipDiagonalUpLeft
         * 7 = flipDiagonalUpRight
         */
        if(flipVerticalUp(x, y, size, opponent, false, currentState)){
            functions.add(0);
        }
        if(flipVerticalDown(x, y, size, opponent, false, currentState)){
            functions.add(1);
        }
        if(flipHorizontalLeft(x, y, size, opponent, false, currentState)){
            functions.add(2);
        }
        if(flipHorizontalRight(x, y, size, opponent, false, currentState)){
            functions.add(3);
        }
        if(flipDiagonalDownRight(x, y, size, opponent, false, currentState)){
            functions.add(4);
        }
        if(flipDiagonalDownLeft(x, y, size, opponent, false, currentState)){
            functions.add(5);
        }
        if(flipDiagonalUpLeft(x, y, size, opponent, false, currentState)){
            functions.add(6);
        }
        if(flipDiagonalUpRight(x, y, size, opponent, false, currentState)){
            functions.add(7);
        }

        return functions;
    }

    public boolean flipVerticalUp(int x, int y, int size, char opponent, boolean flip, State currentState){
        boolean isPossible = false;

        for(int i = x - 1; i >= 0; i--){
            if(currentState.getBoard()[i][y] == ' '){
                break;
            } else if(currentState.getBoard()[i][y] == opponent){
                if(flip){
                    currentState.setBoardAtPos(opponent == 'X' ? 'O' : 'X', i, y);
                }
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public boolean flipVerticalDown(int x, int y, int size, char opponent, boolean flip, State currentState){
        boolean isPossible = false;

        for(int i = x + 1; i < size; i++){
            if(currentState.getBoard()[i][y] == ' '){
                break;
            } else if(currentState.getBoard()[i][y] == opponent){
                if(flip){
                    currentState.setBoardAtPos(opponent == 'X' ? 'O' : 'X', i, y);
                }
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public boolean flipHorizontalLeft(int x, int y, int size, char opponent, boolean flip, State currentState){
        boolean isPossible = false;

        for(int i = y - 1; i >= 0; i--){
            if(currentState.getBoard()[x][i] == ' '){
                break;
            } else if(currentState.getBoard()[x][i] == opponent){
                if(flip){
                    currentState.setBoardAtPos(opponent == 'X' ? 'O' : 'X', x, i); // error
                }
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public boolean flipHorizontalRight(int x, int y, int size, char opponent, boolean flip, State currentState){
        boolean isPossible = false;

        for(int i = y + 1; i < size; i++){
            if(currentState.getBoard()[x][i] == ' '){
                break;
            } else if(currentState.getBoard()[x][i] == opponent){
                if(flip){
                    currentState.setBoardAtPos(opponent == 'X' ? 'O' : 'X', x, i);
                }
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public boolean flipDiagonalDownRight(int x, int y, int size, char opponent, boolean flip, State currentState){
        boolean isPossible = false;

        int j = y + 1;
        for(int i = x + 1; i < size && j < size; i++, j++){
            if(currentState.getBoard()[i][j] == ' '){
                break;
            } else if(currentState.getBoard()[i][j] == opponent){
                if(flip){
                    currentState.setBoardAtPos(opponent == 'X' ? 'O' : 'X', i, j);
                }
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public boolean flipDiagonalDownLeft(int x, int y, int size, char opponent, boolean flip, State currentState){
        boolean isPossible = false;

        int j = y - 1;
        for(int i = x + 1; i < size && j >= 0; i++, j--){
            if(currentState.getBoard()[i][j] == ' '){
                break;
            } else if(currentState.getBoard()[i][j] == opponent){
                if(flip){
                    currentState.setBoardAtPos(opponent == 'X' ? 'O' : 'X', i, j);
                }
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public boolean flipDiagonalUpLeft(int x, int y, int size, char opponent, boolean flip, State currentState){
        boolean isPossible = false;

        int j = y - 1;
        for(int i = x - 1; i >= 0 && j >= 0; i--, j--){
            if(currentState.getBoard()[i][j] == ' '){
                break;
            } else if(currentState.getBoard()[i][j] == opponent){
                if(flip){
                    currentState.setBoardAtPos(opponent == 'X' ? 'O' : 'X', i, j);
                }
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public boolean flipDiagonalUpRight(int x, int y, int size, char opponent, boolean flip, State currentState){
        boolean isPossible = false;

        int j = y + 1;
        for(int i = x - 1; i >= 0 && j < size; i--, j++){
            if(currentState.getBoard()[i][j] == ' '){
                break;
            } else if(currentState.getBoard()[i][j] == opponent){
                if(flip){
                    currentState.setBoardAtPos(opponent == 'X' ? 'O' : 'X', i, j);
                }
                isPossible = true;
            } else {
                if(isPossible){
                    return true;
                } else {
                    break;
                }
            }
        }

        return false;
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
        //
        
        ArrayList<Integer> functions = check(x, y, this.currentState);
        if(functions.size() > 0){
            this.currentState.setBoardAtPos(this.currentState.getPlayer().getSymbol(), x, y);
            
            char opponent = this.currentState.getPlayer().getSymbol() == 'X' ? 'O' : 'X';
            /*
             * 0 = flipVerticalUp
             * 1 = flipVerticalDown
             * 2 = flipHorizontalLeft
             * 3 = flipHorizontalRight
             * 4 = flipDiagonalDownRight
             * 5 = flipDiagonalDownLeft
             * 6 = flipDiagonalUpLeft
             * 7 = flipDiagonalUpRight
             */
            for(Integer function : functions){
                if(function == 0){
                    flipVerticalUp(x, y, this.currentState.getBoardSize(), opponent, true, this.currentState);
                }
                else if(function == 1){
                    flipVerticalDown(x, y, this.currentState.getBoardSize(), opponent, true, this.currentState);
                }
                else if(function == 2){
                    flipHorizontalLeft(x, y, this.currentState.getBoardSize(), opponent, true, this.currentState);
                }
                else if(function == 3){
                    flipHorizontalRight(x, y, this.currentState.getBoardSize(), opponent, true, this.currentState);
                }
                else if(function == 4){
                    flipDiagonalDownRight(x, y, this.currentState.getBoardSize(), opponent, true, this.currentState);
                }
                else if(function == 5){
                    flipDiagonalDownLeft(x, y, this.currentState.getBoardSize(), opponent, true, this.currentState);
                }
                else if(function == 6){
                     flipDiagonalUpLeft(x, y, this.currentState.getBoardSize(), opponent, true, this.currentState);   
                }
                else if(function == 7){
                    flipDiagonalUpRight(x, y, this.currentState.getBoardSize(), opponent, true, this.currentState);                    
                }
            }

            this.currentState.setPlayer(bot);
            return true;
        }
        
        //flip all the tiles
        //AI does move
        //flip all tiles from AI move
        
        return false;
    }

    // public State move(int x, int y, State state){
    //     System.out.println("Here");
    //     state.printBoard();
    //     State returnState = new State(state.getPlayer(), state.getBoard(), state.getBoardSize());
    //     returnState.printBoard();
    //     if(check(x, y, returnState)){
    //         returnState.setBoardAtPos(returnState.getPlayer().getSymbol(), x, y);
            
    //         //do flips here

    //         if (returnState.getPlayer().getSymbol() == 'X')
    //         {
                
    //             returnState.setPlayer(bot);
    //         }
    //         else
    //         {
    //             returnState.setPlayer(user);
    //         }
    //         return returnState;
    //     }
        
    //     return null;
    // }

    /*
     * param:
     *     none
     * Game loop function
     */
    public void playGame()
    {
        int row;
        int col;
        Scanner scanner = new Scanner(System.in);
        
        
        currentState.printBoard();
        while (!terminalTest(currentState))
        {
            System.out.print("Enter your move in row-col format like 11 to represent b1");
            row = Integer.parseInt(scanner.nextLine());
            col = Integer.parseInt(scanner.nextLine());
            System.out.println(move(row, col));
            currentState.setPlayer(bot);
            currentState.printBoard();
            this.currentState = alphabeta(currentState, 20, Integer.MIN_VALUE, Integer.MAX_VALUE, true).getAction();
            currentState.printBoard();
            currentState.setPlayer(user);

        }

        System.out.println("X: " + this.currentState.getXPiecesCount() + " " + "O: " + this.currentState.getOPiecesCount());

        scanner.close();
    }

    /*
     * param:
     *     none
     * Checks the current state and returns true if the game is over. Otherwise returns false
     */
    public boolean terminalTest(State state)
    {
        state.countPieces();
        // If we have a full board (total num of pieces = boardSize^2), return true
        if (state.getTotalPieces() == (state.getBoardSize() * state.getBoardSize()))
        {
            return true;
        }
        
        /* If the board isn't full, we have to check if there are any valid moves left
         * So, we iterate through the whole board and use the check(int x, int y) method
         * on each square 
         */
        for (int row = 0; row < state.getBoardSize(); row++)
        {
            for (int col = 0; col < state.getBoardSize(); col++)
            {
                if (check(row, col, state).size() > 0) // If there is ever a valid move, return false
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
     * Calculates the "outcome" value of the terminal state for the player.
     * If the player wins, returns -1
     * If it's a draw, returns 0
     * If the player loses, return 1
     */
    public int utility(State terminalState)
    {
        terminalState.countPieces();
        int xCount = terminalState.getXPiecesCount();
        int oCount = terminalState.getOPiecesCount();

        // If the chosen player has more symbols than the other player, the chosen player wins
        if (xCount > oCount)
        {
            return -1;
        }
        else if (xCount == oCount) // If they have the same number of symbols, it is a tie
        {
            return 0;
        }
        else // Otherwise, the chosen player has fewer symbols, and they lose
        {
            return 1;
        }
    }


    /*
     * param:
     *     State state: The state from which we are checking the next states
     * Returns an ArrayList of all possible next states
     */
    public ArrayList<State> getActions (State state)
    {
        ArrayList<State> actionsList = new ArrayList<State>();

        // if (!state.getPlayer().equals(user))
        // {
            for (int row = 0; row < state.getBoardSize(); row++)
            {
                for (int col = 0; col < state.getBoardSize(); col++)
                {
                    ArrayList<Integer> functions = check(row, col, state);
                    if (functions.size() > 0)
                    {
                        State s = new State(bot, state.getBoard(), state.getBoardSize());
                        s.setBoardAtPos(bot.getSymbol(), row, col);
                        char opponent = s.getPlayer().getSymbol() == 'X' ? 'O' : 'X';

                        for(Integer function : functions){
                            if(function == 0){
                                flipVerticalUp(row, col, s.getBoardSize(), opponent, true, s);
                            }
                            else if(function == 1){
                                flipVerticalDown(row, col, s.getBoardSize(), opponent, true, s);
                            }
                            else if(function == 2){
                                flipHorizontalLeft(row, col, s.getBoardSize(), opponent, true, s);
                            }
                            else if(function == 3){
                                flipHorizontalRight(row, col, s.getBoardSize(), opponent, true, s);
                            }
                            else if(function == 4){
                                flipDiagonalDownRight(row, col, s.getBoardSize(), opponent, true, s);
                            }
                            else if(function == 5){
                                flipDiagonalDownLeft(row, col, s.getBoardSize(), opponent, true, s);
                            }
                            else if(function == 6){
                                flipDiagonalUpLeft(row, col, s.getBoardSize(), opponent, true, s);   
                            }
                            else if(function == 7){
                                flipDiagonalUpRight(row, col, s.getBoardSize(), opponent, true, s);                    
                            }
                        }

                        // s.setPlayer(user);
                        actionsList.add(s);
                        //there will be an error here since you're not changing the state, it will be the same copy of the state
                    }
                }
            }
        // }
        

        return actionsList;
    }

    public Tuple alphabeta(State state, int depth, int alpha, int beta, boolean maximizingPlayer){
        if(depth == 0 || terminalTest(state)){
            return new Tuple(utility(state), state);
        }
        if(maximizingPlayer){
            int value = Integer.MIN_VALUE;
            ArrayList<State> actionsList = getActions(state);
            State aiMoveState = actionsList.get(0);

            for(State action : actionsList){
                int result = alphabeta(action, depth - 1, alpha, beta, false).getValue();
                if(result > value){
                    value = result;
                    aiMoveState = action;
                }
                if(value > beta){
                    break;
                }
                alpha = Integer.max(alpha, value);
            }
            return new Tuple(value, aiMoveState);
        } else {
            int value = Integer.MAX_VALUE;
            ArrayList<State> actionsList = getActions(state);
            State aiMoveState = actionsList.get(0);

            for(State action : actionsList){
                int result = alphabeta(action, depth - 1, alpha, beta, true).getValue();
                if(result < value){
                    value = result;
                    aiMoveState = action;
                }
                if(value < alpha){
                    break;
                }
                beta = Integer.max(beta, value);
            }
            return new Tuple(value, aiMoveState);
        }
    }


    /*
     * param: 
     * Description
     */
    public State minimax(State state)
    {
        ArrayList<State> actionsList = getActions(state);
        
        int maxMoveValue = Integer.MIN_VALUE;
        State aiMoveState = actionsList.get(0);
        for (State action : actionsList)
        {
            int moveValue = minimizeValue(action);
            if (moveValue > maxMoveValue)
            {
                maxMoveValue = moveValue;
                aiMoveState = action;
            }
        }
        if (aiMoveState.equals(state))
        {
            System.out.println("No good move was found");
        }
        else
        {
            System.out.println("We found a good move");
        }
        return aiMoveState;
    }

    /*
     * param: 
     * Description
     */
    public int maximizeValue(State state)
    {
        int maxMoveValue = Integer.MIN_VALUE;

        if (terminalTest(state))
        {
            return utility(state);
        }

        ArrayList<State> actionsList = getActions(state);

        for (State action : actionsList)
        {
            maxMoveValue = Integer.max(maxMoveValue, minimizeValue(action));
        }
        
        return maxMoveValue;
    }

    /*
     * param: 
     * Description
     */
    public int minimizeValue(State state)
    {
        int minMoveValue = Integer.MAX_VALUE;

        if (terminalTest(state))
        {
            return utility(state);
        }

        ArrayList<State> actionsList = getActions(state);

        for (State action : actionsList)
        {
            minMoveValue = Integer.min(minMoveValue, maximizeValue(action));
        }

        return minMoveValue;
    }


}
