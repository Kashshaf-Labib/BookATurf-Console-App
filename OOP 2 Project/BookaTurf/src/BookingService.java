public class BookingService {

    public static void bookSlot(IBook turf,int slotID,int amount,int userID)
    {
        Book bookedSlot=turf.bookSlot(slotID,amount);
        if(bookedSlot!=null)
        {
            User user=Utility.getUserbyID(userID);
            if(user!=null)
            {
                user.bookingList.add(bookedSlot);
                System.out.println("Slot booked successfully");
            }
            else
            {
                System.out.println("User not found, booking unsuccessful");
            }
        }
        else
        {
            System.out.println("Booking Unsuccessful");
        }
    }


}
