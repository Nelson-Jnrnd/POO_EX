public class Dog extends Animal implements Noisy{
    private final String noise;
    private final Owner owner;

    public Dog(String name, String noise, Owner owner) {
        super(name);
        this.noise = noise;
        this.owner = owner;
        Bidule b = new Bidule();
    }
    private class Bidule{
        int t;
        Bidule b;
        private Bidule getB(){
            return new Bidule();
        }
    }
    public class non{
        Bidule p = new Bidule();
        public Bidule getB(){
            return p.getB();
        }
    }

    @Override
    public void makeNoise() {
        System.out.println("Le chien de " + owner + " fait " + noise);
    }
}
