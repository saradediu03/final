import java.time.LocalDate;
/** Represents a person.
 */
public class Person {
    /** Represents person's first name.
     */
    private String firstName;
    /** Represents person's last name.
     */
    private String lastName;
    /** Represents person's date of birth.
     */
    private LocalDate DOB;
    /** Represents person's gender.
     */
    private String gender;

    /** Creates a person with the specified parameters.
     * @param fName The person's first name.
     * @param lName The person's last name.
     * @param birthDate The person's date of birth.
     * @param gen The person's gender.
     */
    public Person(String fName, String lName, LocalDate birthDate, String gen){
        firstName = fName;
        lastName = lName;
        DOB = birthDate;
        gender = gen;
    }
    /** Gets the person’s first name.
     * @return A string representing the person's first name.
     */
    public String getFirstName(){
        return firstName;
    }
    /** Gets the person’s last name.
     * @return A string representing the person's last name.
     */
    public String getLastName() {
        return lastName;
    }
    /** Gets the person’s date of birth.
     * @return A LocalDate representing the person's date of birth.
     */
    public LocalDate getDOB() {
        return DOB;
    }
    /** Gets the person’s gender.
     * @return A string representing the person's gender.
     */
    public String getGender() {
        return gender;
    }
    /** Sets the person’s first name.
     * @param firstName String containing the person's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /** Sets the person’s last name.
     * @param lastName String containing the person's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /** Sets the person’s date of birth.
     * @param DOB LocalDate containing the person's date of birth.
     */
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
    /** Sets the person’s gender.
     * @param gender String containing the person's gender.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** Formats output of person's attributes.
     * @return String containing the person's first name, last name, DOB, and gender.
     */
    public String toString(){
        return "First name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "DOB: " + DOB + "\n" + "Gender: " + gender + "\n";
    }
    /** Formats output of person's attributes with indent.
     * @return String containing the person's first name, last name, DOB, and gender indented.
     */
    public String toStringIndented(){
        return "\tFirst name: " + firstName + "\n" + "\tLast name: " + lastName + "\n" + "\tDOB: " + DOB + "\n" + "\tGender: " + gender + "\n";
    }
    /** Formats output of person's attributes.
     * @return String containing the person's first name, last name, DOB, and gender.
     */
    public String toStringOneLine(){
        String name = "                          ";
        name = (firstName + " " + lastName + name).substring(0, 20);
        return name + " | " + DOB + " | " + gender+"     ";
    }
}
