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
		String mainOption = InputView.selectMainFunction();
		while (true) {
			if (mainOption.equals("1")) {
				playStationFunction();
			}
		}
	}

	public void playStationFunction() {
		OutputView.showStationFunctionList();
		String selectStationOption = InputView.selectStationFunction();
		if (selectStationOption.equals("1")) {
			saveSubway();
			return;
		}
		if (selectStationOption.equals("2")) {
			deleteSubway();
			return;
		}
		if (selectStationOption.equals("3")) {
			showSubway();
			return;
		}
		if (selectStationOption.equals("B")) {
			return;
		}
	}

	public void saveSubway() {
		try {
			int beforeInputSize = StationRepository.getStationListSize();
			StationRepository.addStation(new Station(InputView.inputStationToSave()));
			int afterInputSize = StationRepository.getStationListSize();
			if (beforeInputSize < afterInputSize) {
				OutputView.showStationSaveComplete();
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			saveSubway();
		}
	}

	public void deleteSubway() {
		boolean isDelete = StationRepository.deleteStation(InputView.inputStationToDelete());
		if (isDelete) {
			OutputView.showStationDeleteComplete();
		}
	}

	public void showSubway() {
		OutputView.showStationList(StationRepository.castingStationsToString());
	}

}
