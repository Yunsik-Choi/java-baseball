package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final String RESTART = "1";
    private static final String END = "2";

    private Input() throws InstantiationException {
        throw new InstantiationException("Input 클래스는 생성할 수 없습니다.");
    }

    public static List<Integer> inputBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String text = Console.readLine().trim();
        validateInputBaseballNumber(text);
        return textToIntList(text);
    }

    public static void validateInputBaseballNumber(String text) {
        validateAllMatchNumber(text);
        validateBaseballNumberLength(text);
        validateOverlap(text);
    }

    private static void validateAllMatchNumber(String text) {
        if (!text.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닌 값이 있습니다.");
        }
    }

    private static void validateBaseballNumberLength(String text) {
        if (text.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(BASEBALL_NUMBER_LENGTH + "자리가 아닙니다.");
        }
    }

    private static void validateOverlap(String text) {
        long count = text.chars()
                .distinct()
                .boxed()
                .count();

        if (count != text.length()) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
    }

    private static List<Integer> textToIntList(String text) {
        return text.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int inputRestart() {
        System.out.println("게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + END + "를 입력하세요.");
        String text = Console.readLine().trim();
        validateInputRestart(text);
        return Integer.parseInt(text);
    }

    public static void validateInputRestart(String text) {
        if (!text.equals(RESTART) && !text.equals(END)) {
            throw new IllegalArgumentException("재시작/종료를 구분하는 " + RESTART + "과 " + END + "중 하나의 수를 입력해야 합니다.");
        }
    }
}
