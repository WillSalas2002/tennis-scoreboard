package tennis_scoreboard.score_calculator;

import tennis_scoreboard.model.Player;

public class OverallGameScore {

    private Player player1;
    private Player player2;

    public OverallGameScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void addScoreToFirstPlayer() {

        player1.addGameScore();

        if (increaseSetScore()) {
            setRoundScoresToZero();
        }

        if (increaseMatchScore()) {
            setSetScoresToZero();
        }
    }

    public void addScoreToSecondPlayer() {

        player2.addGameScore();

        if (increaseSetScore()) {
            setRoundScoresToZero();
        }

        if (increaseMatchScore()) {
            setSetScoresToZero();
        }
    }

    public void setRoundScoresToZero() {

        player1.getGameScore().setScore(0);
        player2.getGameScore().setScore(0);
    }

    private boolean increaseSetScore() {

        int firstPlayerScore = player1.getGameScore().getScore();
        int secondPlayerScore = player2.getGameScore().getScore();

        if (firstPlayerScore > 40 || secondPlayerScore > 40) {

            int difference = firstPlayerScore - secondPlayerScore;

            if (difference >= 25) {
                player1.addSetScore();
                return true;
            } else if (difference <= -25) {
                player2.addSetScore();
                return true;
            }
        }
        return false;
    }

    private void setSetScoresToZero() {

        player1.getSetScore().setScore(0);
        player2.getSetScore().setScore(0);
    }

    private boolean increaseMatchScore() {

        int firstPlayerScore = player1.getSetScore().getScore();
        int secondPlayerScore = player2.getSetScore().getScore();

        if (firstPlayerScore >= 6 || secondPlayerScore >= 6) {
            int difference = firstPlayerScore - secondPlayerScore;

            if (difference >= 2) {
                player1.addMatchScore();
                return true;
            } else if (difference <= -2) {
                player2.addMatchScore();
                return true;
            }
        }

        return false;
    }

    public Player winner() {

        int firstPlayerScore = player1.getMatchScore().getScore();
        int secondPlayerScore = player2.getMatchScore().getScore();

        return firstPlayerScore == 2 ? player1 : (secondPlayerScore == 2 ? player2 : null);
    }

    @Override
    public String toString() {
        return String.format(
                "Round Score: (%s - %s) / (%d - %d)\n" +
                        "Set Score: (%d - %d) \n" +
                        "Match Score: (%d - %d)",
                player1.getName(), player2.getName(),
                player1.getGameScore().getScore(), player2.getGameScore().getScore(),
                player1.getSetScore().getScore(), player2.getSetScore().getScore(),
                player1.getMatchScore().getScore(), player2.getMatchScore().getScore());
    }
}
