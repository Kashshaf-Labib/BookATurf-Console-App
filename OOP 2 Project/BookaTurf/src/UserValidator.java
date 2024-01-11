public class UserValidator {

    public static boolean checkDuplicateUserName(String username)
    {
        if(Utility.userList.isEmpty())
        {
            return false;
        }
        return Utility.userList.stream()
                .anyMatch(user -> user.userName.equals(username));
    }

    public static boolean checkDuplicateUserID(int userID)
    {
        if(Utility.userList.isEmpty())
        {
            return false;
        }
        return Utility.userList.stream()
                .anyMatch(user -> user.userID==userID);
    }
}
