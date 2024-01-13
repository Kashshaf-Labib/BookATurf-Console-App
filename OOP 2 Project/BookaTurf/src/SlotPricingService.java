import java.time.Duration;

public class SlotPricingService {

    public static void setSlotPrice(TurfSlot slot) throws DurationException {

        Duration duration=Duration.between(slot.startingTime,slot.endingTime);

        if(duration.toHours()<1)
        {
            throw new DurationException("Duration of a slot has to be at least 1 hour");
        }
        else if(duration.toHours()<2)
        {
            slot.setSlotPrice(1000);
        }
        else
        {
            slot.setSlotPrice(1500);
        }
    }
}
