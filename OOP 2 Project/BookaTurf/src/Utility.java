import java.util.ArrayList;
import java.util.List;

public class Utility
{

    public static List<User> userList=new ArrayList<>();

    public static List<Turf> turfList=new ArrayList<>();

    public static void getAllUserDetails()
    {
        if(!userList.isEmpty())
        {
            for(User user:userList)
            {
                System.out.println("User ID: "+user.userID+"; User Name: "+user.userName+"; User Email: "+user.userEmail);
            }

        }
        else
        {
            System.out.println("No users registered yet");
        }

    }

    public static User getUserbyID(int userID)
    {
        User user=null;
        if(!userList.isEmpty())
        {
            for(User u:userList)
            {
                if(u.userID==userID)
                {
                    user=u;
                    break;
                }
            }

            return user;

        }
        else
        {
            return null;
        }

    }

    public static void getAllTurfDetails()
    {
        if(!turfList.isEmpty())
        {
            for(Turf turf:turfList)
            {
                System.out.println("***Available Turf Details:***");
                System.out.println("Turf ID: "+turf.turfID+"; Turf Name: "+turf.turfName+"; Turf Location: "+turf.turfLocation+"; Turf Capacity: "+turf.playerCapacity);
                System.out.println();
                System.out.println("***Available Slots***");
                if(!turf.turfSlotList.isEmpty())
                {
                    for(TurfSlot turfSlot:turf.turfSlotList)
                    {
                        System.out.println("Slot ID: "+turfSlot.slotID+"; Starting Time: "+turfSlot.startingTime+"; Ending Time: "+turfSlot.endingTime+"; Slot Price: "+turfSlot.getSlotPrice());
                    }
                    System.out.println();
                }
                else
                {
                    System.out.println("No slots available currently");
                    System.out.println();
                }
            }

        }
        else
        {
            System.out.println("No available turfs in the system currently");
        }

    }

    public static void getBookingDetails(int userID)
    {
        User user=getUserbyID(userID);
        if(user!=null)
        {
            if(!user.bookingList.isEmpty())
            {
                for(Book book:user.bookingList)
                {
                    book.getBookingDetails();
                }
            }
            else
            {
                System.out.println("No bookings done yet");
            }
        }
        else
        {
            System.out.println("User not found");
        }
    }


}
