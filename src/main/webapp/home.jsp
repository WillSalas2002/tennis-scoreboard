<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style> <%@include file="css/styles.css"%> </style>
</head>

<body>
<header><jsp:include page="header.jsp"/></header>
<div class="home-container">
    <a href="new-game.jsp">
        <button class="submit">New Game</button>
    </a>
    <a href="http://localhost:8080/matches">
        <button class="submit">Matches</button>
    </a>
</div>
</body>
</html>
