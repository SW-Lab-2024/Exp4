package classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metro {
    private final Map<Station, List<Station>> adjacencyList;

    public Metro() {
        this.adjacencyList = new HashMap<>();
    }


    public class Station {
        private final String name;

        public Station(String name) {
            this.name = name;
        }

    }


}
