<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Completed Matches</title>
</head>
<body>
    <h1>The List of Completed Matches</h1>
    <form action="/matches" method="get">
        <label for="name_seeker">Name:
            <input type="search" name="filter_by_player_name" id="name_seeker"/>
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
    </table>

</body>
</html>
