<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Finished Match</title>
</head>

<body>
    <jsp:include page="header.jsp"/>
    <h1>Finished match</h1>
    <div class="finished-match-container">
        <table>
            <tr>
                <th>Players</th>
                <th>Sets</th>
            </tr>

            <tr>
                <td>${name1}</td>
                <td>${firstPlayerScore}</td>
            </tr>
            <tr>
                <td>${name2}</td>
                <td>${secondPlayerScore}</td>
            </tr>
        </table>
    </div>

</body>
</html>
