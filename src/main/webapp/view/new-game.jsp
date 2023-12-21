<!DOCTYPE html>
<html>

    <head>
        <title>Tennis Scoreboard</title>
        <link rel="stylesheet" href="view/new-game-style.css" />
    </head>

    <body>
        <div class="container">
            <form action = "new-match" method="POST">

                <div class="inputDiv">
                    First Player: <input type="text" name="player1Name"/>
                </div>

                <div class="inputDiv">
                    Second Player: <input type="text" name="player2Name"/>
                </div>

                <div class="button">
                    <a href="view/match-score.jsp">Here</a>
                    <input type="submit" value="Submit"/>
                </div>

            </form>
        </div>
    </body>

</html>
