enum HumanState {
    HEALTHY(0),
    ILL(1),
    ILL_INV(2),
    CURED(3),
    REMOVED(4);

    int state;

    HumanState(int state) {
        this.state = state;
    }
}

public class Human {
    private HumanState state;
    private boolean has_been_affected;
    private int illness_time;
    private int central_location;
    private float social_distancing;
    private float travel_rate;

    Human() {
        state = HumanState.HEALTHY;
    }

    public HumanState getState() {
        return state;
    }

    public void setState(HumanState state) {
        this.state = state;
    }

    public int getIllnessTime() {
        return illness_time;
    }

    public void setIllnessTime(int illness_time) {
        this.illness_time = illness_time;
    }

    public void plusIlnessTime() {
        illness_time++;
    }

    public boolean isHasBeenAffected() {
        return has_been_affected;
    }

    public void setHasBeenAffected(boolean has_been_affected) {
        this.has_been_affected = has_been_affected;
    }
}

