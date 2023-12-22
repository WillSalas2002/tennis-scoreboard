package tennis_scoreboard.score_calculator;


public abstract class Score {
    protected int score;

    public abstract void addScore();

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
