public class Book {

    public int slotID;

    public int turfID;

    public int bookID;

    public Book(int slotID,int turfID,int bookID)
    {
        this.slotID=slotID;
        this.turfID=turfID;
        this.bookID=bookID;
    }

    public void getBookingDetails()
    {
        System.out.println("Booking ID: "+this.bookID+"\nTurf ID: "+this.turfID+"\nSlot ID: "+this.slotID);
    }
}
