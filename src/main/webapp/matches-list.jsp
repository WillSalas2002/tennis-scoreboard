<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Completed Matches</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style> <%@include file="css/styles.css"%> </style>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<div class="matches-list-container">
    <div><h1>The List of Completed Matches</h1></div>

    <form action="/matches" method="get">
        <div class="input-field">
            <div class="input-container">
                <input name="filter_by_player_name" class="input" type="text" placeholder="Player Name" id="name_seeker"
                       value="${nameToLookFor}" required/>
            </div>

            <div class="input-container">
                <input type="submit" class="submit" value="Search"/>
            </div>

            <div class="input-container">
                <input type="submit" class="submit" value="Clear"/>
            </div>
        </div>

    </form>

    <div class="table">
        <div class="table-row">
            <div class="table-data table-header">ID</div>
            <div class="table-data table-header">Player 1</div>
            <div class="table-data table-header">Player 2</div>
            <div class="table-data table-header">WINNER</div>
        </div>
        <c:forEach items="${matchList}" var="match">
            <div class="table-row">
                <div class="table-data"><c:out value="${match.getId()}"/></div>
                <div class="table-data"><c:out value="${match.getPlayer1().getName()}"/></div>
                <div class="table-data"><c:out value="${match.getPlayer2().getName()}"/></div>
                <div class="table-data"><c:out value="${match.getWinner().getName()}"/></div>
            </div>
        </c:forEach>
    </div>

    <div class="page-numbers">
        <%for (int i = 0; i < (int) request.getAttribute("totalPages"); i++) {%>
        <c:choose>
            <c:when test="${empty nameToLookFor || nameToLookFor.length() == 0}">
                <button class="page-buttons">
                    <a href="http://localhost:8080/matches?page=<%= (i + 1) %>"><%= (i + 1) %>
                    </a>
                </button>
            </c:when>
            <c:otherwise>
                <button class="page-buttons">
                    <a href="http://localhost:8080/matches?filter_by_player_name=${nameToLookFor}&page=<%= (i + 1) %>"><%= (i + 1) %>
                    </a>
                </button>
            </c:otherwise>
        </c:choose>
        <%}%>
    </div>
</div>
</body>
</html>
