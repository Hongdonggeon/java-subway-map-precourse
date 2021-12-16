package subway.controller;

import java.util.HashMap;
import java.util.Map;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.menuOption.DetailedMenuOption;
import subway.menuOption.matchedFunction;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {
	private static Map<DetailedMenuOption, matchedFunction> lineFunction;

	static{
		lineFunction = new HashMap<>();
		lineFunction.put(DetailedMenuOption.CREATE, LineController::saveLine);
		lineFunction.put(DetailedMenuOption.DELETE, LineController::deleteLine);
		lineFunction.put(DetailedMenuOption.READ, LineController::showLine);
		lineFunction.put(DetailedMenuOption.ESCAPE, () -> {});
	}

	public static void run() {
		while (true) {
			try {
				OutputView.showLineFunctionList();
				DetailedMenuOption option = DetailedMenuOption.getOption(InputView.selectWantedFunction());
				lineFunction.get(option).run();
				if (option == DetailedMenuOption.ESCAPE) {
					break;
				}
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	public static void saveLine() {
		try {
			int beforeInputSize = LineRepository.getLineListSize();
			Line inputLine = new Line(InputView.inputLineToSave());
			inputLine.saveEndTerminal(StationRepository.findStation(InputView.inputLineUpTerminalToSave()), StationRepository.findStation(InputView.inputLineDownTerminalToSave()));
			LineRepository.addLine(inputLine);
			int afterInputSize = LineRepository.getLineListSize();
			if (beforeInputSize < afterInputSize) {
				OutputView.showLineSaveComplete();
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void deleteLine() {
		boolean isDelete = LineRepository.deleteLineByName(InputView.inputLineToDelete());
		if (isDelete) {
			OutputView.showLineDeleteComplete();
		}
	}

	public static void showLine() {
		OutputView.showStationList(LineRepository.castingLinesToString());
	}
}
