public class Admin {

    public int adminID;

    public String adminName;

    public String adminRole;

    public String password;


    public void setAdminID(int adminID)
    {
        this.adminID=adminID;
    }

    public int getAdminID()
    {
        return this.adminID;
    }

    public String getName()
    {
        return this.adminName;
    }


    public Admin(int adminID,String adminName,String adminRole,String password)
    {
        this.adminID=adminID;
        this.adminName=adminName;
        this.adminRole=adminRole;
        this.password=password;
    }



}
