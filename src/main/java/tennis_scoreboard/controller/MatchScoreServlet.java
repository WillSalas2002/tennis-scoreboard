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

import java.io.IOException;
import java.util.UUID;

@WebServlet("/match-score/*")
public class MatchScoreServlet extends HttpServlet {

    private final FinishedMatchesPersistenceService service = new FinishedMatchesPersistenceServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uuidStr = req.getParameter("uuid");

        UUID uuid = UUID.fromString(uuidStr);

        Match match = MatchTemp.retrieveMatch(uuid);

        String name1 = match.getPlayer1().getName();
        String name2 = match.getPlayer2().getName();

        req.setAttribute("match", match);
        req.setAttribute("name1", name1);
        req.setAttribute("name2", name2);

        req.getRequestDispatcher("view/match-score.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String p1Name = req.getParameter("winner");
        String matchUuid = req.getParameter("uuid");

        UUID uuid = UUID.fromString(matchUuid);
        Match match = MatchTemp.retrieveMatch(uuid);

        if ("Player 1".equals(p1Name)) {
            match.getGameScore().addScoreToFirstPlayer();
        } else if ("Player 2".equals(p1Name)) {
            match.getGameScore().addScoreToSecondPlayer();
        }

        Player winner = match.getGameScore().winner();

        if (winner != null) {

            match.setWinner(winner);
            service.saveMatch(match);

            req.setAttribute("firstPlayerScore", match.getPlayer1().getMatchScore().getScore());
            req.setAttribute("secondPlayerScore", match.getPlayer2().getMatchScore().getScore());

            req.setAttribute("name1", match.getPlayer1().getName());
            req.setAttribute("name2", match.getPlayer2().getName());

            req.getRequestDispatcher("view/finished-match.jsp").forward(req, resp);

        } else {
            doGet(req, resp);
        }
    }
}

