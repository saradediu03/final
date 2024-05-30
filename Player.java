import java.time.LocalDate;
/** Represents a player.
 * Extends Person class.
 */
public class Player extends Person{
    /** Represents player's rank.
     */
    private int ranking;
    /** Represents player's UTR score.
     */
    private double UTRScore;
    /** Represents player's dominant hand.
     */
    private String dominantHand;
    /** Represents player's ID.
     */
    private int ID;
    /** Creates a player with the specified parameters.
     * @param fName The player's first name.
     * @param lName The player's last name.
     * @param birthDate The player's date of birth.
     * @param gen The player's gender.
     * @param ranking The player's rank.
     * @param UTR The player's UTR score.
     * @param domHand The player's dominant hand.
     * @param ID The player's ID.
     */
    public Player(String fName, String lName, LocalDate birthDate, String gen, int ranking, double UTR, String domHand, int ID) {
        super(fName, lName, birthDate, gen);
        this.ranking = ranking;
        UTRScore = UTR;
        dominantHand = domHand;
        this.ID = ID;
    }

    /** Gets the player’s rank.
     * @return An int representing the player's rank.
     */
    public int getRanking() {
        return ranking;
    }
    /** Gets the player’s UTR score.
     * @return A double representing the player's UTR score.
     */
    public double getUTRScore() {
        return UTRScore;
    }
    /** Gets the player’s dominant hand.
     * @return A string representing the player's dominant hand.
     */
    public String getDominantHand() {
        return dominantHand;
    }
    /** Gets the player’s ID.
     * @return An int representing the player's ID.
     */
    public int getID() {
        return ID;
    }

    /** Sets the player’s rank.
     * @param ranking int containing the player's rank.
     */
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    /** Sets the player’s UTR score.
     * @param UTRScore double containing the player's UTR score.
     */
    public void setUTRScore(double UTRScore) {
        this.UTRScore = UTRScore;
    }
    /** Sets the player’s dominant hand.
     * @param dominantHand string containing the player's dominant hand.
     */
    public void setDominantHand(String dominantHand) {
        this.dominantHand = dominantHand;
    }
    /** Sets the player’s ID.
     * @param ID int containing the player's ID.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /** Formats output of player's attributes.
     * @return String containing the player's traits.
     */
    public String toString(){
        return super.toString() + "Ranking: " + ranking + "\n" + "UTR Score: " + UTRScore + "\n" + "Dominant Hand: " + dominantHand + "\n" + "ID: " + ID + "\n";
    }
    /** Reduces or lengthens a string to specified length.
     * @param s String containing original string.
     * @param l int containing required length for string.
     * @return String containing original String reduced or lengthened to specified length.
     */
    private String toFixedLength(String s, int l)
    {
        String t = "                          ";
        t = (s+t).substring(0, l);
        return t;
    }
    /** Formats output of player's attributes.
     * @return String containing the player's traits on one line.
     */
    public String toStringOneLine(){

        return super.toStringOneLine() + " | " + toFixedLength("" + ranking, 5) + " | " + toFixedLength("" + UTRScore, 5) + " | " + toFixedLength("" + ID, 5);

    }
}
