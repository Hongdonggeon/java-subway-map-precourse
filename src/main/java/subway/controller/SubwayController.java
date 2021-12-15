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
		String mainOption = InputView.selectWantedFunction();
		while (true) {
			if (mainOption.equals("1")) {
				playStationFunction();
			}
			if (mainOption.equals("2")) {
				playLineFunction();
			}
		}
	}

	public void playStationFunction() {
		OutputView.showStationFunctionList();
		String selectStationOption = InputView.selectWantedFunction();
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

	public void playLineFunction() {
		OutputView.showLineFunctionList();
		String selectLineOption = InputView.selectWantedFunction();
		if (selectLineOption.equals("1")) {
			saveSubway();
			return;
		}
		if (selectLineOption.equals("2")) {
			deleteSubway();
			return;
		}
		if (selectLineOption.equals("3")) {
			showSubway();
			return;
		}
		if (selectLineOption.equals("B")) {
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
