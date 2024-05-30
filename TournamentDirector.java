import java.time.LocalDate;
/** Represents a tournament director.
 */
public class TournamentDirector extends Person{
    /** Represents director email.
     */
    private String contactEmail;
    /** Represents director phone.
     */
    private String contactPhone;
    /** Creates a director with the specified parameters.
     * @param fName The person's first name.
     * @param lName The person's last name.
     * @param birthDate The person's date of birth.
     * @param gen The person's gender.
     * @param email THe director's email.
     * @param phone The director's email.
     */
    public TournamentDirector(String fName, String lName, LocalDate birthDate, String gen, String email, String phone) {
        super(fName, lName, birthDate, gen);
        contactEmail = email;
        contactPhone = phone;
    }
}
