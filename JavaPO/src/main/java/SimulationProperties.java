public class SimulationProperties {
    private final int population;
    private final int infectionChance;
    private final int range;
    private final int delay;

    /**
     * Get and set parameters from user
     *
     * @param population      get population
     * @param range           get virus range
     * @param infectionChance get virus infection chance
     * @param delay           get discover delay
     */
    public SimulationProperties(int population, int range, int infectionChance, int delay) {
        this.population = population;
        this.infectionChance = infectionChance;
        this.range = range;
        this.delay = delay;
    }

    public int getPopulation() {
        return population;
    }

    public int getInfectionChance() {
        return infectionChance;
    }

    public int getRange() {
        return range;
    }

    public int getDelay() {
        return delay;
    }

}
