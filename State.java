public class State 
{
    private static final char[][] EMPTY_4_BOARD = {{' ', ' ', ' ', ' '}, 
                                                   {' ', 'O', 'X', ' '}, 
                                                   {' ', 'X', 'O', ' '}, 
                                                   {' ', ' ', ' ', ' '}};

    private char[][] board;
    private Player player;
    private int boardSize;
    private int xPiecesCount;
    private int oPiecesCount;



    /*
     * Constructor for creating the first state (an empty board)
     * Takes a player as an argument and a boardSize and creates 
     * a state representing that player's turn to move on an 
     * empty board of that size (Remember, defaults to player's symbol as X)
     */
    public State(Player player, int boardSize)
    {
        this.player = player;
        
        this.boardSize = boardSize;
        if (boardSize == 4)
        {
            this.board = new char[4][4];
            setBoard(EMPTY_4_BOARD);
        }
        else // Need to update this to support other size boards
        {
            System.out.println("You entered the wrong boardsize");
        }

        this.xPiecesCount = 2;
        this.oPiecesCount = 2;
    }

    /*
     * Constructor for creating a state
     * Takes a player and a board of char's as arguments and creates
     * a state representing that player's move on that particular board
     */
    public State(Player player, char[][] board, int boardSize)
    {
        this.player = player;
        setBoard(board);
        this.boardSize = boardSize;
    }


    /*
     * Returns the player for this state
     */
    public Player getPlayer()
    {
        return this.player;
    }

    /*
     * Takes a player as input and sets this state's player
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    /*
     * Returns a board as a char[][]
     */
    public char[][] getBoard()
    {
        return this.board;
    }

    /*
     * Takes an input board as a char[][] and sets the State's board
     */
    public void setBoard(char[][] board)
    {
        for (int row = 0; row < this.boardSize; row++)
        {
            for (int col = 0; col < this.boardSize; col++)
            {
                this.board[row][col] = board[row][col];
            }
        }
    }

    /*
     * Takes a row, col as input and returns the symbol on the board at
     * that position as a char
     */
    public char getBoardAtPos(int row, int col)
    {
        return this.board[row][col];
    }

    /*
     * Takes a char and row, col as inputs and sets the symbol at that position
     */
    public void setBoardAtPos(char symbol, int row, int col)
    {
        this.board[row][col] = symbol;
    }

    /*
     * Takes a row, col as input and returns the symbol on the board at
     * that position as a char
     */
    public int getBoardSize()
    {
        return this.boardSize;
    }

    /*
     * Takes a char and row, col as inputs and sets the symbol at that position
     */
    public void setBoardSize(int boardSize)
    {
        this.boardSize = boardSize;
    }

    /*
     * param:
     *     none
     * Returns the number of x pieces
     */
    public int getXPiecesCount()
    {
        return this.xPiecesCount;
    }

    /*
     * param:
     *     int xPiecesCount
     * Sets the number of x pieces
     */
    public void setXPiecesCount(int xPiecesCount)
    {
        this.xPiecesCount = xPiecesCount;
    }

    /*
     * param:
     *     none
     * Returns the number of o pieces
     */
    public int getOPiecesCount()
    {
        return this.oPiecesCount;
    }

    /* param:
     *     int oPiecesCount
     * Sets the number of o pieces
     */
    public void setOPiecesCount(int oPiecesCount)
    {
        this.oPiecesCount = oPiecesCount;
    }

    /*
     * param:
     *     none
     * Returns the total number of both pieces on the board
     */
    public int getTotalPieces()
    {
        return this.xPiecesCount + this.oPiecesCount;
    }

    /*
     * param:
     *     none
     * Goes through the board and counts the pieces for each side,
     * setting the instance variables to the correct counts.
     */
    public void countPieces()
    {
        int xCount = 0;
        int oCount = 0;
        // Count the number of X's and O's in the final board
        for (int row = 0; row < boardSize; row++)
        {
            for (int col = 0; col < boardSize; col++)
            {
                if (this.getBoardAtPos(row, col) == 'X')
                {
                    xCount++;
                }
                else if (this.getBoardAtPos(row, col) == 'O')
                {
                    oCount++;
                }
            }
        }
        setXPiecesCount(xCount);
        setOPiecesCount(oCount);
    }

    /*
     * Prints the state's board in a pretty format
     */
    public void printBoard()
    {
        char columnIndex = 'a';
        System.out.print(" ");

        // This prints the top row "  a b c d"
        for (int col = 0; col < this.boardSize; col++) 
        {
            System.out.print(" " + columnIndex++);
        }
        System.out.println();

        /*
         * This for loop prints the middle part of the board
         * 0         0
           1   O X   1
           2   X O   2
           3         3
         */
        for (int row = 0; row < this.boardSize; row++)
        {
            System.out.print(row);
            for (int col = 0; col < this.boardSize; col++)
            {
                System.out.print(" " + this.board[row][col]);
            }
            System.out.println(" " + (row));
        }

        columnIndex = 'a'; // Reset the column index to print the bottom row
        System.out.print(" ");

        for (int col = 0; col < this.boardSize; col++) // This prints the bottom row 
                                                       // "  a b c d"
        {
            System.out.print(" " + columnIndex++);
        } 
    }
}
