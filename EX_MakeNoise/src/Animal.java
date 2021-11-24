public abstract class Animal {
    public String getName() {
        return name;
    }

    protected final String name;

    public Animal(String name) {
        this.name = name;
    }
}
