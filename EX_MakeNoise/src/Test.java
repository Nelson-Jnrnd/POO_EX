public class Test {
    public static void main(String[] args) {
        Owner m = new Owner("Melanie");
        Noisy boucan[] = {new Cat("Cléa"), new Dog("Amine", "Grrr", m), new Dog("Pipou", "Woof", m)};
        for (Noisy n: boucan) {
            n.makeNoise();
        }
        Dog d = new Dog("d", "", m);
        Dog.non p = new Dog("d", "", m).new non();
    }
}
