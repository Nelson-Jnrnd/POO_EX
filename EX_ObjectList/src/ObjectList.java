public class ObjectList {

    private Element head;

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
        Examinator currentElement = new Examinator(head);
        while (currentElement.next() != null) {
        }
        ((Element) (currentElement.current())).next = new Element(o);
    }

    public void remove(Object o) {

    }

    public Object get(int index) {
        int counter = 0;
        Examinator currentElement = new Examinator(head);
        while (currentElement.next() != null) {
            if (counter++ == index) {
                return currentElement.current();
            }
        }
        throw new RuntimeException("Index is out of bounds");
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        Examinator currentElement = new Examinator(head);
        while (currentElement.next() != null) {
            s.append((Element)currentElement.current());
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
            lst.insert(i);
            System.out.println("Iteration " + i + ": " + lst);
        }
    }
}

