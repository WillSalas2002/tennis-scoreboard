package tennis_scoreboard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tennis_scoreboard.dao.FinishedMatchesPersistenceService;
import tennis_scoreboard.dao.FinishedMatchesPersistenceServiceImpl;
import tennis_scoreboard.model.Match;
import tennis_scoreboard.model.Player;
import tennis_scoreboard.score_calculator.GameScore;
import tennis_scoreboard.score_calculator.MatchScore;
import tennis_scoreboard.score_calculator.SetScore;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {
    private final FinishedMatchesPersistenceService service = new FinishedMatchesPersistenceServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name1 = req.getParameter("player1Name");
        String name2 = req.getParameter("player2Name");

        Player player1 = service.getPlayerByName(name1);
        Player player2 = service.getPlayerByName(name2);

        if (player1 == null) {
            player1 = new Player(name1);
            service.savePlayers(player1);
        } else {
            player1.setMatchScore(new MatchScore());
            player1.setGameScore(new GameScore());
            player1.setSetScore(new SetScore());
        }

        if (player2 == null) {
            player2 = new Player(name2);
            service.savePlayers(player2);
        } else {
            player2.setMatchScore(new MatchScore());
            player2.setGameScore(new GameScore());
            player2.setSetScore(new SetScore());
        }

        Match match = new Match(player1, player2);

        MatchTemp.storeMatch(match);

        UUID matchUuid = match.getUuid();

        resp.sendRedirect("http://localhost:8080/match-score?uuid=" + matchUuid);
    }
}
