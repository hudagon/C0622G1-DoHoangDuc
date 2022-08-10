package ss8_clean_code_and_refactoring.exercise.refactoring.models;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        boolean isDraw = player1Score == player2Score;
        boolean isEnd = player1Score >= 4 || player2Score >= 4;
        if (isDraw) return getDrawGame(player1Score);
        if (isEnd) return getGameEndCalledScore(player1Score, player2Score);

        String calledScore = getPlayerCalledScore(player1Score) + "-" + getPlayerCalledScore(player2Score);
        return calledScore;
    }

    private static String getGameEndCalledScore(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;

        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";

        return "Win for player2";
    }

    private static String getPlayerCalledScore(int playerScore) {
        String score = "";
        switch (playerScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    private static String getDrawGame(int drawScore) {
        switch (drawScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
}