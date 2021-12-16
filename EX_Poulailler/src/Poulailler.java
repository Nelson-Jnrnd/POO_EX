import java.util.LinkedList;
import java.util.Random;

public class Poulailler {
    private int tour = 0;
    private LinkedList poules = new LinkedList();
    private Random random = new Random();

    public void ajouter(Object p){
        poules.add(p);
    }
    public void tourSuivant(){
        System.out.println("-- Tour #" + ++tour);
        LinkedList<Oeuf> oeufs = new LinkedList<>();
        for (Object p : poules) {
            if(p instanceof Poule){
                for (int i = random.nextInt(3); i > 0; i--) {
                    // Il eclot
                    Oeuf trucQuiSortDeLoeuf = ((Poule) p).pondre();
                    oeufs.add(trucQuiSortDeLoeuf);
                }
            }
        }
        for(Oeuf oeuf : oeufs){
            Object trucQuiSortDeLoeuf = oeuf.eclore();
            // Seulement des poules dans le poulailler
            if (trucQuiSortDeLoeuf.getClass() == Poule.class) {
                Poule poussin = (Poule) trucQuiSortDeLoeuf;
                ajouter(poussin);
            }
        }
    }

    public static void main(String[] args){
        Poulailler p = new Poulailler();
        p.ajouter(new Poule("Cocotte"));
        p.ajouter(new Poule("Rosette"));

        for (int i = 0; i < 10; i++) {
            p.tourSuivant();
        }
    }
}
