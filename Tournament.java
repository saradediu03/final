import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
/** Represents a tournament.
 */
abstract class Tournament {
    /** Represents the name of the tournament.
     */
    private String name;
    /** Represents the location of the tournament.
     */
    private String location;
    /** Represents the starting date of the tournament.
     */
    private LocalDate startDate;
    /** Represents the ending date of the tournament.
     */
    private LocalDate endDate;
    /** Represents the gender category of the tournament.
     */
    private String gender;
    /** Represents the age group category of the tournament.
     */
    private int ageGroup;
    /** Represents the ArrayList of the registered players in the tournament.
     */
    protected ArrayList<RegisteredPlayer> registeredPlayers;
    /** Represents the selection criteria of the tournament.
     */
    private String selectionCriteria;
    /** Represents the draw size (limit for number of players) of the tournament.
     */
    private int drawSize;
    /** Represents the director of the tournament.
     */
    private TournamentDirector director;

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
    public Tournament(String name, String location, LocalDate startDate, LocalDate endDate, String gender, int ageGroup, String selectionCriteria, int drawSize, TournamentDirector director) {
        this.name = name;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.selectionCriteria = selectionCriteria;
        this.drawSize = drawSize;
        this.director = director;
        registeredPlayers = new ArrayList<RegisteredPlayer>();
    }
    /** Registers player in tournament based on tournament's gender and age group categories by adding player to
     * registeredPlayers ArrayList.
     * @param player Player containing the player to be registered into tournament.
     * @return boolean if registration was successful or not.
     */
    public boolean registerPlayer(Player player){
        Period period = Period.between(player.getDOB(), LocalDate.now());
        int playerAge =0;
        playerAge = period.getYears();
        if(player.getGender().equals(gender)&&playerAge<=ageGroup){
                RegisteredPlayer newlyRegistered = new RegisteredPlayer(player);
                registeredPlayers.add(newlyRegistered);
                return true;
            }

        return false;
    }
    /** Withdraws player from tournament by setting player's withdrawn attribute to true.
     * @param player Player containing the player being withdrawn.
     */
    public void withdrawPlayer(Player player){
        for(int i=0;i<registeredPlayers.size();i++){
            if(registeredPlayers.get(i).getID() == player.getID()){
                registeredPlayers.get(i).setWithdrawn(true);
            }
        }
    }
    /** Selects players for tournament based on selection criteria of tournament by sorting the registered players
     * and setting player's selected attribute to true if selected.
     */
    public void makeSelection(){
        if(selectionCriteria.equals("Rank")){
            RegisteredPlayer smallerRank;
            for (int i=0; i < registeredPlayers.size()-1; i++){
                int index = i;
                for (int j = i + 1; j < registeredPlayers.size(); j++){
                    if (registeredPlayers.get(j).getRanking() < registeredPlayers.get(index).getRanking()){
                        index = j;
                    }
                }
                smallerRank = registeredPlayers.get(index);
                registeredPlayers.set(index, registeredPlayers.get(i));
                registeredPlayers.set(i, smallerRank);
            }
        } else if(selectionCriteria.equals("UTR")){
            RegisteredPlayer smallerUTR;
            for (int i=0; i < registeredPlayers.size()-1; i++){
                int index = i;
                for (int j = i + 1; j < registeredPlayers.size(); j++){
                    if (registeredPlayers.get(j).getUTRScore() > registeredPlayers.get(index).getUTRScore()){
                        index = j;
                    }
                }
                smallerUTR = registeredPlayers.get(index);
                registeredPlayers.set(index, registeredPlayers.get(i));
                registeredPlayers.set(i, smallerUTR);
            }
        }
        int i = 0;
        while(i<drawSize && i<registeredPlayers.size()){
            //System.out.print(i);
            if(!(registeredPlayers.get(i).isWithdrawn())){
                registeredPlayers.get(i).setSelected(true);

            }
            i++;
        }
    }

    /** Formats output of table of players in tournament.
     * @return String containing the tournament's players and their attributes in a table.
     */
    public String toString(){
        String s = "Name: " + name + "\n" + "Location: " + location + "\n" + "Start Date: " + startDate + "\n" +
                "End Date: " + endDate + "\n" + "Gender: " + gender + "\n" + "Age Group: " + ageGroup + "\n" +
                "Draw Size: " + drawSize + "\n" + "Director:\n" + director.toStringIndented();
        s += "Players:\n";
        s += "\tFull name            | DOB        | Gender | Rank  | UTR   | ID    | Sel | Wdr\n";
        s += "\t---------------------|------------|--------|-------|-------|-------|-----|----\n";
        for(int i=0;i<registeredPlayers.size();i++){
            s = s + "\t" + registeredPlayers.get(i).toStringOneLine() + "\n";
        }
        return s;
    }
    /** Gets the tournament’s name.
     * @return A string representing the tournament's name.
     */
    public String getName() {
        return name;
    }
    /** Sets the tournament’s name.
     * @param name String containing the tournament's name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /** Gets the tournament’s location.
     * @return A string representing the tournament's location.
     */
    public String getLocation() {
        return location;
    }
    /** Sets the tournament’s location.
     * @param location String containing the tournament's location.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /** Gets the tournament’s starting date.
     * @return A LocalDate representing the tournament's starting date.
     */
    public LocalDate getStartDate() {
        return startDate;
    }
    /** Sets the tournament’s starting date.
     * @param startDate LocalDate containing the tournament's starting date.
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    /** Gets the tournament’s ending date.
     * @return A LocalDate representing the tournament's ending date.
     */
    public LocalDate getEndDate() {
        return endDate;
    }
    /** Sets the tournament’s ending date.
     * @param endDate LocalDate containing the tournament's ending date.
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    /** Gets the tournament’s gender category.
     * @return A string representing the tournament's gender category.
     */
    public String getGender() {
        return gender;
    }
    /** Sets the tournament’s gender category.
     * @param gender String containing the tournament's gender category.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /** Gets the tournament’s age group.
     * @return An int representing the tournament's age group.
     */
    public int getAgeGroup() {
        return ageGroup;
    }
    /** Sets the tournament’s age group.
     * @param ageGroup int containing the tournament's age group.
     */
    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }
    /** Gets the tournament’s selection criteria.
     * @return A string representing the tournament's selection criteria.
     */
    public String getSelectionCriteria() {
        return selectionCriteria;
    }
    /** Sets the tournament’s selection criteria.
     * @param selectionCriteria String containing the tournament's selection criteria.
     */
    public void setSelectionCriteria(String selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }
    /** Gets the tournament’s draw size.
     * @return An int representing the tournament's draw size.
     */
    public int getDrawSize() {
        return drawSize;
    }
    /** Sets the tournament’s draw size.
     * @param drawSize int containing the tournament's draw size.
     */
    public void setDrawSize(int drawSize) {
        this.drawSize = drawSize;
    }
    /** Gets the tournament’s director.
     * @return A TournamentDirector representing the tournament's director.
     */
    public TournamentDirector getDirector() {
        return director;
    }
    /** Sets the tournament’s director.
     * @param director TournamentDirector containing the tournament's director.
     */
    public void setDirector(TournamentDirector director) {
        this.director = director;
    }
}
