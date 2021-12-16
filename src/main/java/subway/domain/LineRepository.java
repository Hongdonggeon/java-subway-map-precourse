package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
    private static final String NOT_EXIST_LINE_NAME_ERROR_MESSAGE = "[ERROR] 입력하신 노선이 존재하지 않습니다.";
    private static final String DUPLICATED_LINE_ERROR_MESSAGE = "[ERROR] 중복된 노선을 저장할 수 없습니다.";

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validateDuplicatedLine(line);
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static int getLineListSize() {
        return lines.size();
    }

    public static List<String> castingLinesToString() {
        return lines.stream()
            .map(line -> line.getName())
            .collect(Collectors.toList());
    }

    public static Line findLine(String lineName) {
        return lines().stream()
            .filter(line -> line.getName().equals(lineName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_LINE_NAME_ERROR_MESSAGE));
    }

    public static boolean isContainLine(Line line) {
        return lines.contains(line);
    }

    public static void validateDuplicatedLine(Line line) {
        if(isContainLine(line))
            throw new IllegalArgumentException(DUPLICATED_LINE_ERROR_MESSAGE);
    }
}
