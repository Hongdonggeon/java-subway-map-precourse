package subway.menuOption;

import java.util.Arrays;

public enum MainMenuOption {
	STATION("1") ,LINE("2"), SECTION("3"), PRINT("4"), ESCAPE("Q");

	private static final String NOT_EXIST_IN_MAIN_MENU_OPTION = "[ERROR] 선택할 수 없는 기능입니다.";

	private String optionMenu;

	MainMenuOption(String optionMenu) {
		this.optionMenu = optionMenu;
	}

	public String getOptionMenu() {
		return optionMenu;
	}

	public static MainMenuOption getOption(String selectOption) {
		return Arrays.stream(MainMenuOption.values())
			.filter(option -> option.getOptionMenu().equals(selectOption))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_IN_MAIN_MENU_OPTION));
	}
}
