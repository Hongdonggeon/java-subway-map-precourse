package subway.view;

import java.util.Scanner;

public class InputView {
	public static final String USER_CHOISE_FUNCTION_ALARM_MESSAGE = "## 원하는 기능을 선택하세요";
	public static final String STATION_SAVE_ALARM_MESSAGE = "## 등록할 역 이름을 입력하세요";
	public static final String STATION_DELETE_ALARM_MESSAGE = "## 삭제할 역 이름을 입력하세요";
	public static final String LINE_SAVE_ALARM_MESSAGE = "## 등록할 노선 이름을 입력하세요";
	public static final String LINE_UP_TERMINAL_ALARM_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요";
	public static final String LINE_DOWN_TERMINAL_ALARM_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요";
	public static final String LINE_DELETE_ALARM_MESSAGE = "## 삭제할 노선 이름을 입력하세요";

	private static Scanner scanner = new Scanner(System.in);

	public static String inputString() {
		return scanner.next();
	}
	public static String selectWantedFunction() {
		System.out.println(USER_CHOISE_FUNCTION_ALARM_MESSAGE);
		return inputString();
	}

	public static String inputStationToSave() {
		System.out.println();
		System.out.println(STATION_SAVE_ALARM_MESSAGE);
		return inputString();
	}

	public static String inputStationToDelete() {
		System.out.println();
		System.out.println(STATION_DELETE_ALARM_MESSAGE);
		return inputString();
	}

	public static String inputLineToSave() {
		System.out.println();
		System.out.println(LINE_SAVE_ALARM_MESSAGE);
		return inputString();
	}

	public static String inputLineUpTerminalToSave() {
		System.out.println();
		System.out.println(LINE_UP_TERMINAL_ALARM_MESSAGE);
		return inputString();
	}

	public static String inputLineDownTerminalToSave() {
		System.out.println();
		System.out.println(LINE_DOWN_TERMINAL_ALARM_MESSAGE);
		return inputString();
	}

	public static String inputLineToDelete() {
		System.out.println();
		System.out.println(LINE_DELETE_ALARM_MESSAGE);
		return inputString();
	}

}
