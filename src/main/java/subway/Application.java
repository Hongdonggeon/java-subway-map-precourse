package subway;

import java.util.Scanner;

import subway.controller.SubwayController;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class Application {
    private StationRepository stationRepository;
    private LineRepository lineRepository;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayController controller = new SubwayController(scanner);
        controller.play();
    }
    }

