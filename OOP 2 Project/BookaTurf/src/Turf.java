import java.util.ArrayList;
import java.util.List;

public abstract class Turf implements IAvailability, IDetails, IBook{

    public int turfID;

    public String turfName;

    public String turfLocation;

    public int playerCapacity;

    public List<TurfSlot> turfSlotList;


}
