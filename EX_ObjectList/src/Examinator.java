public class Examinator {
    private Element current;

    public Examinator(Element current) {
        this.current = current;
    }

    public boolean hasNext(){
        if(current == null)
            return false;
        return current.next != null;
    }
    public Object next(){
        if(current != null)
            current = current.next;
        return current;
    }
    public Object current(){
        return current;
    }
}
