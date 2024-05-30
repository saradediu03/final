import java.time.LocalDate;


public class Person {
    private String firstName;
    private String lastName;
    private LocalDate DOB;
    private String gender;

    public Person(String fName, String lName, LocalDate birthDate, String gen){
        firstName = fName;
        lastName = lName;
        DOB = birthDate;
        gender = gen;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString(){
        return "First name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "DOB: " + DOB + "\n" + "Gender: " + gender + "\n";
    }
    public String toStringIndented(){
        return "\tFirst name: " + firstName + "\n" + "\tLast name: " + lastName + "\n" + "\tDOB: " + DOB + "\n" + "\tGender: " + gender + "\n";
    }

    public String toStringOneLine(){
        String name = "                          ";
        name = (firstName + " " + lastName + name).substring(0, 20);
        return name + " | " + DOB + " | " + gender+"     ";
    }
}
