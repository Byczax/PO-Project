enum HumanState {
    ZDROWY(0),
    CHORY(1),
    USUNIETY(2);

    int state;

    HumanState(int state) {
        this.state = state;
    }


}

public class Human {
    public int Central_location;
    public float Social_distancing;
    public float Travel_rate;
    public HumanState state;
    public boolean hasBeenAffected;

    Human() {
        state=HumanState.ZDROWY;
    }
}
