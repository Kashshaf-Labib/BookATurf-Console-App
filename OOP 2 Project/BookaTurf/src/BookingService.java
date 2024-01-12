public class BookingService {

    public static void bookSlot(IBook turf,int slotID,int amount)
    {
        Book bookedSlot=turf.bookSlot(slotID,amount);
        if(bookedSlot!=null)
        {
            System.out.println("Slot booked successfully");
        }
        else
        {
            System.out.println("Booking Unsuccessful");
        }
    }


}
