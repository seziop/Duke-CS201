import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {

    public class Person {
        String firstName;
        String lastName;

        Person(String x, String y) {
            lastName = y;
            firstName = x;
        }

        public String getLast() {
            return lastName;
        }

        public String getFirst() {
            return firstName;
        }
        public String toString() {
            return firstName + " " + lastName;
        }

    }

    public Person[] cleanup(String[] names) {
        Person[] ret = new Person[names.length];
        int index = 0;
        for (String name : names) {
            if (name.indexOf(",") == -1) {
                String[] temp = name.split(" ");
                ret[index] = new Person(temp[0], temp[1]);
            } else {
                String[] temp = name.split(",");
                ret[index] = new Person(temp[1].substring(1), temp[0]);
            }
            index++;
        }
        return ret;
    }

    public String[] dataCleanup(String[] names) {
        Person[] list = cleanup(names);

        Arrays.sort(list, Comparator.comparing(Person::getLast).thenComparing(Person::getFirst));

        for (int k = 0; k < names.length; k++) {
            names[k] = list[k].toString();
        }

        return names;
    }
}