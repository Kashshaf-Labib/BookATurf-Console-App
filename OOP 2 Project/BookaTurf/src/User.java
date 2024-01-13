import java.util.ArrayList;
import java.util.List;

public class User {
    public int userID;
    public String userName;
    public String userEmail;
    private String password;

    public List<Book> bookingList=new ArrayList<>();



    public String getPassword()
    {
        return this.password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }

    public User(String userName,String userEmail)
    {
        this.userName=userName;
        this.userEmail=userEmail;
    }


    
}
