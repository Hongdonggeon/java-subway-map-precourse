package subway.domain;

public class EndTerminal {
	Station topEndStation;
	Station underEndStation;

	public EndTerminal(String topEndStation, String underEndStation) {
		this.topEndStation = new Station(topEndStation);
		this.underEndStation = new Station(underEndStation);
	}
}
