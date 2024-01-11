import java.time.LocalTime;

public class SlotAvailabilityService {

    public int isSlotAvailable(IAvailability turf, LocalTime startingTime, LocalTime endingTime)
    {
        return turf.isSlotAvailable(startingTime, endingTime);
    }
}
