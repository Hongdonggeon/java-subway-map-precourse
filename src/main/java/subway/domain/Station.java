package subway.domain;

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
}
