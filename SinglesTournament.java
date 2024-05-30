import java.time.LocalDate;
/** Represents a singles tournament.
 * Extends Tournament class.
 */
public class SinglesTournament extends Tournament{
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
    public SinglesTournament(String name, String location, LocalDate startDate, LocalDate endDate, String gender, int ageGroup, String selectionCriteria, int drawSize, TournamentDirector director) {
        super(name, location, startDate, endDate, gender, ageGroup, selectionCriteria, drawSize, director);
    }
    /** Formats output of table of players in tournament.
     * @return String containing the tournament's players and their attributes in a table.
     */
    public String toString() {
        return super.toString();
    }
}
