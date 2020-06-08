public class Infection {
    private int daysInfected = 0;
    private final Human human;

    private final int daysToDie;

    public Infection(Human human, int daysToDie) {
        this.human = human;
        this.daysToDie = daysToDie;
    }

    void nextDay() {
        daysInfected++;
    }

    boolean isSevere() {
        return daysInfected >= daysToDie;
    }

    public Human getHuman() {
        return human;
    }
}
