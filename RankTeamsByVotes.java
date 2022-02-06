import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankTeamsByVotes {
    class Team implements Comparable<Team> {
        public String name;
        public int scores[];
        
        public Team(String name, int n) {
            this.scores = new int[n];
            for(int i = 0; i < n; i++) {
                this.scores[i] = 0;
            }
            this.name = name;
        }
        
        public int compareTo(Team b){
            for(int i = 0; i < scores.length; i++) {
                if(this.scores[i] > b.scores[i]){
                    return -1;
                } else if(this.scores[i] < b.scores[i]) {
                    return 1;
                }
            }
            return 0;
        }
    }
    public String rankTeams(String[] votes) {
        Map<String, Team> teamByNameMap = new HashMap<>();
        for(String vote: votes){
            for(int c = 0; c < vote.length(); c++) {
                String name = vote.substring(c, c+1);
                Team team;
                if(teamByNameMap.containsKey(name)){
                    team = teamByNameMap.get(name);
                } else {
                    team = new Team(name, vote.length());
                    teamByNameMap.put(name, team);
                }
                team.scores[c] += 1;
            }
        }
        List<Team> teamSet = new ArrayList<>(teamByNameMap.values());
        Collections.sort(teamSet);
        return teamSet.stream().map(v->v.name).reduce((acc, v)->acc+v).orElse("");
    }
}
