package io.muic.ooc.webapp.security;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService extends Database{
    private Map<String,User> users =  new HashMap<>();

    public UserService(){
        try {
            returnHashmap(users);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User findByUsername(String username){
        return users.get(username);
    }

    public boolean checkIfUserExists(String username){
        return users.containsKey(username);
    }




}
