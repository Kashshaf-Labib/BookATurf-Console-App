import java.sql.SQLOutput;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {

    public static void registerCustomer() throws UserValidationException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please provide the following information to register in 'BookATurf' ");

        System.out.println("Enter your Username:");

        String userName = sc.nextLine();

        System.out.println("Enter your email:");

        String userEmail = sc.nextLine();

        System.out.println("Enter your password:");

        String password = sc.nextLine();

        UserRegistrationService.registerUser(userName, userEmail, password);


    }


    public static void loginCustomer() throws UserValidationException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your User ID and password to login");

        System.out.println();

        System.out.println("User ID: ");

        int userID = sc.nextInt();

        System.out.println();

        System.out.println("Please enter your password: ");

        String password = sc.next();

        if (UserLoginService.userLogin(userID, password))
        {
            System.out.println("Login successful...");

            System.out.println();

            System.out.println("**** User Dashboard ****");

            System.out.println();

            System.out.println("1. Get details of all available turfs");

            System.out.println();

            System.out.println("2. Book a turf");

            System.out.println();

            System.out.println("3. Check Slot availability in your desired time");

            System.out.println();

            System.out.println("4. Check your booking details");

            System.out.println();

            System.out.println("5. Logout");

            System.out.println();


            while (true) {

                System.out.println("Please select an option from the Dashboard: ");

                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        Utility.getAllTurfDetails();
                        break;
                    case 2:
                        System.out.println("Please enter the turf ID to book a slot: ");
                        int turfID = sc.nextInt();
                        System.out.println("Please enter the slot ID to book: ");
                        int slotID = sc.nextInt();
                        System.out.println("Please enter payable amount: ");
                        int amount = sc.nextInt();

                        boolean found = false;

                        for (Turf t : Utility.turfList) {
                            if (t.turfID == turfID) {
                                found = true;
                                BookingService.bookSlot(t, slotID, amount);
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Please enter a valid turf ID");
                        }
                        break;

                    case 3:
                        System.out.println("Please enter the turf ID to check slot availability");
                        int trfID = sc.nextInt();
                        System.out.println("Please enter the starting time in HH:mm format (24 hour format)");
                        String startTime = sc.nextLine();
                        System.out.println("Please enter the ending time in HH:mm format (24 hour format)");
                        String endTime = sc.nextLine();

                        try {
                            LocalTime startingTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));

                            LocalTime endingTime = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));

                            boolean flag = false;

                            for (Turf t : Utility.turfList) {
                                if (t.turfID == trfID) {
                                    flag = true;
                                    SlotAvailabilityService.isSlotAvailable(t, startingTime, endingTime);
                                    break;
                                }
                            }
                            if (!flag) {
                                System.out.println("Please enter a valid turf ID");
                            }

                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter the time in HH:mm format.");
                            break;
                        }
                   case 4:
                        System.out.println("Please enter your user ID");
                        int userID1=sc.nextInt();
                        //BookingService.getBookingDetails(userID1);
                        break;
                    case 5:
                        System.out.println("You have been logged out successfully");
                        return;
                            default:
                                System.out.println("Please enter a valid option");
                                break;
                }
            }
        }
        else
        {
            throw new UserValidationException("Incorrect username or password, please try again");
        }



    }

}
