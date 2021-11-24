import java.util.Arrays;
import java.util.Objects;

public abstract class Season {
    public String name() {
        return name;
    }

    public int ordinal() {
        return ordinal;
    }

    protected final String name;
    protected final int ordinal;

    private Season(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public final static SeasonObj Spring = new SeasonObj("Spring", 0);
    public final static SeasonObj Summer = new SeasonObj("Summer", 1);
    public final static SeasonObj Autumn = new SeasonObj("Autumn", 2);
    public final static SeasonObj Winter = new SeasonObj("Winter", 3);

    public static Season[] values(){
        return new Season[] {Spring, Summer, Autumn, Winter};
    }
    public static Season value(String name){
        for (Season s: values()) {
            if(Objects.equals(s.name, name))
                return s;
        }
        return null;
    }

    public Season next(){
        Season[] seasons = values();
        return seasons[Math.floorMod(ordinal + 1, seasons.length)];
    }

    public Season previous(){
        Season[] seasons = values();
        return seasons[Math.floorMod(ordinal - 1, seasons.length)];
    }

    public static Season[] range(Season first, Season last){
        return Arrays.copyOfRange(values(), first.ordinal, last.ordinal);
    }

    private static class SeasonObj extends Season{

        private SeasonObj(String name, int ordinal) {
            super(name, ordinal);
        }

        @Override
        public String toString() {
            return name + "(" + ordinal + ")";
        }
    }
}