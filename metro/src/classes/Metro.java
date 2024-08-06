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

    public List<String> findPathNaive(String startName, String endName) {
        Station start = getStationByName(startName);
        Station end = getStationByName(endName);

        if (start == null || end == null) {
            throw new IllegalArgumentException("One or both stations not found");
        }

        List<String> path = new ArrayList<>();
        Set<Station> visited = new HashSet<>();

        if (dfs(start, end, path, visited)) {
            return path;
        } else {
            return null; // No path found
        }
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


    // Helper DFS method
    private boolean dfs(Station current, Station end, List<String> path, Set<Station> visited) {
        path.add(current.getName());
        visited.add(current);

        if (current.equals(end)) {
            return true;
        }

        for (Station neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, end, path, visited)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
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
