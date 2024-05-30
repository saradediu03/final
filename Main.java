import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        //System.out.println("Hello");
        Player bob = new Player("bob", "jim", LocalDate.of(2007, 3, 12), "M", 53, 4.54, "Left", 1);
        Player john = new Player("John", "Drops", LocalDate.of(2012, 5, 27), "M", 3, 6.74, "Right", 2);
        Player steve = new Player("Steve", "Drops", LocalDate.of(2012, 5, 27), "M", 3, 6.74, "Right", 3);
        Player billy = new Player("Billy", "Drops", LocalDate.of(2012, 5, 27), "M", 3, 6.74, "Right", 4);
        Player mike = new Player("Mike", "Drops", LocalDate.of(2012, 5, 27), "M", 3, 6.74, "Right", 5);
        Player jim = new Player("Jim", "Drops", LocalDate.of(2012, 5, 27), "M", 3, 6.74, "Right", 6);
        Player sara = new Player("Sara", "Figs", LocalDate.of(2012, 9, 03), "F", 7, 5.21, "Right", 7);

        //System.out.print(bob);
        TournamentDirector bill = new TournamentDirector("bill", "john", LocalDate.of(2000, 12, 3), "M", "billjohn@gmail.com", "4087898767");
        SinglesTournament t1 = new SinglesTournament("Indian Wells", "San Francisco",
                LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 9), "M", 18, "UTR", 64, bill);

        boolean r1=t1.registerPlayer(bob);
        boolean r2=t1.registerPlayer(john);
        t1.withdrawPlayer(bob);
        t1.makeSelection();
        System.out.print(t1);

        System.out.print(t1);
        boolean r3= t1.registerPlayer(sara);


        DoublesTournament t2 = new DoublesTournament("U12 Doubles", "San Francisco",
                LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 9), "M", 18, "UTR", 64, bill);

        t2.registerPlayer(bob);
        t2.registerPlayer(john);
        t2.registerPlayer(steve);
        t2.registerPlayer(billy);

        t2.pair(bob, john);
        t2.pair(steve, billy);
        t2.makeSelection();
        System.out.println(t2);
    }
}
