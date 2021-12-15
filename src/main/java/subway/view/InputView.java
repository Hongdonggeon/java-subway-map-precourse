package subway.view;

import java.util.Scanner;

public class InputView {
	public static final String USER_CHOISE_FUNCTION_ALARM_MESSAGE = "## 원하는 기능을 선택하세요";
	public static final String STATION_SAVE_ALARM_MESSAGE = "## 등록할 역 이름을 입력하세요";

	private static Scanner scanner = new Scanner(System.in);

	public static String inputString() {
		return scanner.next();
	}
	public static String selectMainFunction() {
		System.out.println(USER_CHOISE_FUNCTION_ALARM_MESSAGE);
		return inputString();
	}

	public static String selectStationFunction() {
		System.out.println(USER_CHOISE_FUNCTION_ALARM_MESSAGE);
		return inputString();
	}

	public static String inputStationToSave() {
		System.out.println();
		System.out.println(STATION_SAVE_ALARM_MESSAGE);
		return inputString();
	}

}
