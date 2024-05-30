import java.time.LocalDate;

public class Player extends Person{
    private int ranking;
    private double UTRScore;
    private String dominantHand;
    private int ID;

    public Player(String fName, String lName, LocalDate birthDate, String gen, int ranking, double UTR, String domHand, int ID) {
        super(fName, lName, birthDate, gen);
        this.ranking = ranking;
        UTRScore = UTR;
        dominantHand = domHand;
        this.ID = ID;
    }


    public int getRanking() {
        return ranking;
    }

    public double getUTRScore() {
        return UTRScore;
    }

    public String getDominantHand() {
        return dominantHand;
    }

    public int getID() {
        return ID;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setUTRScore(double UTRScore) {
        this.UTRScore = UTRScore;
    }

    public void setDominantHand(String dominantHand) {
        this.dominantHand = dominantHand;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String toString(){
        return super.toString() + "Ranking: " + ranking + "\n" + "UTR Score: " + UTRScore + "\n" + "Dominant Hand: " + dominantHand + "\n" + "ID: " + ID + "\n";
    }
    private String toFixedLength(String s, int l)
    {
        String t = "                          ";
        t = (s+t).substring(0, l);
        return t;
    }

    public String toStringOneLine(){

        return super.toStringOneLine() + " | " + toFixedLength("" + ranking, 5) + " | " + toFixedLength("" + UTRScore, 5) + " | " + toFixedLength("" + ID, 5);

    }
}
