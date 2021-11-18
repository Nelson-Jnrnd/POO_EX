public abstract class Animal {
    public String getName() {
        return name;
    }

    private final String name;

    public Animal(String name) {
        this.name = name;
    }
}
