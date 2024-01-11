public class BookingService {

    public void bookSlot(IBook book,int slotID,int amount)
    {
        Book bookedSlot=book.bookSlot(slotID,amount);
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
