import java.util.*;

public class ContactFunction {
    static List list = new LinkedList<Contact>();
    ;
    static Scanner in=new Scanner(System.in);

    public static void create()
    {
        System.out.println("Enter the name");
        String name = in.next();
        in.nextLine();
        long num=0;
        try {
            System.out.println("Enter the number");
             num = in.nextLong();

        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number");
            in.nextLine();
            num = in.nextLong();
        }
        String number =String.valueOf(num);
        if(number.length()!=10)
        {
            System.out.println("You Enter More or less in 10 digit.Re enter the number");
            in.nextLine();
            num = in.nextLong();
        }

        if (checker(num)) {
            try {
                throw new NumberPresent();
            } catch (NumberPresent e) {
                System.out.println(e);
                create();
            }

        }
        else {
            list.add(new Contact(name,num));
        }
    }

    public static boolean checker(long num) {
        boolean b = false;
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Contact contact = (Contact) list.get(i);
                long number = contact.getPhone_no();
                if (number == num) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
    public static boolean  valid(long n)
    {
        boolean b = false;
        int count =0;
        while(n>0)
        {
            long r=n/10;
            count++;
        }
        if(count==10)
        {
           b= true;
        }
            return b;
    }

    public static void search(String name) {
        ListIterator i = list.listIterator();
        while (i.hasNext()) {
            Contact contact = (Contact) i.next();
            if (contact.getName().equals(name)) {
                System.out.println(contact.getName() + " : " + contact.getPhone_no());
            }
        }
    }

    public static void searchnum(long num) {
        ListIterator i = list.listIterator();
        while (i.hasNext()) {
            Contact contact = (Contact) i.next();
            long number = contact.getPhone_no();
            if (number == num) {
                System.out.println(contact.getName() + " : " + contact.getPhone_no());
            }
            else {
                System.out.println("No Number is present in contact");
            }
        }
    }

    public static void deleteName(String name) {
        for (int i = 0; i < list.size(); i++) {
            Contact contact = (Contact) list.get(i);
            if (contact.getName().equals(name)) {
                System.out.println(contact.getName() + ":" + contact.getPhone_no());
            }
        }
        System.out.println("Enter the Number to delete");
        deleteNumber(in.nextLong());
    }

    public static void deleteNumber(long num) {

        for (int i = 0; i < list.size(); i++) {
            Contact contact = (Contact) list.get(i);
            long number = contact.getPhone_no();
            if (num == number) {
                list.remove(i);
            }
        }
    }

    public static void updateContact() {
        System.out.println("Enter The old Name:");
        String s = in.next();
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            Contact contact = (Contact) list.get(i);
            if (contact.getName().equals(s)) {
                System.out.println(contact.getName() + " --> " + contact.getPhone_no());
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Do You want Update 1.Name or 2.Number");
            int a = in.nextInt();
            if (a == 1) {
                System.out.println("Enter the Old Name:");
                String s1 = in.next();
                System.out.println(" Please enter the New Name:");
                String s2 = in.next();
                for (int i = 0; i < list.size(); i++) {
                    Contact contact = (Contact) list.get(i);
                    if (contact.getName().equals(s1)) {
                        contact.setName(s2);
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    Contact contact = (Contact) list.get(i);
                    System.out.println(contact.getName() + " --> " + contact.getPhone_no());
                }
            } else if (a == 2) {
                System.out.println("Enter the Old Number");
                Long l1 = in.nextLong();
                System.out.println(" Please enter the New Number:");
                Long l2 = in.nextLong();
                for (int i = 0; i < list.size(); i++) {
                    Contact contact = (Contact) list.get(i);
                    if (contact.getPhone_no() == l1) {
                        contact.setPhone_no(l2);
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    Contact contact = (Contact) list.get(i);
                    System.out.println(contact.getName() + " --> " + contact.getPhone_no());
                }
            }
        } else if (count >= 2) {
            System.out.println("2 or More Name Present in Your Contact");
            System.out.println("Enter the Number :");
            Long num = in.nextLong();
            System.out.println(" Please enter the New Name:");
            String s1 = in.next();



            for (int i = 0; i < list.size(); i++) {
                Contact contact = (Contact) list.get(i);
                if (contact.getName().equals(s) && contact.getPhone_no() == num) {
                    contact.setName(s1);
                }
            }

            System.out.println("Names updated successfully. Updated names and numbers:");
            for (int i = 0; i < list.size(); i++) {
                Contact contact = (Contact) list.get(i);
                System.out.println(contact.getName() + " --> " + contact.getPhone_no());
            }
        }
    }

    public static void displayContact() {
        for (int i = 0; i < list.size(); i++)
        {
            Contact contact = (Contact) list.get(i);
            Collections.sort(list);
            System.out.println("Name : " + contact.getName());
            System.out.println("Number : " + contact.getPhone_no());

        }
    }
}
