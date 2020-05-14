enum HumanState {
    ZDROWY(0),
    CHORY(1),
    CHORY_NIEWYKRYTY(2),
    WYLECZONY(3),
    USUNIETY(4);

    int state;

    HumanState(int state) {
        this.state = state;
    }


}

public class Human {
    private int Central_location;
    private float Social_distancing;
    private float Travel_rate;
    public HumanState state;
    public boolean hasBeenAffected;
    public int ilnessTime;

    Human() {
        state = HumanState.ZDROWY;
    }

}

