public class Poule {
    private String nom;
    private int nbPontes = 0;

    public Poule(String s){
        nom = s;
    }
    public Oeuf pondre(){
        System.out.println(nom + " pond son oeuf #" + ++nbPontes);
        return new Oeuf() {
            Poule maman = Poule.this;
            @Override
            public Poule eclore() {
                Poule moi = new Poule(nom + nbPontes);
                System.out.println(moi.nom + " sort de l'oeuf #" + maman.nbPontes + " de " + maman.nom);
                return moi;
            }
        };
    }
}
