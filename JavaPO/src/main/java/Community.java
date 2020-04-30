public class Community {
    private int population;
    private int suspective;
    private int infected;
    private int removed;
    private int isolated;

    Community() {
        population = 0;
    }

    public void setPopulation(int population) throws Exception {
        if (population > 0) {
            this.population = population;
            this.infected = 0;
            this.removed = 0;
            this.isolated = 0;
        } else throw new Exception(); // todo lepsza nazwa exception
    }

    public int getPopulation() {
        return population;
    }

    public int getSuspective() {
        return suspective;
    }

    public void setSuspective(int suspective) {
        this.suspective = suspective;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public int getRemoved() {
        return removed;
    }

    public void setRemoved(int removed) {
        this.removed = removed;
    }

    public int getIsolated() {
        return isolated;
    }

    public void setIsolated(int isolated) {
        this.isolated = isolated;
    }
}
