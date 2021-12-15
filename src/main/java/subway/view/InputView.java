package subway.view;

import java.util.Scanner;

public class InputView {
	private static final String STATION_NAME_TO_SAVE_ALARM_MESSAGE = "등록할 역 이름을 입력하세요.";
	public static final String USER_CHOISE_FUNCTION_ALARM_MESSAGE = "## 원하는 기능을 선택하세요";

	public static String selectMainFunction(Scanner scanner) {
		System.out.println(USER_CHOISE_FUNCTION_ALARM_MESSAGE);
		return scanner.next();
	}
	public static String selectStationFunction(Scanner scanner) {
		System.out.println(STATION_NAME_TO_SAVE_ALARM_MESSAGE);
		return scanner.next();
	}
}
