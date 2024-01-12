public class UserRegistrationService {

    public static void registerUser(String userName,String userEmail,String password) throws UserValidationException
    {
        if(!UserValidator.checkDuplicateUserName(userName))
        {
            int userID=RandomNumberGenerator.generateRandomNumber(10000,99999);
            while(UserValidator.checkDuplicateUserID(userID))
            {
                userID=RandomNumberGenerator.generateRandomNumber(10000,99999);
            }
            User user=new User(userName,userEmail);
            user.userID=userID;
            user.setPassword(password);
            Utility.userList.add(user);
            System.out.println("User Registered Successfully");
            System.out.println("User ID: "+user.userID);
            System.out.println("User Name: "+user.userName);
            System.out.println("User Email: "+user.userEmail);

        }
        else
        {
            throw new UserValidationException("Username already exists, please try again with a different username");
        }

    }

}
