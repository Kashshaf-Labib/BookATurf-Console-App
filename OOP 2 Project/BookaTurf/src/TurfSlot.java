import java.time.LocalTime;

public class TurfSlot {

    public int slotID;

    public LocalTime startingTime;

    public LocalTime endingTime;

    private int slotPrice;

    private boolean isBooked=false;

    public boolean isBooked()
    {
        return this.isBooked;
    }

    public void setBooked(boolean booked)
    {
        isBooked = booked;
    }

    public int getSlotPrice()
    {
        return this.slotPrice;
    }

    public void setSlotPrice(int slotPrice)
    {
        this.slotPrice=slotPrice;
    }

    public TurfSlot(int slotID,LocalTime startingTime,LocalTime endingTime)
    {
        this.slotID=slotID;
        this.startingTime=startingTime;
        this.endingTime=endingTime;
    }
    public String getSlotDetails()
    {
        return "Slot ID: "+this.slotID+"\nTime: "+this.startingTime+"-"+this.endingTime+"\nPrice: "+this.slotPrice+" Availability: "+(this.isBooked()? "Booked":"Available");
    }



}
