package tennis_scoreboard.dao;

import tennis_scoreboard.model.Match;
import tennis_scoreboard.model.Player;

import java.util.List;

public interface FinishedMatchesPersistenceService {
    void saveMatch(Match match);

    void savePlayers(Player player);

    Player getPlayerByName(String name);

    long getCountOfMatchTable();

    List<Match> getTotalMatches(int offset, int limit);

    List<Match> getMatchesByPlayerName(String nameToLookFor, int offset, int limit);

    long getCountOfMatchTableWithName(String name);
}
