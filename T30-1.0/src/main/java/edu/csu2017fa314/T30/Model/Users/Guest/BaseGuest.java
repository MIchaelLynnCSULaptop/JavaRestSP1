package edu.csu2017fa314.T30.Model.Users.Guest;

import edu.csu2017fa314.T30.Model.Interfaces.BaseInterfaceUSERS;

public abstract class BaseGuest implements BaseInterfaceUSERS<Guest> {

    public abstract String getAllData();
    public abstract String search(String searchVal);
    public abstract void addUser (Guest user);

}
