package subway.controller;

import java.util.HashMap;
import java.util.Map;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menuOption.DetailedMenuOption;
import subway.menuOption.matchedFunction;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
	private static Map<DetailedMenuOption, matchedFunction> stationFunction;

	static {
		stationFunction = new HashMap<>();
		stationFunction.put(DetailedMenuOption.CREATE, StationController::saveStation);
		stationFunction.put(DetailedMenuOption.DELETE, StationController::deleteStation);
		stationFunction.put(DetailedMenuOption.READ, StationController::showStation);
		stationFunction.put(DetailedMenuOption.ESCAPE, () -> {
		});
	}

	public static void run() {
		try {
			OutputView.showStationFunctionList();
			DetailedMenuOption option = DetailedMenuOption.getOption(InputView.selectWantedFunction());
			stationFunction.get(option).run();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			run();
		}

	}

	public static void saveStation() {
		try {
			StationRepository.addStation(new Station(InputView.inputStationToSave()));
			OutputView.showStationSaveComplete();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void deleteStation() {
		boolean isDelete = StationRepository.deleteStation(InputView.inputStationToDelete());
		if (isDelete) {
			OutputView.showStationDeleteComplete();
		}
	}

	public static void showStation() {
		OutputView.showStationList(StationRepository.castingStationsToString());
	}
}
