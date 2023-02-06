public class Tuple {
    private int value;
    private State action;

    public Tuple(int value, State action){
        this.value = value;
        this.action = action;
    }

    public int getValue(){
        return this.value;
    }

    public State getAction(){
        return this.action;
    }
}
