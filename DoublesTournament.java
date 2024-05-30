import java.time.LocalDate;
import java.util.ArrayList;
/** Represents a doubles tournament.
 * Extends Tournament class.
 */
public class DoublesTournament extends Tournament{
    /** Represents the list of player IDs of first partners in doubles pairs.
     */
    ArrayList<Integer> players1;
    /** Represents the list of player IDs of second partners in doubles pairs.
     */
    ArrayList<Integer> players2;
    /** Creates a tournament with the specified parameters.
     * @param name The tournament’s name.
     * @param location The tournament's location.
     * @param startDate The tournament's starting date.
     * @param endDate The tournament's ending date.
     * @param gender The gender category of the tournament.
     * @param ageGroup The age group category of the tournament.
     * @param selectionCriteria The selection criteria for the tournament.
     * @param drawSize The draw size of the tournament.
     * @param director The director of the tournament.
     */
    public DoublesTournament(String name, String location, LocalDate startDate, LocalDate endDate, String gender, int ageGroup, String selectionCriteria, int drawSize, TournamentDirector director) {
        super(name, location, startDate, endDate, gender, ageGroup, selectionCriteria, drawSize, director);
        players1 = new ArrayList<Integer>();
        players2 = new ArrayList<Integer>();

    }
    /** Pairs two players by adding first player partner ID in players1 ArrayList and second player partner ID in
     * players2 ArrayList.
     * @param p1 Player containing the first player to be added to the doubles pair.
     * @param p2 Player containing the second player to be added to the doubles pair.
     */
    public void pair(Player p1, Player p2){
            players1.add(p1.getID());
            players2.add(p2.getID());
    }
    /** Formats output of table of players in tournament for doubles tournament.
     * @return String containing the tournament's players in respective pairs and their attributes in a table.
     */
    public String toString(){
        String s = "Name: " + getName() + "\n" + "Location: " + getLocation() + "\n" + "Start Date: " + getStartDate() + "\n" +
                "End Date: " + getEndDate() + "\n" + "Gender: " + getGender() + "\n" + "Age Group: " + getAgeGroup() + "\n" +
                "Draw Size: " + getDrawSize() + "\n" + "Director:\n" + getDirector().toStringIndented();
        s += "Players:\n";
        s += "\tFull name            | DOB        | Gender | Rank  | UTR   | ID    | Sel | Wdr\n";
        s += "\t---------------------|------------|--------|-------|-------|-------|-----|----\n";
        for(int i=0;i<players1.size();i++) {
            s = s + "\tTEAM " + (i+1) + "\n";
            s = s + "\t" + registeredPlayers.get(getIndexOfRegisteredPlayer(players1.get(i))).toStringOneLine() + "\n";
            s = s + "\t" + registeredPlayers.get(getIndexOfRegisteredPlayer(players2.get(i))).toStringOneLine() + "\n";
        }
        return s;
    }
    /** Searches for and returns position of player in list based on player's ID.
     * @param id int representing ID of player.
     * @return int containing the player's index in the list.
     */
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
