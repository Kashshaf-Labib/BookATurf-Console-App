import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("****** Welcome to BookATurf ******");

        System.out.println();

        System.out.println("1. Register as a customer");

        System.out.println();

        System.out.println("2. Login as a Customer");

        System.out.println();

        System.out.println("3. Login as an Admin");

        System.out.println();

        System.out.println("4. Exit");

        System.out.println();

        Scanner sc=new Scanner(System.in);


        while(true)
        {

            System.out.println("Please select an option:");

            int option=sc.nextInt();

            switch(option)
            {
                case 1:
                    try {
                        UserInterface.registerCustomer();
                        Utility.getAllUserDetails();
                    } catch (UserValidationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            /*case 2:
                try {
                    UserInterface.loginCustomer();
                } catch (UserValidationException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try {
                    UserInterface.loginAdmin();
                } catch (UserValidationException e) {
                    System.out.println(e.getMessage());
                }
                break; */
             case 4:
                System.out.println("Thank you for using BookATurf");
                return;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }

        }




    }
}