import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInterface {

    public static void registerCustomer() throws UserValidationException {

        Scanner sc=new Scanner(System.in);

        System.out.println("Please provide the following information to register in 'BookATurf' ");

        System.out.println("Enter your Username:");

        String userName=sc.nextLine();

        System.out.println("Enter your email:");

        String userEmail=sc.nextLine();

        System.out.println("Enter your password:");

        String password=sc.nextLine();

        UserRegistrationService.registerUser(userName,userEmail,password);


    }
}
