import java.time.LocalDate;
/** Represents a registered player.
 * Extends Player class.
 */
public class RegisteredPlayer extends Player{
    /** Represents if player is selected.
     */
    private boolean selected;
    /** Represents if player is withdrawn.
     */
    private boolean withdrawn;

    /** Creates a registered player with the specified parameters and sets selected and withdrawn to false.
     * @param fName The player's first name.
     * @param lName The player's last name.
     * @param birthDate The player's date of birth.
     * @param gen The player's gender.
     * @param ranking The player's rank.
     * @param UTR The player's UTR score.
     * @param domHand The player's dominant hand.
     * @param ID The player's ID.
     */
    public RegisteredPlayer(String fName, String lName, LocalDate birthDate, String gen, int ranking, double UTR, String domHand, int ID) {
        super(fName, lName, birthDate, gen, ranking, UTR, domHand, ID);
        selected = false;
        withdrawn = false;
    }
    /** Creates a registered player with the parameters of a given Player.
     * @param player Player whose attributes will be copied by registered player.
     */
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
    }
    /** Gets the player’s selected value.
     * @return A boolean representing if the player is selected.
     */
    public boolean isSelected() {
        return selected;
    }
    /** Sets the player’s selected value.
     * @param selected representing player selected value.
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    /** Gets the player’s withdrawn value.
     * @return A boolean representing if the player is withdrawn.
     */
    public boolean isWithdrawn() {
        return withdrawn;
    }
    /** Sets the player’s withdrawn value.
     * @param withdrawn representing player withdrawn value.
     */
    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }
    /** Formats output of registered player's attributes.
     * @return String containing the registered player's traits on one line.
     */
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