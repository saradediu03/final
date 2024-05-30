import java.time.LocalDate;

public class SinglesTournament extends Tournament{
    public SinglesTournament(String name, String location, LocalDate startDate, LocalDate endDate, String gender, int ageGroup, String selectionCriteria, int drawSize, TournamentDirector director) {
        super(name, location, startDate, endDate, gender, ageGroup, selectionCriteria, drawSize, director);
    }

    public String toString() {
        return super.toString();
    }
}
