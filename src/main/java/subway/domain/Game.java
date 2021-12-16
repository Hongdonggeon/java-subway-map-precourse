package subway.domain;

import java.util.HashMap;
import java.util.Map;

import subway.menuOption.MainMenuOption;
import subway.menuOption.matchedFunction;

public class Game {
	private Map<MainMenuOption, matchedFunction> mapToFunction;

	public void gameInit() {
		mapToFunction = new HashMap<>();

	}
}
