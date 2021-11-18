public class Dog extends Animal implements Noisy{
    private final String noise;
    private final Owner owner;

    public Dog(String name, String noise, Owner owner) {
        super(name);
        this.noise = noise;
        this.owner = owner;
    }

    @Override
    public void makeNoise() {
        System.out.println("Le chien de " + owner + " fait " + noise);
    }
}
