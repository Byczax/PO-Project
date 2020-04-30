public class Community {
    private int population;
    // private int suspective;
    // private int infected;
    // private int removed;
    // private int isolated;
    public Community(int population)
    {
        setpopulation(population);
    }
    
    public void setpopulation(int population) {
        if(population>0)
        this.population = population;
        //else <wyjątek>
    }
    public int getpopulation()
    {
        return population;
    }
}
