/**
 * Authors:     Alen Bijelic, Nelson Jeanrenaud
 * Date:        28.10.2021
 *
 * Description: ObjectTypesArray is able to count the number of different classes
 *              in a given Object array. The results are available via the toString method.
 *
 * Comments:    none.
 */
import java.util.Arrays;
import java.util.Comparator;

public class ObjectTypesArray {
    ObjectType[] objects;

    public ObjectTypesArray(Object[] objects){
        if(objects != null) {

            Comparator<Object> objectComparator = new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {
                    return o1.getClass().hashCode() - o2.getClass().hashCode();
                }
            };
            Arrays.sort(objects, objectComparator);

            // Counting nb of different classes to set the length of our array
            int nbClasses = 1;
            for (int i = 1; i < objects.length; i++) {
                if(objects[i-1].getClass() != objects[i].getClass())
                    nbClasses++;
            }
            this.objects = new ObjectType[nbClasses];

            // Populating the array
            Class currentClass = objects[0].getClass();
            this.objects[0] = new ObjectType(objects[0].getClass());
            int typeObjectIndex = 0;
            for (int i = 1; i < objects.length; i++) {
                // if the current object is a new class we move in the class array
                // otherwise, we increment
                if(currentClass != objects[i].getClass()) {
                    this.objects[++typeObjectIndex] = new ObjectType(objects[i].getClass());
                    currentClass = objects[i].getClass();
                }
                else{
                    this.objects[typeObjectIndex].incrementOccurence();
                }
            }
        }
    }

    public String toString(){
        StringBuilder returnString = new StringBuilder();
        for (ObjectType obj : objects) {
            returnString.append(obj);
        }
        return returnString.toString();
    }
}

class ObjectType {
    private int numberOfOccurence;
    private final Class classType;

    public ObjectType(Class classType) {
        this.numberOfOccurence = 1;
        this.classType = classType;
    }
    public void incrementOccurence(){
        numberOfOccurence++;
    }
    public String toString(){
        return classType.getName() + " " + numberOfOccurence + '\n';
    }
}

class Main {
    public static void main(String[] args) {
        String s = "s";
        int i = 1;
        boolean b = true;
        int i2 = 2;
        int i3 = 0;
        int i4 = -1;
        String s2 = "a";

        Object[] array = {s, i, b, i2, i3, s2, i4};
        ObjectTypesArray ota = new ObjectTypesArray(array);
        System.out.println(ota);
    }
}