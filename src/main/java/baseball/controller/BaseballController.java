package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.Hints;
import baseball.domain.Numbers;
import baseball.domain.RandomGenerator;
import baseball.view.Input;
import baseball.view.Output;

public class BaseballController {

    private final Input input;

    public BaseballController() {
        Output.start();
        this.input = new Input();
    }

    public void game() {
        RandomGenerator randomGenerator = new RandomGenerator();
        Numbers numbers = new Numbers(randomGenerator.pickNumbers());
        BaseballGame baseballGame = new BaseballGame(numbers);
        play(baseballGame);
        restart(baseballGame);
    }

    private void play(BaseballGame baseballGame) {
        Hints hints = baseballGame.result(new Numbers(input.inputBaseballNumber()));
        Output.result(hints);
        endGame(baseballGame, hints);
    }

    private void endGame(BaseballGame baseballGame, Hints hints) {
        if (baseballGame.isNotEnd(hints)) {
            play(baseballGame);
        }
    }

    private void restart(BaseballGame baseballGame) {
        if (baseballGame.isRestart(input.inputRestart())) {
            game();
        }
    }
}
