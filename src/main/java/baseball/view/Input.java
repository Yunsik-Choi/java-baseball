package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public List<Integer> inputNumber() {
        String text = Console.readLine();
        validateInput(text);
        return textToIntList(text);
    }

    private List<Integer> textToIntList(String text) {
        return text.chars().boxed()
                .collect(Collectors.toList());
    }

    public static void validateInput(String text) {
        validateNumber(text);
        validateLength(text);
        validateOverlap(text);
    }

    private static void validateNumber(String text) {
        if (!text.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닌 값이 있습니다.");
        }
    }

    private static void validateLength(String text) {
        if (text.length() != 3) {
            throw new IllegalArgumentException("3자리가 아닙니다.");
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
}
