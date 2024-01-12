import java.time.LocalTime;
import java.util.List;

public class CricketTurf extends Turf implements IDetails,IAvailability,IBook
{

    public int pitchLength;

    public int pitchBreadth;
    public CricketTurf(int turfID, String turfName, String turfLocation, int playerCapacity, List<TurfSlot> turfSlotList,int pitchLength,int pitchBreadth)
    {
        this.turfID=turfID;
        this.turfName=turfName;
        this.turfLocation=turfLocation;
        this.playerCapacity=playerCapacity;
        this.turfSlotList=turfSlotList;
        this.pitchLength=pitchLength;
        this.pitchBreadth=pitchBreadth;
    }

    @Override
    public void getDetails(int turfID) {

        System.out.println("Turf ID: "+turfID);
        System.out.println("Turf Name: "+turfName);
        System.out.println("Turf Location: "+turfLocation);
        System.out.println("Player Capacity: "+playerCapacity);
        System.out.println("Turf Type: Cricket Turf");
        System.out.println("Pitch Length: "+pitchLength);
        System.out.println("Pitch Breadth: "+pitchBreadth);
        System.out.println("Turf Slot Details:");
        if(!turfSlotList.isEmpty())
        {
            for(TurfSlot turfSlot:turfSlotList) {
                System.out.println(turfSlot.getSlotDetails());
            }
        }
        else
        {
            System.out.println("No slots available currently");
        }
    }


    @Override
    public int isSlotAvailable(LocalTime startingTime, LocalTime endingTime) {
        for(TurfSlot turfSlot:turfSlotList)
        {
            if(turfSlot.startingTime.equals(startingTime) && turfSlot.endingTime.equals(endingTime))
            {
                return turfID;
            }
        }
        return -1;
    }

    @Override
    public Book bookSlot(int slotID,int amount)
    {
        Book book=null;
        for(TurfSlot turfSlot:turfSlotList)
        {
            if(turfSlot.slotID==slotID)
            {
                if(!turfSlot.isBooked())
                {
                    if(amount>=turfSlot.getSlotPrice())
                    {
                        int bookID=RandomNumberGenerator.generateRandomNumber(1000,2000);
                        turfSlot.setBooked(true);
                        book=new Book(slotID,turfID,bookID);
                        break;
                    }
                    else
                    {
                        System.out.println("Insufficient amount");
                        return null;
                    }

                }
                else
                {
                    System.out.println("Slot is already booked");
                    return null;
                }
            }
            else
            {
                System.out.println("Please enter a valid slot ID");
                return null;
            }
        }
        return book;
    }


}