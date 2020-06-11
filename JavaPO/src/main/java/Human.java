enum humanState {
    HEALTHY(0),
    ILL(1),
    CURED(2),
    REMOVED(3);

    int state;

    humanState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}

public class Human {
    private humanState state;
    private int illnessTime;

    Human() {
        state = humanState.HEALTHY;
        illnessTime = 0;
    }

    public humanState getState() {
        return state;
    }

    public void setState(humanState state) {
        this.state = state;
    }

    public int getIllnessTime() {
        return illnessTime;
    }

    public void setIllnessTime(int illness_time) {
        this.illnessTime = illness_time;
    }

    public void plusIllnessTime() {
        illnessTime++;
    }

}

