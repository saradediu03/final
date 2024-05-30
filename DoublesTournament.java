import java.time.LocalDate;
import java.util.ArrayList;

public class DoublesTournament extends Tournament{
    ArrayList<Integer> players1;
    ArrayList<Integer> players2;
    public DoublesTournament(String name, String location, LocalDate startDate, LocalDate endDate, String gender, int ageGroup, String selectionCriteria, int drawSize, TournamentDirector director) {
        super(name, location, startDate, endDate, gender, ageGroup, selectionCriteria, drawSize, director);
        players1 = new ArrayList<Integer>();
        players2 = new ArrayList<Integer>();

    }
        public void pair(Player p1, Player p2){
            players1.add(p1.getID());
            players2.add(p2.getID());
    }

    public String toString(){
        String s = "Name: " + getName() + "\n" + "Location: " + getLocation() + "\n" + "Start Date: " + getStartDate() + "\n" +
                "End Date: " + getEndDate() + "\n" + "Gender: " + getGender() + "\n" + "Age Group: " + getAgeGroup() + "\n" +
                "Draw Size: " + getDrawSize() + "\n" + "Director:\n" + getDirector().toStringIndented();
        s += "Players:\n";
        s += "\tFull name            | DOB        | Gender | Rank  | UTR   | ID    | Sel | Wdr\n";
        s += "\t---------------------|------------|--------|-------|-------|-------|-----|----\n";
//        for(int i=0;i<registeredPlayers.size();i++){
//            s = s + "\t" + registeredPlayers.get(i).toStringOneLine() + "\n";
//
//        }
        for(int i=0;i<players1.size();i++) {
            s = s + "\tTEAM " + (i+1) + "\n";
            s = s + "\t" + registeredPlayers.get(getIndexOfRegisteredPlayer(players1.get(i))).toStringOneLine() + "\n";
            s = s + "\t" + registeredPlayers.get(getIndexOfRegisteredPlayer(players2.get(i))).toStringOneLine() + "\n";
        }
        return s;
    }

    private int getIndexOfRegisteredPlayer(int id)
    {
        for(int i=0;i<registeredPlayers.size();i++) {
            if(id == registeredPlayers.get(i).getID()){
                return i;
            }
        }
        return -1;
    }
}
