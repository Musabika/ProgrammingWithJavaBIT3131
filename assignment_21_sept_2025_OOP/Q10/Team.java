package assignment_21_sept_2025_OOP.Q10;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String teamName;
    private final List<Player> players = new ArrayList<>();;
    private int totalScores;
    public Team(String teamName) {
        this.teamName = teamName;
        this.totalScores = 0;
    }
    public String getTeamName() {
        return teamName;
    }
    public void addPlayer(Player player) {
        players.add(player);
        totalScores += player.getPlayerScores();
    }
    public int calculateTotalScores() {
        return totalScores;

    }
    public void highestScoringPlayer() {
        Player highestPlayer = players.getFirst();
        for (Player player : players) {
            if (player.getPlayerScores() > highestPlayer.getPlayerScores()) {
                highestPlayer = player;
            }
        }
        System.out.println("Player with Highest Scores in Team " + this.teamName);
        System.out.println("Player Name: " + highestPlayer.getPlayerName());
        System.out.println("Total Scores: " + totalScores);
    }
}
