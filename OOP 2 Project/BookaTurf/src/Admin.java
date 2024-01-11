public class Admin {

    private int adminID;

    public String adminName;

    private String adminRole;


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


    public void setAdminRole(String adminRole)
    {
        this.adminRole=adminRole;
    }

    public String getAdminRole()
    {
        return this.adminRole;
    }


}
