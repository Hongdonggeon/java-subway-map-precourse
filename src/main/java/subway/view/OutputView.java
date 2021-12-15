package subway.view;

public class OutputView {
	private static final String MAIN_SCREEN_FUNCTION_LIST = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";

	public static void showMainFunctionList() {
		System.out.println(MAIN_SCREEN_FUNCTION_LIST);
	}
}
