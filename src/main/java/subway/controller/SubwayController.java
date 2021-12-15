package subway.controller;

import subway.domain.EndTerminal;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
	public void play() {
		while (true) {
			OutputView.showMainFunctionList();
			String mainOption = InputView.selectWantedFunction();
			if (mainOption.equals("1")) {
				playStationFunction();
			}
			if (mainOption.equals("2")) {
				playLineFunction();
			}
			if (mainOption.equals("3")) {
				playSectionFunction();
			}
		}
	}

	public void playStationFunction() {
		OutputView.showStationFunctionList();
		String selectStationOption = InputView.selectWantedFunction();
		if (selectStationOption.equals("1")) {
			saveSubway();
		}
		else if (selectStationOption.equals("2")) {
			deleteSubway();
		}
		else if (selectStationOption.equals("3")) {
			showSubway();
		}
		else if (selectStationOption.equals("B")) {
		}
	}

	public void playLineFunction() {
		OutputView.showLineFunctionList();
		String selectLineOption = InputView.selectWantedFunction();
		if (selectLineOption.equals("1")) {
			saveLine();
		}
		else if (selectLineOption.equals("2")) {
			deleteLine();
		}
		else if (selectLineOption.equals("3")) {
			showLine();
		}
		else if (selectLineOption.equals("B")) {
			return;
		}
	}

	public void playSectionFunction() {
		OutputView.showSectionFunctionList();
		String selectSectionOption = InputView.selectWantedFunction();
		if (selectSectionOption.equals("1")) {
			registerSection();
		}
		else if (selectSectionOption.equals("2")) {
			deleteSection();
		}
		else if (selectSectionOption.equals("B")) {
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

	public void saveLine() {
		try {
			int beforeInputSize = LineRepository.getLineListSize();
			Line inputLine = new Line(InputView.inputLineToSave());
			inputLine.saveEndTerminal(
				new EndTerminal(InputView.inputLineUpTerminalToSave(), InputView.inputLineDownTerminalToSave()));
			LineRepository.addLine(inputLine);
			int afterInputSize = LineRepository.getLineListSize();
			if (beforeInputSize < afterInputSize) {
				OutputView.showLineSaveComplete();
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			saveLine();
		}
	}

	public void deleteLine() {
		boolean isDelete = LineRepository.deleteLineByName(InputView.inputLineToDelete());
		if (isDelete) {
			OutputView.showLineDeleteComplete();
		}
	}

	public void showLine() {
		OutputView.showStationList(LineRepository.castingLinesToString());
	}


	private void registerSection() {
		Line line = LineRepository.findLine(InputView.inputLineSavingSection());
		Station station = StationRepository.findStation(InputView.inputStationSavingSection());
		line.saveStationOrder(station, Integer.parseInt(InputView.inputStationOrderSavingSection()));
		OutputView.showSectionSaveComplete();
	}

	private void deleteSection() {
		Line line = LineRepository.findLine(InputView.inputLineOfSectionToDelete());
		Station station = line.findStation(InputView.inputStationOfSectionToDelete());
		line.deleteStationOrder(station);
		OutputView.showSectionDeleteComplete();
	}
}
