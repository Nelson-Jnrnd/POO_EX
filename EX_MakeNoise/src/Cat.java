public class Cat extends Animal implements Noisy{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("Mraow");
    }
}
