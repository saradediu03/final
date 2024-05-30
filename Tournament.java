import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
abstract class Tournament {
    private String name;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private String gender;
    private int ageGroup;
    protected ArrayList<RegisteredPlayer> registeredPlayers;
    private String selectionCriteria;
    private int drawSize;
    private TournamentDirector director;

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

    public boolean registerPlayer(Player player){
        Period period = Period.between(player.getDOB(), LocalDate.now());
        int playerAge =0;
        playerAge = period.getYears();
        if(player.getGender().equals(gender)&&playerAge<=ageGroup){
                RegisteredPlayer newlyRegistered = new RegisteredPlayer(player);
                registeredPlayers.add(newlyRegistered);
                return true;
            }

        //System.out.print(registeredPlayers);
        return false;
    }

    public void withdrawPlayer(Player player){
        for(int i=0;i<registeredPlayers.size();i++){
            if(registeredPlayers.get(i).getID() == player.getID()){
                registeredPlayers.get(i).setWithdrawn(true);
            }
        }
    }

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
//        if(registeredPlayers.size()>=drawSize){
//            for(int i=0;i<drawSize;i++) {
//                registeredPlayers.get(i).setSelected(true);
//            }
//        } else {
//            for(int i=0;i<registeredPlayers.size();i++) {
//                registeredPlayers.get(i).setSelected(true);
//            }
//        }
    }


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSelectionCriteria(String selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }

    public int getDrawSize() {
        return drawSize;
    }

    public void setDrawSize(int drawSize) {
        this.drawSize = drawSize;
    }

    public TournamentDirector getDirector() {
        return director;
    }

    public void setDirector(TournamentDirector director) {
        this.director = director;
    }
}
