package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private static final String STATION_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 최소 두글자 이상이여야 한다.";
    private static final String NOT_EXIST_STATION_NAME_ERROR_MESSAGE = "[ERROR] 입력하신 역이 해당 노선에 존재하지 않습니다.";
    private static final String END_STATION_CHANGE_ERROR_MESSAGE = "[ERROR] 노선에 역을 추가할 때에 종착역에 추가할 수 없다.";
    private static final String STATION_NUMBER_IN_LINE_ERROR_MESSAGE = "[ERROR] 노선에 역이 2개 남은 경우에는 역을 삭제할 수 없다.";


    private String name;
    private List<Station> stations = new ArrayList<>();

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
    public void saveEndTerminal(Station firstStation, Station endStation) {
        stations.add(firstStation);
        stations.add(endStation);
    }

    public void saveStationOrder(Station station, int order) {
        if(order == 1)
            throw new IllegalArgumentException(END_STATION_CHANGE_ERROR_MESSAGE);
        List<Station> newStation = Arrays.asList(station);
        stations.addAll(order - 1, newStation);
    }

    public void saveStationOrders(List<Station> stations) {
        this.stations = stations;
    }

    public Station findStationInLine(String stationName) {
        return stations.stream()
            .filter(station -> station.getName().equals(stationName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_STATION_NAME_ERROR_MESSAGE));
    }

    public void deleteStationOrder(Station station) {
        if (stations.size() == 2) {
            throw new IllegalArgumentException(STATION_NAME_LENGTH_ERROR_MESSAGE);
        }
        stations.remove(station);

    }

    public static void validateNameLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(STATION_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Line line = (Line)o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
