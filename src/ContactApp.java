import java.util.*;

public class ContactApp
{
    static Scanner in;


    public static void main(String[] args)
    {
        in=new Scanner(System.in);
        int task=0;
        boolean b=true;
        while (b){
            System.out.println("****Contact App****");
            System.out.println("1.Create contact\t 2.Delete Contact\t 3.Search Contact\t 4.Update Contact\t 5.Display all contact\t 6.Exit");
            try {

                 task = in.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("Invalid Input");
                main(args);
            }

                switch (task) {
                    case 1: {
                       ContactFunction.create();
                        System.out.println("Contact has been Added");
                        break;
                    }
                    case 2: {
                        System.out.println("Do you want to Delete by 1.name or 2.number");
                        switch (in.nextInt()) {
                            case 1: {
                                System.out.println("Enter the name");
                                ContactFunction.deleteName(in.next());
                                break;
                            }
                            case 2: {
                                System.out.println("Enter the number");
                                ContactFunction.deleteNumber(in.nextLong());
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Do you want to search by 1.name or 2.number");
                        switch (in.nextInt()) {
                            case 1: {
                                System.out.println("Enter the name");
                                ContactFunction.search(in.next());
                                break;
                            }
                            case 2: {
                                System.out.println("Enter the number");
                                ContactFunction.searchnum(in.nextLong());
                                break;
                            }
                        }

                        break;
                    }
                    case 4: {
                        ContactFunction.updateContact();
                        break;
                    }
                    case 5: {
                        ContactFunction.displayContact();
                        break;
                    }
                    case 6: {
                        System.exit(0);
                        break;
                    }
                }
            }
            }
         }



