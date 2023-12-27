<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Completed Matches</title>
</head>
<body>
    <h1>The List of Completed Matches</h1>
    <form action="/matches" method="get">
        <label for="name_seeker">Name:
            <input name="filter_by_player_name" type="text" id="name_seeker" autocomplete="on" value="${nameToLookFor}"/>
        </label>
        <input type="submit" value="Search" id="button"/>
    </form>


    <table>
        <tr>
            <th>ID</th>
            <th>Player 1</th>
            <th>Player 2</th>
            <th>WINNER</th>
        </tr>

        <c:forEach items="${matchList}" var="match">

            <tr>
                <td>
                    <c:out value="${match.getId()}"/>
                </td>
                <td>
                    <c:out value="${match.getPlayer1().getName()}"/>
                </td>
                <td>
                    <c:out value="${match.getPlayer2().getName()}"/>
                </td>
                <td>
                    <c:out value="${match.getWinner().getName()}"/>
                </td>
            </tr>

        </c:forEach>

        <tr>
            <table>
                <%for (int i = 0; i < (int) request.getAttribute("totalPages"); i++) {%>
                <c:choose>
                    <c:when test="${not empty fn:trim(nameToLookFor)}">
                        <th><a href="http://localhost:8080/matches?filter_by_player_name=${nameToLookFor}&page=<%= (i + 1) %>"><%= (i + 1) %></a></th>
                    </c:when>
                    <c:otherwise>
                        <th><a href="http://localhost:8080/matches?&page=<%= (i + 1) %>"><%= (i + 1) %></a></th>
                    </c:otherwise>
                </c:choose>
                <%}%>
            </table>
        </tr>
    </table>

    <a href="view/home.jsp">home</a>

</body>
</html>
