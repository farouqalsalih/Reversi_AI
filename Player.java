public class Player 
{
    private String name;
    private int score;
    private char symbol;

    public Player(String name)
    {
        setName(name);
    }

    public Player(String name, char symbol)
    {
        setName(name);
        setSymbol(symbol);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getScore()
    {
        return this.score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public char getSymbol()
    {
        return this.symbol;
    }

    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }
}
