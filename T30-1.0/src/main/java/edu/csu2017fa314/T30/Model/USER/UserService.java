package edu.csu2017fa314.T30.Model.USER;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.USER.BaseUser;
import edu.csu2017fa314.T30.Model.USER.User;

import java.util.ArrayList;

public class UserService extends BaseUser {

    ArrayList<User> users;
    Gson gson;

   public UserService(){
        users = new ArrayList<User>();
        gson = new Gson();
    }

    @Override
    public String getAllData() {
        // Convert Java objects to JSON
        String json = gson.toJson(users);
        System.out.println(json);
        return json;
    }

    @Override
    public String search(String searchVal) {
       User myUser = new User();

        // get single object entry
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).email.equals(searchVal)) {
                myUser = users.get(i);
            }
        }
        String json = gson.toJson(myUser);
        System.out.println(json);
        return json;
    }

    @Override
    public void addUser (User user){
        users.add(user);
    }

}
