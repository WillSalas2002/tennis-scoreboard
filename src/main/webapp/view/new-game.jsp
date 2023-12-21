<!DOCTYPE html>
<html>

    <head>
        <title>Tennis Scoreboard</title>
        <link rel="stylesheet" href="./new-game-style.css" />
    </head>

    <body>
        <div class="container">
            <form action = "new-match" method="POST">

                <div class="inputDiv">
                    <label for="player1Name">First Player Name:</label>
                    <input type="text" name="player1Name"/>
                </div>

                <div class="inputDiv">
                    <label for="player2Name">Second Player Name:</label>
                    <input type="text" name="player2Name"/>
                </div>

                <div class="button">
                    <input type="submit" value="Submit"/>
                </div>

            </form>
        </div>
    </body>

</html>
