package subway;

import java.util.Scanner;

import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        OutputView.showMainFunctionList();
        String selectOption = InputView.selectMainFunction(scanner);
        if (selectOption.equals("1")) {
            OutputView.showStationFunctionList();
            String selectStationOption = InputView.selectStationFunction(scanner);
        }
    }
}
