package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
	private StationRepository stationRepository;
	private LineRepository lineRepository;

	public void play() {
		OutputView.showMainFunctionList();
		while (true) {
			if (InputView.selectMainFunction().equals("1")) {
				OutputView.showStationFunctionList();
				String selectStationOption = InputView.selectStationFunction();
				if (selectStationOption.equals("1")) {
					saveSubway();
				}
			}
		}
	}

	public void saveSubway() {
		try {
			StationRepository.addStation(new Station(InputView.inputStationToSave()));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			saveSubway();
		}
	}

	public void showSubway() {
		OutputView.showStationList(StationRepository.castingStationsToString());
	}

}
