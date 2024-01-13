import java.time.LocalTime;

public class SlotAvailabilityService {

    public static int isSlotAvailable(IAvailability turf, LocalTime startingTime, LocalTime endingTime)
    {
        return turf.isSlotAvailable(startingTime, endingTime);
    }
}
