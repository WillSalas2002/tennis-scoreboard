<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Finished Match</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="css/styles.css"%></style>
</head>

<body>
<header><jsp:include page="header.jsp"/></header>

    <div class="finished-match-container">
        <div class="header"><h1>Finished match</h1></div>
        <div class="table">
            <div class="table-row">
                <div class="table-data">Players</div>
                <div class="table-data">Sets</div>
            </div>

            <div class="table-row">
                <div class="table-data">${name1}</div>
                <div class="table-data">${firstPlayerScore}</div>
            </div>

            <div class="table-row">
                <div class="table-data">${name2}</div>
                <div class="table-data">${secondPlayerScore}</div>
            </div>
        </div>
    </div>
</body>
</html>
