package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {
    private static final String NOT_EXIST_STATION_NAME_ERROR_MESSAGE = "[ERROR] 입력하신 역이 존재하지 않습니다.";
    private static final String DUPLICATED_STATION_ERROR_MESSAGE = "[ERROR] 중복된 역을 저장할 수 없습니다.";

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateDuplicatedStation(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<String> castingStationsToString() {
        return stations.stream()
            .map(station -> station.getName())
            .collect(Collectors.toList());
    }

    public static int getStationListSize() {
        return stations.size();
    }

    public static Station findStation(String stationName) {
        return stations.stream()
            .filter(station -> station.getName().equals(stationName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_STATION_NAME_ERROR_MESSAGE));
    }

    public static boolean isContainStation(Station station) {
        return stations.contains(station);
    }

    public static void validateDuplicatedStation(Station addStation) {
        if(isContainStation(addStation))
            throw new IllegalArgumentException(DUPLICATED_STATION_ERROR_MESSAGE);
    }
}
