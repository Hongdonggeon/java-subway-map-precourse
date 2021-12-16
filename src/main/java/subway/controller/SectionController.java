package subway.controller;

import java.util.HashMap;
import java.util.Map;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menuOption.DetailedMenuOption;
import subway.menuOption.matchedFunction;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {
	private static Map<DetailedMenuOption, matchedFunction> sectionFunction;

	static{
		sectionFunction = new HashMap<>();
		sectionFunction.put(DetailedMenuOption.CREATE, SectionController::registerSection);
		sectionFunction.put(DetailedMenuOption.DELETE, SectionController::deleteSection);
		sectionFunction.put(DetailedMenuOption.ESCAPE, () -> {});
	}

	public static void run() {
		while (true) {
			try {
				OutputView.showSectionFunctionList();
				DetailedMenuOption option = DetailedMenuOption.getOption(InputView.selectWantedFunction());
				if (option.getMenuOption().equals("3")) {
					throw new IllegalArgumentException("[ERROR] 사용할 수 있는 기능이 아니다.");
				}
				sectionFunction.get(option).run();
				if (option == DetailedMenuOption.ESCAPE) {
					break;
				}
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	private static void registerSection() {
		try {
			Line line = LineRepository.findLine(InputView.inputLineSavingSection());
			Station station = StationRepository.findStation(InputView.inputStationSavingSection());
			line.saveStationOrder(station, Integer.parseInt(InputView.inputStationOrderSavingSection()));
			OutputView.showSectionSaveComplete();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private static void deleteSection() {
		try {
			Line line = LineRepository.findLine(InputView.inputLineOfSectionToDelete());
			Station station = line.findStationInLine(InputView.inputStationOfSectionToDelete());
			line.deleteStationOrder(station);
			OutputView.showSectionDeleteComplete();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
