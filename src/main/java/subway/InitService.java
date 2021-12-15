package subway;

import java.util.Arrays;
import java.util.List;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitService {
	private static final String station1 = "교대역";
	private static final String station2 = "강남역";
	private static final String station3 = "역삼역";
	private static final String station4 = "남부터미널역";
	private static final String station5 = "양재역";
	private static final String station6 = "양재시민의숲역";
	private static final String station7 = "매봉역";
	private static final List<String> initStations = Arrays.asList(station1, station2, station3, station4, station5,
		station6, station7);

	private static final String line1 = "2호선";
	private static final String line2 = "3호선";
	private static final String line3 = "신분당선";
	private static final List<String> initLines = Arrays.asList(line1, line2, line3);

	public static void initStation() {
		initStations.stream()
			.forEach(stationName -> StationRepository.addStation(new Station(stationName)));
	}

	public static void initLine() {
		initLines.stream()
			.forEach(lineName -> LineRepository.addLine(new Line(lineName)));
		LineRepository.findLine(line1)
			.saveStationOrders(
				Arrays.asList(StationRepository.findStation(station1), StationRepository.findStation(station2),
					StationRepository.findStation(station3)));
		LineRepository.findLine(line2)
			.saveStationOrders(
				Arrays.asList(StationRepository.findStation(station1), StationRepository.findStation(station4),
					StationRepository.findStation(station5), StationRepository.findStation(station7)));
		LineRepository.findLine(line3)
			.saveStationOrders(
				Arrays.asList(StationRepository.findStation(station2), StationRepository.findStation(station5),
					StationRepository.findStation(station6)));
	}
}
