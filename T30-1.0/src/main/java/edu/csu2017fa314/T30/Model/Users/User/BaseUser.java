package edu.csu2017fa314.T30.Model.Users.User;

import edu.csu2017fa314.T30.Model.Interfaces.BaseInterfaceUSERS;
import edu.csu2017fa314.T30.Model.Interfaces.UserInterface.UserInterface;

public abstract class BaseUser implements BaseInterfaceUSERS<User>, UserInterface {
    public abstract String getAllData();
    public abstract String search(String searchVal);
    public abstract void addUser (User user);
    public abstract String Bio();
}
