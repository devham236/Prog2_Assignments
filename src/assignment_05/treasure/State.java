package assignment_05.treasure;

public interface State {
    public State transition(Action action);
    public String str();
    public String info();
}
