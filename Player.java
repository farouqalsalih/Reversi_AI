public class Player 
{
    private String name;
    private int score;
    private char symbol;

    /*
     * Takes a name as an argument and creates 
     * a new player with the given name and
     * defaults their move symbol to X
     */
    public Player(String name)
    {
        setName(name);
        setSymbol('X');
    }

    /*
     * Takes a name and symbol as arguments and 
     * creates a new player with the given name and
     * symbol
     */
    public Player(String name, char symbol)
    {
        setName(name);
        setSymbol(symbol);
    }

    /*
     * Returns a string that is the Player's name
     */
    public String getName()
    {
        return this.name;
    }

    /*
     * Takes a name as an argument and sets the
     * Player's name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /*
     * Returns an int that is the Player's score
     */
    public int getScore()
    {
        return this.score;
    }

    /*
     * Takes a score as an argument and sets the
     * Player's score
     */
    public void setScore(int score)
    {
        this.score = score;
    }

    /*
     * Returns a character that represents the Player's
     * symbol
     */
    public char getSymbol()
    {
        return this.symbol;
    }

    /*
     * Takes a symbol as an argument and sets the
     * Player's symbol
     */
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }
}
