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
    private boolean hasBeenAffected;
    private int illnessTime;
    private int centralLocation;
    private float socialDistancing;
    private float travelRate;
    private int x;
    private int y;

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
        return illnessTime;
    }

    public void setIllnessTime(int illness_time) {
        this.illnessTime = illness_time;
    }

    public void plusIlnessTime() {
        illnessTime++;
    }

    public boolean isHasBeenAffected() {
        return hasBeenAffected;
    }

    public void setHasBeenAffected(boolean has_been_affected) {
        this.hasBeenAffected = has_been_affected;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

