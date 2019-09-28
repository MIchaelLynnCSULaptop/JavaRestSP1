package edu.csu2017fa314.T30.Model.Interfaces;

import edu.csu2017fa314.T30.Model.Users.Guest.Guest;
import edu.csu2017fa314.T30.Model.Users.User.User;

public interface BaseInterfaceUSERS<T> {


    public String getAllData();
    public String search(String searchVal);
    public void addUser (T user);

}
