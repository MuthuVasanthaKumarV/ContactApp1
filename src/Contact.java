import java.util.Comparator;

public class Contact implements Comparable<Contact> {
    String name;
    long phone_no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }


    public Contact(String name, long phone_no) {
        this.name = name;
        this.phone_no = phone_no;
    }



    @Override
    public int compareTo(Contact name) {
        int compareValue = this.name.compareTo(name.name);
        if (compareValue == 0) {
            return this.name.compareTo(name.name);
        }
        return compareValue;
    }
}

