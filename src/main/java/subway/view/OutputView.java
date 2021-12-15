package subway.view;

public class OutputView {
	private static final String MAIN_SCREEN_FUNCTION_LIST = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
	private static final String STATION_FUNCTION_LIST = "## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";

	public static void showMainFunctionList() {
		System.out.println(MAIN_SCREEN_FUNCTION_LIST);
	}

	public static void showStationFunctionList() {
		System.out.println(STATION_FUNCTION_LIST);
	}
}
