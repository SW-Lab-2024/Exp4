package classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Metro {
    private final Map<Station, List<Station>> adjacencyList;

    public Metro() {
        this.adjacencyList = new HashMap<>();
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
