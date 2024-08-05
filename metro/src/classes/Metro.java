package classes;

import java.util.*;

public class Metro {
    private final Map<Station, List<Station>> adjacencyList;

    public Metro() {
        this.adjacencyList = new HashMap<>();
    }

    public void addStation(String stationName) {
        Station station = new Station(stationName);
        adjacencyList.putIfAbsent(station, new ArrayList<>());
    }

    public void addPath(String station1Name, String station2Name) {
        Station station1 = getStationByName(station1Name);
        Station station2 = getStationByName(station2Name);

        if (station1 != null && station2 != null) {
            adjacencyList.get(station1).add(station2);
            adjacencyList.get(station2).add(station1); // Assuming undirected graph
        } else {
            throw new IllegalArgumentException("One or both stations not found");
        }
    }

    private Station getStationByName(String stationName) {
        for (Station station : adjacencyList.keySet()) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        return null;
    }

    public Set<Station> getStations() {
        return adjacencyList.keySet();
    }

    public Map<Station, List<Station>> getPaths() {
        return adjacencyList;
    }

    public void displayGraph() {
        for (Map.Entry<Station, List<Station>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " is connected to: ");
            for (Station connectedStation : entry.getValue()) {
                System.out.print(connectedStation + " ");
            }
            System.out.println();
        }
    }

    public class Station {
        private final String name;

        public Station(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }


}
