package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.Hints;
import baseball.domain.Numbers;
import baseball.util.RandomGenerator;
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
        Numbers computerNumbers = new Numbers(randomGenerator.pickNumbers());

        BaseballGame baseballGame = new BaseballGame(computerNumbers);
        play(baseballGame);
        restart(baseballGame);
    }

    private void play(BaseballGame baseballGame) {
        Numbers myNumbers = new Numbers(input.inputBaseballNumber());
        Hints hints = baseballGame.result(myNumbers);
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
