import java.time.LocalDate;

public class RegisteredPlayer extends Player{
    private boolean selected;
    private boolean withdrawn;



    public RegisteredPlayer(String fName, String lName, LocalDate birthDate, String gen, int ranking, double UTR, String domHand, int ID) {
        super(fName, lName, birthDate, gen, ranking, UTR, domHand, ID);
        selected = false;
        withdrawn = false;
    }

    public RegisteredPlayer(Player player){
        super("","",null, "", 0, 0, "", 0);
        this.setFirstName(player.getFirstName());
        this.setLastName(player.getLastName());
        this.setID(player.getID());
        this.setDOB(player.getDOB());
        this.setGender(player.getGender());
        this.setRanking(player.getRanking());
        this.setUTRScore(player.getUTRScore());
        this.setDominantHand(player.getDominantHand());
        selected = false;
        withdrawn = false;
//        super(player.getFirstName(), player.getLastName(), player.getDOB(), player.getGender(), player.getRanking(), getUTRScore(), player.getDominantHand(), player.getID());
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }

    public String toStringOneLine(){
        String xSelected = "   ";
        String xWithdrawn = "   ";
        if(selected){
            xSelected = " x ";
        }
        if(withdrawn){
            xWithdrawn = " x ";
        }
        return super.toStringOneLine() + " | " + xSelected + " | " + xWithdrawn;
    }
}