package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String STATION_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 최소 두글자 이상이여야 한다.";

    private String name;
    private EndTerminal endTerminal;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void saveEndTerminal(EndTerminal endTerminal) {
        this.endTerminal = endTerminal;
    }

    public void saveStationOrder(Station station, int order) {
        stations.set(order - 1, station);
    }

    public static void validateNameLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(STATION_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
