package subway.domain;

import java.util.Objects;

public class Station {
    private static final String STATION_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 최소 두글자 이상이여야 한다.";
    private String name;

    public Station(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
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
        Station station = (Station)o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
