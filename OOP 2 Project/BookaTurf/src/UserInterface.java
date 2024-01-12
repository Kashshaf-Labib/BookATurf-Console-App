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


    public static void loginCustomer() throws UserValidationException {

        Scanner sc=new Scanner(System.in);

        System.out.println("Please enter your User ID and password to login");

        System.out.println();

        System.out.println("User ID: ");

        int userID=sc.nextInt();

        System.out.println();

        System.out.println("Please enter your password: ");

        String password=sc.next();

        if(UserLoginService.userLogin(userID,password))
        {
            System.out.println("Login successful...");

            System.out.println();

            System.out.println("**** User Dashboard ****");

            System.out.println();

            System.out.println("1. Get details of all available turfs");

            System.out.println();

            System.out.println("2. Book a turf");

            System.out.println();

            System.out.println("3. Check Slot availability in a specific time");

            System.out.println();

            System.out.println("4. Check your booking details");

            System.out.println();

            System.out.println("5. Logout");

            System.out.println();

            System.out.println("Please select an option: ");

            int option=sc.nextInt();

            switch (option)
            {
                case 1:
                    Utility.getAllTurfDetails();
                    break;
                case 2:
                    System.out.println("Please enter the turf ID to book a slot: ");
                    int turfID=sc.nextInt();
                    System.out.println("Please enter the slot ID to book: ");
                    int slotID=sc.nextInt();
                    System.out.println("Please enter the amount to pay: ");
                    int amount=sc.nextInt();

                    for(Turf t:Utility.turfList)
                    {
                        if(t.turfID==turfID)
                        {
                            BookingService.bookSlot(t,slotID,amount);
                            break;
                        }
                    }

//                case 3:
//                    System.out.println("Please enter the turf ID to check slot availability");
//                    int turfID1=sc.nextInt();
//                    System.out.println("Please enter the starting time");
//                    String startingTime=sc.nextLine();
//                    System.out.println("Please enter the ending time");
//                    String endingTime=sc.nextLine();
//                    BookingService.checkSlotAvailability(turfID1,startingTime,endingTime);
//                    break;
//                case 4:
//                    System.out.println("Please enter your user ID");
//                    int userID1=sc.nextInt();
//                    BookingService.getBookingDetails(userID1);
//                    break;
                case 5:
                    System.out.println("You have been logged out successfully");
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }

        }
        else
        {
            throw new UserValidationException("Incorrect username or password, please try again");
        }


    }
}
