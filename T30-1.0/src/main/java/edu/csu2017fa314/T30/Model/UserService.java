package edu.csu2017fa314.T30.Model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class UserService implements BaseInterfaceCrud, InterfaceCrudUser {

    ArrayList<User> users;
    Gson gson;

   public UserService(){
        users = new ArrayList<User>();
        gson = new Gson();
    }

    public String getAllData() {
        // Convert Java objects to JSON
        String json = gson.toJson(users);
        System.out.println(json);
        return json;
    }

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

    public void addUser (User user){
        users.add(user);
    }

}
