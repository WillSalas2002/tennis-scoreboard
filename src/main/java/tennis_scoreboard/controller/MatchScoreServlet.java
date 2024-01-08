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

        Match match = TempMatchesStorage.retrieveMatch(uuid);

        Player player1 = match.getPlayer1();
        Player player2 = match.getPlayer2();

        req.setAttribute("uuid", uuid);
        req.setAttribute("player1", player1);
        req.setAttribute("player2", player2);

        req.getRequestDispatcher("/match-score.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pointWinnerStr = req.getParameter("pointWinnerId");
        String matchUuid = req.getParameter("uuid");

        UUID uuid = UUID.fromString(matchUuid);
        Match match = TempMatchesStorage.retrieveMatch(uuid);

        int pointWinner = Integer.parseInt(pointWinnerStr);

        if (match.getPlayer1().getId() == pointWinner) {
            match.getGameScore().addScoreToFirstPlayer();
        } else {
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

            TempMatchesStorage.deleteMatch(uuid);

            getServletContext().getRequestDispatcher("/finished-match.jsp").forward(req, resp);

        } else {
            doGet(req, resp);
        }
    }
}

