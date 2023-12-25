package tennis_scoreboard.model;

import jakarta.persistence.*;
import tennis_scoreboard.score_calculator.GameScore;
import tennis_scoreboard.score_calculator.MatchScore;
import tennis_scoreboard.score_calculator.SetScore;

@Entity
@Table(name = "players", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Transient
    private GameScore gameScore;
    @Transient
    private SetScore setScore;
    @Transient
    private MatchScore matchScore;

    public Player(String name) {
        this.name = name;
        gameScore = new GameScore();
        setScore = new SetScore();
        matchScore = new MatchScore();
    }

    public Player() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void addGameScore() {
        gameScore.addScore();
    }

    public void addSetScore() {
        setScore.addScore();
    }

    public void addMatchScore() {
        matchScore.addScore();
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public SetScore getSetScore() {
        return setScore;
    }

    public MatchScore getMatchScore() {
        return matchScore;
    }

    public void setGameScore(GameScore gameScore) {
        this.gameScore = gameScore;
    }

    public void setSetScore(SetScore setScore) {
        this.setScore = setScore;
    }

    public void setMatchScore(MatchScore matchScore) {
        this.matchScore = matchScore;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
