import java.util.Iterator;

public class Examinator implements Iterator<Element> {
    private Element current;

    public Examinator(Element current) {
        this.current = current;
    }

    public boolean hasNext(){
        return current != null;
    }
    public Element next(){
        Element returnval = current;
        current = current.next;
        return returnval;
    }
}
