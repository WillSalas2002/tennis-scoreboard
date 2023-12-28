<%@ page import="tennis_scoreboard.model.Match" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="match-score-style.css"/>
</head>

<body>
<jsp:include page="header.jsp"/>
<table>
    <tr>
        <th>Players</th>
        <th>Sets</th>
        <th>Games</th>
        <th>Points</th>
    </tr>
    <tr>
        <td>${match.getPlayer1().getName()}</td>
        <td>${match.getPlayer1().getMatchScore().getScore()}</td>
        <td>${match.getPlayer1().getSetScore().getScore()}</td>
        <td>${match.getPlayer1().getGameScore().getScore()}</td>
    </tr>
    <tr>
        <td>${match.getPlayer2().getName()}</td>
        <td>${match.getPlayer2().getMatchScore().getScore()}</td>
        <td>${match.getPlayer2().getSetScore().getScore()}</td>
        <td>${match.getPlayer2().getGameScore().getScore()}</td>
    </tr>
</table>
<form action="/match-score?uuid=${match.getUuid()}" method="post">
    <input type="submit" name="winner" value="Player 1"/>
    <input type="submit" name="winner" value="Player 2"/>
</form>
</body>
</html>
