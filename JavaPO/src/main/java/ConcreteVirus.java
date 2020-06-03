public class ConcreteVirus implements Virus {

    @Override
    public InfectedLocations spread(Community community) {
        return null; // some smart way to infect
    }

    @Override
    public int daysToDie() {
        return 5;
    }
}

