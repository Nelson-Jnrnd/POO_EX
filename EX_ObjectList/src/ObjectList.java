public class ObjectList {

    private Element head;
    private Examinator iterator;

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        int counter = 0;
        Examinator currentElement = new Examinator(head);
        while (currentElement.next() != null) {
            counter++;
        }
        return counter;
    }

    public void insert(Object o) {
        Element oldHead = head;
        head = new Element(o);
        head.next = oldHead;
    }

    public void append(Object o) {
        if(iterator == null){
            iterator = new Examinator(head == null ? new Element(o) : head);
        }
        Element last = iterator.next();
        if(last != null){
            boolean wasNull = last.next == null;
            last.next = new Element(o);
            if(wasNull)
                iterator = new Examinator(last.next);
        }
    }

    public void remove(Object o) {
        Examinator currentElement = new Examinator(head);
        Examinator prevElement = new Examinator(head);
        Element curr = currentElement.next();
        while (currentElement.hasNext()) {
            curr = currentElement.next();
            if(curr.data == o){
                prevElement.next().next = curr.next;
            }else{
                prevElement.next();
            }
        }
    }

    public Object get(int index) {
        int counter = 0;
        Examinator currentElement = new Examinator(head);
        while (currentElement.next() != null) {
            if (counter++ == index) {
               // return currentElement.current();
            }
        }
        throw new RuntimeException("Index is out of bounds");
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        if(head == null){
            return "";
        }
        for(Examinator currentElement = new Examinator(head);currentElement.hasNext();) {
            s.append(currentElement.next());
            if (currentElement.hasNext()) {
                s.append("-");
            }
        }
        return s.toString();
    }
}

class Element {
    Object data;
    Element next;

    public Element(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}


class Main {
    public static void main(String[] args) {
        ObjectList lst = new ObjectList();

        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0){
                lst.insert(i);
            }else{
                lst.append(i);
            }
            if(i == 5){
                lst.remove(0);
                lst.remove(1);
                lst.remove(9);
            }
            System.out.println("Iteration " + i + ": " + lst);
        }

    }
}

