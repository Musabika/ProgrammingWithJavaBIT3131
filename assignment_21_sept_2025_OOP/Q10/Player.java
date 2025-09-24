package assignment_21_sept_2025_OOP.Q10;

public class Player {
    private final String playerName;
    private final int scores;
    public Player(String playerName, int scores) {
        this.playerName = playerName;
        this.scores = scores;
    }

    public int getPlayerScores() {
        return scores;
    }

    public String getPlayerName() {
        return playerName;
    }
}
