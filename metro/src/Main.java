import classes.Metro;

public class Main {
    // Main method for testing
    public static void main(String[] args) {
        Metro metro = new Metro();
        metro.addStation("StationA");
        metro.addStation("StationB");
        metro.addStation("StationC");
        metro.addStation("StationD");

        metro.addPath("StationA", "StationB");
        metro.addPath("StationA", "StationC");
        metro.addPath("StationB", "StationD");
        metro.addPath("StationC", "StationD");

        metro.displayGraph();
    }
}
