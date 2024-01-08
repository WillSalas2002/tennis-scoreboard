package tennis_scoreboard.controller;

import tennis_scoreboard.model.Match;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class MatchTemp {
    private static Map<UUID, Match> currentMatches = new HashMap<>();

    public static void storeMatch(Match match) {

        currentMatches.put(match.getUuid(), match);
    }

    public static Match retrieveMatch(UUID uuid) {

        return currentMatches.get(uuid);
    }

    public static void deleteMatch(UUID uuid) {
        currentMatches.remove(uuid);
    }
}