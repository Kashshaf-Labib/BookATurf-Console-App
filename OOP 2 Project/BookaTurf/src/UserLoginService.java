public class UserLoginService {

    public static boolean userLogin(int userID,String password){

        for(User user:Utility.userList)
        {
            if(user.userID==userID && user.getPassword().equals(password))
            {
                return true;
            }
        }

        return false;

    }
}