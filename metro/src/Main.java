import classes.Metro;

public class Main {
    // Main method for testing
    public static void main(String[] args) {
        Metro metro = new Metro();
        for (int i = 1; i <= 35; i++) {
            metro.addStation("Station" + i);
        }

        // Adding more complex paths
        metro.addPath("Station1", "Station2");
        metro.addPath("Station1", "Station3");
        metro.addPath("Station2", "Station4");
        metro.addPath("Station3", "Station4");
        metro.addPath("Station4", "Station5");
        metro.addPath("Station5", "Station6");
        metro.addPath("Station6", "Station7");
        metro.addPath("Station7", "Station8");
        metro.addPath("Station8", "Station9");
        metro.addPath("Station9", "Station10");
        metro.addPath("Station10", "Station11");
        metro.addPath("Station11", "Station12");
        metro.addPath("Station12", "Station13");
        metro.addPath("Station13", "Station14");
        metro.addPath("Station14", "Station15");
        metro.addPath("Station15", "Station16");
        metro.addPath("Station16", "Station17");
        metro.addPath("Station17", "Station18");
        metro.addPath("Station18", "Station19");
        metro.addPath("Station19", "Station20");
        metro.addPath("Station20", "Station21");
        metro.addPath("Station21", "Station22");
        metro.addPath("Station22", "Station23");
        metro.addPath("Station23", "Station24");
        metro.addPath("Station24", "Station25");
        metro.addPath("Station25", "Station26");
        metro.addPath("Station26", "Station27");
        metro.addPath("Station27", "Station28");
        metro.addPath("Station28", "Station29");
        metro.addPath("Station29", "Station30");
        metro.addPath("Station30", "Station31");
        metro.addPath("Station31", "Station32");
        metro.addPath("Station32", "Station33");
        metro.addPath("Station33", "Station34");
        metro.addPath("Station34", "Station35");
        metro.addPath("Station35", "Station1");

        // Adding some additional paths to increase complexity
        metro.addPath("Station1", "Station10");
        metro.addPath("Station2", "Station11");
        metro.addPath("Station3", "Station12");
        metro.addPath("Station4", "Station13");
        metro.addPath("Station5", "Station14");
        metro.addPath("Station6", "Station15");
        metro.addPath("Station7", "Station16");
        metro.addPath("Station8", "Station17");
        metro.addPath("Station9", "Station18");
        metro.addPath("Station10", "Station19");
        metro.addPath("Station11", "Station20");
        metro.addPath("Station12", "Station21");
        metro.addPath("Station13", "Station22");
        metro.addPath("Station14", "Station23");
        metro.addPath("Station15", "Station24");
        metro.addPath("Station16", "Station25");
        metro.addPath("Station17", "Station26");
        metro.addPath("Station18", "Station27");
        metro.addPath("Station19", "Station28");
        metro.addPath("Station20", "Station29");
        metro.addPath("Station21", "Station30");
        metro.addPath("Station22", "Station31");
        metro.addPath("Station23", "Station32");
        metro.addPath("Station24", "Station33");
        metro.addPath("Station25", "Station34");
        metro.addPath("Station26", "Station35");
        metro.addPath("Station27", "Station1");
        metro.addPath("Station28", "Station2");
        metro.addPath("Station29", "Station3");
        metro.addPath("Station30", "Station4");
        metro.addPath("Station31", "Station5");
        metro.addPath("Station32", "Station6");
        metro.addPath("Station33", "Station7");
        metro.addPath("Station34", "Station8");
        metro.addPath("Station35", "Station9");

        metro.displayGraph();

        System.out.println("Path from Station1 to Station35: " + metro.findPathNaive("Station1", "Station35"));    }


    }
