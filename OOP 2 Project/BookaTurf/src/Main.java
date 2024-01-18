import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DurationException {

        TurfSlot slot1=new TurfSlot(1, LocalTime.of(8,0),LocalTime.of(9,0));

        TurfSlot slot2=new TurfSlot(2, LocalTime.of(3,0),LocalTime.of(4,0));

        TurfSlot slot3=new TurfSlot(3, LocalTime.of(20,0),LocalTime.of(22,30));

        SlotPricingService.setSlotPrice(slot1);

        SlotPricingService.setSlotPrice(slot2);

        SlotPricingService.setSlotPrice(slot3);

        ArtificialGrassTurf artificialGrassTurf=new ArtificialGrassTurf(1,"Turf 1","Location 1",10);

        artificialGrassTurf.turfSlotList.add(slot1);

        artificialGrassTurf.turfSlotList.add(slot2);

        artificialGrassTurf.turfSlotList.add(slot3);

        NatualGrassTurf natualGrassTurf=new NatualGrassTurf(2,"Turf 2","Location 2",8);

        natualGrassTurf.turfSlotList.add(slot1);

        natualGrassTurf.turfSlotList.add(slot2);

        natualGrassTurf.turfSlotList.add(slot3);

        CricketTurf cricketTurf=new CricketTurf(3,"Turf 3","Location 3",10,20,30);

        cricketTurf.turfSlotList.add(slot1);

        cricketTurf.turfSlotList.add(slot2);

        cricketTurf.turfSlotList.add(slot3);

        Utility.turfList.add(artificialGrassTurf);

        Utility.turfList.add(natualGrassTurf);

        Utility.turfList.add(cricketTurf);





        System.out.println("****** Welcome to BookATurf ******");

        System.out.println();

        System.out.println("1. Register as a customer");

        System.out.println();

        System.out.println("2. Login as a Customer");

        System.out.println();

        System.out.println("3. Exit");

        System.out.println();

        Scanner sc=new Scanner(System.in);


        while(true)
        {

            System.out.println("Please select an option from the home page:");

            int option=sc.nextInt();

            switch(option)
            {
                case 1:
                    try {
                        UserInterface.registerCustomer();
                    } catch (UserValidationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        UserInterface.loginCustomer();
                    } catch (UserValidationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                System.out.println("Thank you for using BookATurf");
                return;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }

        }

    }
}

//TODO : Check the Main code with test cases