package subway.view;

public class InputView {
	public static final String USER_CHOISE_FUNCTION_ALARM_MESSAGE = "## 원하는 기능을 선택하세요";

	public static String selectMainFunction(String input) {
		System.out.println(USER_CHOISE_FUNCTION_ALARM_MESSAGE);
		return input;
	}
}
