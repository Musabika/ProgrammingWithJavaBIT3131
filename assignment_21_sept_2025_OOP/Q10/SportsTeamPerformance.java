package assignment_21_sept_2025_OOP.Q10;

public class SportsTeamPerformance {
    public static void main(String[] args)  {
        Team team = new Team("APR FC");
        Team team2 = new Team("Rayon Sport");
        team.addPlayer(new Player("Jack", 23));
        team.addPlayer(new Player("Claude", 19));
        team.addPlayer(new Player("Iranzi", 50));
        team2.addPlayer(new Player("Patrick", 40));
        team2.addPlayer(new Player("Teacher", 50));
        team2.addPlayer(new Player("Rukaku", 25));
        Team[] teams = {team, team2};
        Team teamWithHighestScore = teams[0];
        for (Team t : teams) {
            t.highestScoringPlayer();
            if (t.calculateTotalScores()> teamWithHighestScore.calculateTotalScores()) {
                teamWithHighestScore = t;
            }
        }
        System.out.println("The team "+  teamWithHighestScore.getTeamName() + "Has Highest Score: " + teamWithHighestScore.calculateTotalScores());
    }
}
