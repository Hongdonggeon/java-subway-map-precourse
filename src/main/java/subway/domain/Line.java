package subway.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final String STATION_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 최소 두글자 이상이여야 한다.";
    private static final String NOT_EXIST_STATION_NAME_ERROR_MESSAGE = "입력하신 역이 해당 노선에 존재하지 않습니다.";

    private String name;
    private EndTerminal endTerminal;
    private LinkedList<Station> stations = new LinkedList<>();

    public Line(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public List<String> getStationNames() {
        return stations.stream()
            .map(station -> station.getName())
            .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void saveEndTerminal(String firstStation, String endStation) {
        stations.addFirst(new Station(firstStation));
        stations.addLast(new Station(endStation));
    }

    public void saveStationOrder(Station station, int order) {
        stations.set(order - 1, station);
    }

    public void saveStationOrders(List<Station> stations) {
        this.stations = new LinkedList<>(stations);;
    }

    public Station findStation(String stationName) {
        return stations.stream()
            .filter(station -> station.getName().equals(stationName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_STATION_NAME_ERROR_MESSAGE));
    }

    public void deleteStationOrder(Station station) {
        stations.remove(station);
    }

    public static void validateNameLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(STATION_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
