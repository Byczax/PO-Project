public interface Virus {
    // does not modify community
    InfectedLocations spread(Community community);

    int daysToDie();

}
