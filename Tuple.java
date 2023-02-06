public class Tuple {
    private float value;
    private State action;

    public Tuple(float value, State action){
        this.value = value;
        this.action = action;
    }

    public float getValue(){
        return this.value;
    }

    public State getAction(){
        return this.action;
    }
}
