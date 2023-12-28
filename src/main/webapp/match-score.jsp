<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style> <%@include file="css/styles.css"%> </style>
</head>

<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<div class="matches-score-container">

    <div class="table">
        <div class="table-row">
            <div class="table-data">Players</div>
            <div class="table-data">Sets</div>
            <div class="table-data">Games</div>
            <div class="table-data">Points</div>
        </div>

        <div class="table-row">
            <div class="table-data">${match.getPlayer1().getName()}</div>
            <div class="table-data">${match.getPlayer1().getMatchScore().getScore()}</div>
            <div class="table-data">${match.getPlayer1().getSetScore().getScore()}</div>
            <div class="table-data">${match.getPlayer1().getGameScore().getScore()}</div>
        </div>

        <div class="table-row">
            <div class="table-data">${match.getPlayer2().getName()}</div>
            <div class="table-data">${match.getPlayer2().getMatchScore().getScore()}</div>
            <div class="table-data">${match.getPlayer2().getSetScore().getScore()}</div>
            <div class="table-data">${match.getPlayer2().getGameScore().getScore()}</div>
        </div>
    </div>


    <form action="/match-score?uuid=${match.getUuid()}" method="post">
        <div class="increase-buttons">
            <div class="input-container">
                <input type="submit" class="submit" name="winner" value="Player 1"/>
            </div>

            <div class="input-container">
                <input type="submit" class="submit" name="winner" value="Player 2"/>
            </div>
        </div>

    </form>

</div>
</body>
</html>
