package tennis_scoreboard.dao;

import tennis_scoreboard.model.Match;
import tennis_scoreboard.model.Player;

public interface FinishedMatchesPersistenceService {
    void saveMatch(Match match);

    void savePlayers(Player player);

    Player getPlayerByName(String name);
}
