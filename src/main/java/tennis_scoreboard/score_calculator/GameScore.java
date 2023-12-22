package tennis_scoreboard.score_calculator;

public class GameScore extends Score {
    @Override
    public void addScore() {
        if (score == 30) {
            score += 10;
        } else {
            score += 15;
        }
    }
}
