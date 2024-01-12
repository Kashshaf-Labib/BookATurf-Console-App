import java.util.ArrayList;
import java.util.List;

public class Utility
{
    public static List<Admin> adminList=new ArrayList<>();

    public static List<User> userList=new ArrayList<>();

    public static List<Turf> turfList=new ArrayList<>();

    public static void getAllAdminDetails()
    {
        for(Admin admin:adminList)
        {
            System.out.println("Admin ID: "+admin.getAdminID()+"; Admin Name: "+admin.getName()+"; Admin Role: "+admin.getAdminID());
        }
    }

    public static void getAllUserDetails()
    {
        for(User user:userList)
        {
            System.out.println("User ID: "+user.userID+"; User Name: "+user.userName+"; User Email: "+user.userEmail);
        }
    }

    public static void getAllTurfDetails()
    {
        for(Turf turf:turfList)
        {
            System.out.println("Turf ID: "+turf.turfID+"; Turf Name: "+turf.turfName+"; Turf Location: "+turf.turfLocation+"; Turf Capacity: "+turf.playerCapacity);
        }
    }


}
