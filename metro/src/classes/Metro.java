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
    public List<String> findPathBFS(String startName, String endName) {
        Station start = getStationByName(startName);
        Station end = getStationByName(endName);

        if (start == null || end == null) {
            throw new IllegalArgumentException("One or both stations not found");
        }

        Queue<Station> queue = new LinkedList<>();
        Map<Station, Station> previous = new HashMap<>();
        Set<Station> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Station current = queue.poll();

            if (current.equals(end)) {
                return reconstructPath(previous, start, end);
            }

            for (Station neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    System.out.println("Connecting " + current.getName() + " to " + neighbor.getName());
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                    // Simulate a delay of 1 second for each connection
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        return null; // No path found
    }

    // Helper method to reconstruct the path
    private List<String> reconstructPath(Map<Station, Station> previous, Station start, Station end) {
        List<String> path = new ArrayList<>();
        for (Station at = end; at != null; at = previous.get(at)) {
            path.add(at.getName());
        }
        Collections.reverse(path);
        return path;
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

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Station station = (Station) obj;
            return Objects.equals(name, station.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }


}
