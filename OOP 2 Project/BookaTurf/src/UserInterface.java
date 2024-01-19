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

        if (UserLoginService.userLogin(userID, password)) {
            System.out.println("Login successful...");

            System.out.println();

            System.out.println("**** User Dashboard ****");

            System.out.println();

            System.out.println("1. Get details of all available turfs");

            System.out.println();

            System.out.println("2. Book a turf");

            System.out.println();

            System.out.println("3. Check slot availability in your desired time");

            System.out.println();

            System.out.println("4. Check your booking details");

            System.out.println();

            System.out.println("5. Logout");

            System.out.println();


            while (true) {

                System.out.println("Please select an option from the User Dashboard: ");

                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        for(Turf t:Utility.turfList)
                        {
                            TurfDetailService.getTurfDetails(t);
                        }
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
                                BookingService.bookSlot(t, slotID, amount, userID);
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Please enter a valid turf ID");
                        }
                        break;

                    case 3:
                        System.out.println("Please enter the starting time in HH:mm format (24 hour format):");
                        String startTime = sc.next();
                        System.out.println("Please enter the ending time in HH:mm format (24 hour format)");
                        String endTime = sc.next();

                        try {
                            LocalTime startingTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));

                            LocalTime endingTime = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));

                            boolean flag = false;


                            for(Turf t:Utility.turfList)
                            {
                                int id=SlotAvailabilityService.isSlotAvailable(t, startingTime, endingTime);
                                if(id!=-1)
                                {
                                    flag=true;
                                    System.out.println("Slot is available in the given time in "+t.turfName);
                                    break;
                                }
                            }
                            if(!flag)
                            {
                                System.out.println("Slot is not available in the given time");
                            }


                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter the time in HH:mm format.");
                            break;
                        }
                        break;
                    case 4:
                        System.out.println("Booking Details: ");
                        Utility.getBookingDetails(userID);
                        break;
                    case 5:
                        System.out.println("You have been logged out successfully");
                        return;
                    default:
                        System.out.println("Please enter a valid option");
                        break;
                }
            }
        } else {
            throw new UserValidationException("Incorrect username or password, please try again");
        }


    }

//    public static void loginAdmin() throws UserValidationException {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Please enter your adminID and password to login");
//
//        System.out.println();
//
//        System.out.println("Admin ID: ");
//
//        int adminID = sc.nextInt();
//
//        System.out.println();
//
//        System.out.println("Please enter your password: ");
//
//        String password = sc.next();
//
//        if (UserLoginService.adminLogin(adminID, password)) {
//            System.out.println("Login successful...");
//
//            System.out.println();
//
//            System.out.println("**** Admin Dashboard ****");
//
//            System.out.println();
//
//            System.out.println("1. Get details of all available turfs");
//
//            System.out.println();
//
//            System.out.println("2. Add a new turf");
//
//            System.out.println();
//
//            System.out.println("3. Add a new slot to a turf");
//
//            System.out.println();
//
//            System.out.println("4. Logout");
//
//            System.out.println();
//
//            while(true)
//            {
//                System.out.println("Please select an option from the Admin Dashboard: ");
//
//                int option=sc.nextInt();
//
//                switch(option)
//                {
//                    case 1:
//                        Utility.getAllTurfDetails();
//                        break;
//
//                    case 2:
//
//                        System.out.println("Please enter the turf type: ");
//
//                        String turfType=sc.next();
//
//                        System.out.println("Please enter the turf ID: ");
//
//                        int turfID=sc.nextInt();
//
//                        System.out.println("Please enter the turf name: ");
//
//                        String turfName=sc.next();
//
//                        System.out.println("Please enter the turf location: ");
//
//                        String turfLocation=sc.next();
//
//                        System.out.println();
//
//                        System.out.println("Please enter the player capacity: ");
//
//                        int playerCapacity=sc.nextInt();
//
//                        if(turfType.equals("CricketTurf"))
//                        {
//                            System.out.println("Please enter the pitch length: ");
//
//                            int pitchLength=sc.nextInt();
//
//                            System.out.println("Please enter the pitch breadth: ");
//
//                            int pitchBreadth=sc.nextInt();
//
//                            CricketTurf cricketTurf=new CricketTurf(turfID,turfName,turfLocation,playerCapacity,pitchLength,pitchBreadth);
//
//                            Utility.turfList.add(cricketTurf);
//                        }
//
//                        else if(turfType.equals("ArtificialGrassTurf"))
//                        {
//                            ArtificialGrassTurf artificialGrassTurf=new ArtificialGrassTurf(turfID,turfName,turfLocation,playerCapacity);
//
//                            Utility.turfList.add(artificialGrassTurf);
//                        }
//
//                        else if(turfType.equals("NaturalGrassTurf"))
//                        {
//                            NatualGrassTurf natualGrassTurf=new NatualGrassTurf(turfID,turfName,turfLocation,playerCapacity);
//
//                            Utility.turfList.add(natualGrassTurf);
//                        }
//
//                        else
//                        {
//                            System.out.println("Please enter a valid turf type");
//                        }
//
//
//
//
//
//                }
//            }
//
//        }
//    }
}
