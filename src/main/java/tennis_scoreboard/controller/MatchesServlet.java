package tennis_scoreboard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tennis_scoreboard.dao.FinishedMatchesPersistenceService;
import tennis_scoreboard.dao.FinishedMatchesPersistenceServiceImpl;
import tennis_scoreboard.model.Match;

import java.io.IOException;
import java.util.List;

@WebServlet("/matches/*")
public class MatchesServlet extends HttpServlet {
    private final FinishedMatchesPersistenceService service = new FinishedMatchesPersistenceServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pageStr = req.getParameter("page");
        String nameToLookFor = req.getParameter("filter_by_player_name");

        int currentPage = 1;

        if (pageStr != null) {
            currentPage = Integer.parseInt(pageStr);
        }

        int totalMatchesCount;
        int matchesPerPage = 5;

        List<Match> matchList;

        if (nameToLookFor != null && !nameToLookFor.isBlank()) {
            req.setAttribute("nameToLookFor", nameToLookFor);
            matchList = service.getMatchesByPlayerName(nameToLookFor.trim(), (currentPage - 1) * matchesPerPage, matchesPerPage);
            totalMatchesCount = (int)service.getCountOfMatchTableWithName(nameToLookFor);
        } else {
            matchList = service.getTotalMatches((currentPage - 1) * matchesPerPage, matchesPerPage);
            totalMatchesCount = (int)service.getCountOfMatchTable();
        }

        int totalPages = (int) Math.ceil(((double) totalMatchesCount) / matchesPerPage);

        req.setAttribute("matchList", matchList);
        req.setAttribute("totalPages", totalPages);

        getServletContext().getRequestDispatcher("/view/matches-list.jsp").forward(req, resp);
    }
}
