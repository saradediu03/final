import java.time.LocalDate;

public class TournamentDirector extends Person{
    private String contactEmail;
    private String contactPhone;

    public TournamentDirector(String fName, String lName, LocalDate birthDate, String gen, String email, String phone) {
        super(fName, lName, birthDate, gen);
        contactEmail = email;
        contactPhone = phone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
