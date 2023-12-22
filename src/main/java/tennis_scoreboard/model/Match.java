package tennis_scoreboard.model;

import jakarta.persistence.*;
import tennis_scoreboard.score_calculator.OverallGameScore;

import java.util.UUID;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @Column(name = "id")
    private UUID uuid;
    @OneToOne
    @JoinColumn(name = "player1_id")
    private Player player1;
    @OneToOne
    @JoinColumn(name = "player2_id")
    private Player player2;
    @OneToOne
    @JoinColumn(name = "winner_id")
    private Player winner;

    @Transient
    private OverallGameScore gameScore;

    public Match(Player player1, Player player2) {
        this(player1, player2, null);
        uuid = UUID.randomUUID();
        this.gameScore = new OverallGameScore(player1, player2);
    }

    public Match(Player player1, Player player2, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }

    public Match() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public OverallGameScore getGameScore() {
        return gameScore;
    }

    public void setGameScore(OverallGameScore gameScore) {
        this.gameScore = gameScore;
    }

    @Override
    public String toString() {
        return "Match{" +
                "uuid=" + uuid +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", winner=" + winner +
                '}';
    }
}
