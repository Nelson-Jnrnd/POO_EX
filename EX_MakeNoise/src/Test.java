public class Test {
    public static void main(String[] args) {
        Noisy boucan[] = {new Cat("Cléa"), new Dog("Amine", "Grrr", "Mélanie"), new Dog("Pipou", "Woof", "Bob")};
        for (Noisy n: boucan) {
            n.makeNoise();
        }
    }
}
