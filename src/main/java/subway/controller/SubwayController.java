package subway.controller;

import java.util.Scanner;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
	public SubwayController(Scanner scanner) {
		this.scanner = scanner;
	}

	private Scanner scanner;

	public void play() {
		OutputView.showMainFunctionList();
		if (InputView.selectMainFunction().equals("1")) {
			OutputView.showStationFunctionList();
			String selectStationOption = InputView.selectStationFunction();
			if (selectStationOption.equals("1")) {
				saveSubway();
			}
		}
	}


	public void saveSubway(){
		try {
			StationRepository.addStation(new Station(InputView.inputStationToSave()));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			saveSubway();
		}
	}

}
