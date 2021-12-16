package subway.menuOption;

import java.util.Arrays;

public enum DetailedMenuOption {
	CREATE("1"), DELETE("2"), READ("3"), ESCAPE("B");

	private static final String NOT_EXIST_IN_DETAILED_MENU_OPTION = "[ERROR] 선택할 수 없는 기능입니다.";

	private String menuOption;

	DetailedMenuOption(String menuOption) {
		this.menuOption = menuOption;
	}

	public String getMenuOption() {
		return menuOption;
	}

	public static DetailedMenuOption getOption(String menuOption) {
		return Arrays.stream(DetailedMenuOption.values())
			.filter(option -> option.getMenuOption().equals(menuOption))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_IN_DETAILED_MENU_OPTION));
	}
}
