import java.time.LocalTime;

public interface IAvailability {

    public int isSlotAvailable(LocalTime startingTime, LocalTime endingTime);
}
