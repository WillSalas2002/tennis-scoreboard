<!DOCTYPE html>
<html>

<head>
    <title>Tennis Scoreboard</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style> <%@include file="css/styles.css"%> </style>
</head>

<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<div class="new-game-container">
    <form action="http://localhost:8080/new-match" method="POST">

        <div class="input-container ic1">
            <label>First Player:
                <input type="text" class="input" name="player1Name" required/>
            </label>
        </div>

        <div class="input-container ic2">
            <label>Second Player:
                <input type="text" class="input" name="player2Name" required/>
            </label>
        </div>

        <div class="input-container">
            <input type="submit" class="submit" value="Submit"/>
        </div>

    </form>
</div>

</body>
</html>
