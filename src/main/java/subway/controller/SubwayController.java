package subway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import subway.InitService;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.menuOption.MainMenuOption;
import subway.menuOption.matchedFunction;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
	private static Map<MainMenuOption, matchedFunction> mainFunction;

	static {
		mainFunction = new HashMap<>();
		mainFunction.put(MainMenuOption.STATION, StationController::run);
		mainFunction.put(MainMenuOption.LINE, LineController::run);
		mainFunction.put(MainMenuOption.SECTION, SectionController::run);
		mainFunction.put(MainMenuOption.PRINT, SubwayController::showSubwayLines);
		mainFunction.put(MainMenuOption.ESCAPE, () -> {});
		InitService.initStation();
		InitService.initLine();
	}

	public void play() {
		while (true) {
			OutputView.showMainFunctionList();
			try {
				MainMenuOption option = MainMenuOption.getOption(InputView.selectWantedFunction());
				mainFunction.get(option).run();
				if (option == MainMenuOption.ESCAPE) {
					break;
				}
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	public static void showSubwayLines() {
		List<Line> lines = LineRepository.lines();
		for (Line line : lines) {
			String lineName = line.getName();
			OutputView.showSubwayLine(line.getName(), line.getStationNames());
		}
	}

}
