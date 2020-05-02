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
    public int Central_location;
    public float Social_distancing;
    public float Travel_rate;
    public HumanState state;
    public boolean hasBeenAffected;
    public int ilnessTime;

    Human() {
        state = HumanState.ZDROWY;
    }

//    public static int Zaraz(Human[][] humans, int infected, int chance) {
//        humans[x][y].state = HumanState.CHORY;
//        humans[x][y].hasBeenAffected = true;
//        return infected++;
//    }
}

