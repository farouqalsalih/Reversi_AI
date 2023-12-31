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

    /*
     * Param:
     *  row: where you want to place and flip from
     *  col: where you want to place and flip from
     *  s: state to do flipping
     *  opponent: opponent symbol
     *  functions: the direction to flip
     * Description:
     *  Flips tokens
     */

    public void flip(int row, int col, State s, char opponent, ArrayList<Integer> functions){
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
        
        ArrayList<Integer> functions = check(x, y, this.currentState);
        if(functions.size() > 0){
            this.currentState.setBoardAtPos(this.currentState.getPlayer().getSymbol(), x, y);
            
            char opponent = this.currentState.getPlayer().getSymbol() == 'X' ? 'O' : 'X';

            flip(x, y, this.currentState, opponent, functions);

            return true;
        }
        
        return false;
    }


    /*
     * param:
     *  Receives a scanner object
     * Description:
     *  Determines if the input is a number, and if so, returns that number
     */
    public int checkNumber(Scanner scanner){
        String value = scanner.nextLine();
        int valueInt;
        while(true){
            try {
                valueInt = Integer.parseInt(value);
                break;
            } catch (Exception e){
                System.out.println("Enter a number");
                value = scanner.nextLine();
            }
        }
        
        return valueInt;
    }

    /*
     * param:
     *     scanner object
     *     game Choice (4x4, 6x6, or 8x8)
     * Game loop function
     */
    public void playGame(Scanner scanner, int gameChoiceInt)
    {
        int row;
        int col;        
        
        currentState.printBoard();
        while (!terminalTest(currentState))
        {
            System.out.println("\nEnter your move in row-col format like 11 to represent b1");
            
            while(true){
                row = checkNumber(scanner);
                col = checkNumber(scanner);
                if(move(row, col)){
                    break;
                } else {
                    System.out.println("Invalid move");
                }
            }
            
            currentState.setPlayer(bot);
            currentState.printBoard();
            if (gameChoiceInt == 4) // Game size of 4, runs minimax perfectly
            {
                this.currentState = minimax(currentState);
            }
            else if (gameChoiceInt == 6) // Game size of 6, runs alpha beta pruning with inf depth
            {
                this.currentState = alphabeta(currentState, Integer.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, true).getAction();
            }
            else if (gameChoiceInt == 8) // Game size of 8, a/b pruning with depth 20
            {
                this.currentState = alphabeta(currentState, 10, Float.MIN_VALUE, Float.MAX_VALUE, true).getAction();
            }
            System.out.println();
            currentState.printBoard();
            currentState.setPlayer(user);

        }

        System.out.println("Score:\n"+ "X: " + this.currentState.getXPiecesCount() + " " + "O: " + this.currentState.getOPiecesCount());

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
     * Basically a utility function that is used when we want the heuristic at
     * our specified depth
     */
    public float heuristicFunction(State state)
    {
        state.countPieces();
        int xCount = state.getXPiecesCount();
        int oCount = state.getOPiecesCount();
        return ((float)oCount - (float)xCount) / (float)state.getTotalPieces();
    }

    /*
     * param:
     *     State state: The state from which we are checking the next states
     * Returns an ArrayList of all possible next states
     */
    public ArrayList<State> getActions (State state)
    {
        ArrayList<State> actionsList = new ArrayList<State>();

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

                    flip(row, col, s, opponent, functions);
                    actionsList.add(s);
                }
            }
        } 

        return actionsList;
    }
    
    /*
     * Param: current state, the depth, alpha, beta, and if it's the maximizingPlayer's turn
     * Description:
     *  Finds optimal move for AI based on depth with alpha-beta pruning and heuristic function
     */
    public Tuple alphabeta(State state, int depth, float alpha, float beta, boolean maximizingPlayer){
        if(depth == 0 || terminalTest(state)){
            return new Tuple(heuristicFunction(state), state);
        }
        if(maximizingPlayer){
            float value = Float.MIN_VALUE;
            ArrayList<State> actionsList = getActions(state);
            State aiMoveState = actionsList.get(0);

            for(State action : actionsList){
                float result = alphabeta(action, depth - 1, alpha, beta, false).getValue();
                if(result > value){
                    value = result;
                    aiMoveState = action;
                }
                if(value > beta){
                    break;
                }
                alpha = Math.max(alpha, value);
            }
            return new Tuple(value, aiMoveState);
        } else {
            float value = Float.MAX_VALUE;
            ArrayList<State> actionsList = getActions(state);
            State aiMoveState = actionsList.get(0);

            for(State action : actionsList){
                float result = alphabeta(action, depth - 1, alpha, beta, true).getValue();
                if(result < value){
                    value = result;
                    aiMoveState = action;
                }
                if(value < alpha){
                    break;
                }
                beta = Math.max(beta, value);
            }
            return new Tuple(value, aiMoveState);
        }
    }


    /*
     * param: receives state
     * Description:
     *  Determines optimal move for AI to choose from children
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
